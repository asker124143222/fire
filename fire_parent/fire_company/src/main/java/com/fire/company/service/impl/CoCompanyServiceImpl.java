package com.fire.company.service.impl;

import com.fire.common.utils.IdWorker;
import com.fire.entity.company.CoCompany;
import com.fire.company.dao.CoCompanyDao;
import com.fire.company.service.CoCompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (CoCompany)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-17 11:03:35
 */
@Service("coCompanyService")
public class CoCompanyServiceImpl implements CoCompanyService {
    @Resource
    private CoCompanyDao coCompanyDao;

    @Resource
    private IdWorker idWorker;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CoCompany queryById(Long id) {
        return this.coCompanyDao.queryById(id);
    }

    @Override
    public List<CoCompany> queryAll(CoCompany coCompany) {
        return coCompanyDao.queryAll(coCompany);
    }

    @Override
    public PageInfo<CoCompany> queryByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CoCompany> lists = coCompanyDao.queryAll(null);
        return new PageInfo<>(lists);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CoCompany> queryAllByLimit(int offset, int limit) {
        return this.coCompanyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param coCompany 实例对象
     * @return 实例对象
     */
    @Override
    public CoCompany insert(CoCompany coCompany) {
        //设置id
        coCompany.setId(idWorker.nextId());

        coCompany.setCreateTime(new Date());
        this.coCompanyDao.insert(coCompany);

        return coCompany;
    }

    /**
     * 修改数据
     *
     * @param coCompany 实例对象
     * @return 实例对象
     */
    @Override
    public CoCompany update(CoCompany coCompany) {
        coCompany.setUpdateTime(new Date());
        this.coCompanyDao.update(coCompany);
        return this.queryById(coCompany.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.coCompanyDao.deleteById(id) > 0;
    }
}