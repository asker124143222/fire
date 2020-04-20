package com.fire.system.service;

import com.fire.entity.system.SysUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author xu.dm
 * @since 2020-04-18 23:16:56
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Long id);

    List<SysUser> queryAll(SysUser sysUser);

    PageInfo<SysUser> queryByPage(SysUser sysUser, int pageNum, int pageSize);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 分别角色，一个用户可以分配多个角色
     *
     * @param id      用户id
     * @param roleIds 角色id
     */
    void assignRoles(Long id, List<Long> roleIds);

}