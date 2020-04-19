package com.fire.system.service;

import com.fire.entity.system.SysPermissionApi;
import java.util.List;

/**
 * (SysPermissionApi)表服务接口
 *
 * @author xu.dm
 * @since 2020-04-19 16:30:33
 */
public interface SysPermissionApiService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermissionApi queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysPermissionApi> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysPermissionApi 实例对象
     * @return 实例对象
     */
    SysPermissionApi insert(SysPermissionApi sysPermissionApi);

    /**
     * 修改数据
     *
     * @param sysPermissionApi 实例对象
     * @return 实例对象
     */
    SysPermissionApi update(SysPermissionApi sysPermissionApi);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}