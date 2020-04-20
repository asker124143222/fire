package com.fire.system.service;

import com.fire.entity.system.SysRolePermission;
import java.util.List;

/**
 * (SysRolePermission)表服务接口
 *
 * @author xu.dm
 * @since 2020-04-20 13:27:22
 */
public interface SysRolePermissionService {

    //通过角色id获取权限id列表
    List<Long> queryById(Long roleId);

    //为角色分配权限
    int insertByBatch(List<SysRolePermission> list) throws Exception;

    //根据角色删除权限
    int deleteById(Long roleId);

}