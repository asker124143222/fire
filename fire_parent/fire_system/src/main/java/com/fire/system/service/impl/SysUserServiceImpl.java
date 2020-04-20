package com.fire.system.service.impl;

import com.fire.common.utils.IdWorker;
import com.fire.entity.system.SysUser;
import com.fire.system.dao.SysUserDao;
import com.fire.system.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-18 23:16:57
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private IdWorker idWorker;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Long id) {
        return this.sysUserDao.queryById(id);
    }

    @Override
    public List<SysUser> queryAll(SysUser sysUser) {
        return sysUserDao.queryAll(sysUser);
    }

    @Override
    public PageInfo<SysUser> queryByPage(SysUser sysUser,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(sysUserDao.queryAll(sysUser));
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        sysUser.setId(idWorker.nextId());
        sysUser.setPassword(sysUser.getMobile());
        sysUser.setCreateTime(new Date());
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        sysUser.setUpdateTime(new Date());
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserDao.deleteById(id) > 0;
    }

    /**
     * 分别角色，一个用户可以分配多个角色
     *
     * @param id      用户id
     * @param roleIds 角色id
     */
    @Override
    public void assignRoles(Long id, List<Long> roleIds) {

    }
}