package com.fire.entity.system;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * (SysRolePermission)实体类
 *
 * @author xu.dm
 * @since 2020-04-20 13:27:22
 */
@Data
@AllArgsConstructor
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = -71385915666619202L;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 权限ID
    */
    private Long permissionId;

}