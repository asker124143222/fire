package com.fire.company.service.impl;

import com.fire.common.utils.IdWorker;
import com.fire.entity.company.CoDepartment;
import com.fire.company.dao.CoDepartmentDao;
import com.fire.company.service.CoDepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (CoDepartment)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-18 16:22:09
 */
@Service("coDepartmentService")
public class CoDepartmentServiceImpl implements CoDepartmentService {
    @Resource
    private CoDepartmentDao coDepartmentDao;

    @Resource
    private IdWorker idWorker;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CoDepartment queryById(Long id) {
        return this.coDepartmentDao.queryById(id);
    }

    @Override
    public List<CoDepartment> queryAll(CoDepartment coCompany) {
        return coDepartmentDao.queryAll(coCompany);
    }

    @Override
    public PageInfo<CoDepartment> queryByPage(CoDepartment coDepartment,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(coDepartmentDao.queryAll(coDepartment));
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CoDepartment> queryAllByLimit(int offset, int limit) {
        return this.coDepartmentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param coDepartment 实例对象
     * @return 实例对象
     */
    @Override
    public CoDepartment insert(CoDepartment coDepartment) {
        coDepartment.setId(idWorker.nextId());
        coDepartment.setCreateTime(new Date());
        this.coDepartmentDao.insert(coDepartment);
        return coDepartment;
    }

    /**
     * 修改数据
     *
     * @param coDepartment 实例对象
     * @return 实例对象
     */
    @Override
    public CoDepartment update(CoDepartment coDepartment) {
        coDepartment.setUpdateTime(new Date());
        this.coDepartmentDao.update(coDepartment);
        return this.queryById(coDepartment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.coDepartmentDao.deleteById(id) > 0;
    }
}