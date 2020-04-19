package com.fire.system.service.impl;

import com.fire.common.utils.IdWorker;
import com.fire.entity.system.SysRole;
import com.fire.system.dao.SysRoleDao;
import com.fire.system.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (SysRole)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-19 13:30:16
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;

    @Resource
    private IdWorker idWorker;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRole queryById(Long id) {
        return this.sysRoleDao.queryById(id);
    }

    @Override
    public List<SysRole> queryAll(SysRole sysRole) {
        return sysRoleDao.queryAll(sysRole);
    }

    @Override
    public PageInfo<SysRole> queryByPage(SysRole sysRole, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sysRoleDao.queryAll(sysRole));
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRole> queryAllByLimit(int offset, int limit) {
        return this.sysRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole insert(SysRole sysRole) {
        sysRole.setId(idWorker.nextId());
        sysRole.setCreateTime(new Date());
        this.sysRoleDao.insert(sysRole);
        return sysRole;
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole update(SysRole sysRole) {
        sysRole.setUpdateTime(new Date());
        this.sysRoleDao.update(sysRole);
        return this.queryById(sysRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysRoleDao.deleteById(id) > 0;
    }
}