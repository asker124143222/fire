package com.fire.system.service;

import com.fire.entity.system.SysPermission;
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

    SysUser queryByMobile(String mobile);

    /**
     * 通过userId查询用户的权限
     * @param userId
     * @return List<SysPermission>
     */
    List<SysPermission> queryByUserId(Long userId);

    /**
     * 通过userId查询用户的权限code列表
     * @param userId
     * @return List<String>
     */
    List<String> queryPermCodeByUserId(Long userId);
}