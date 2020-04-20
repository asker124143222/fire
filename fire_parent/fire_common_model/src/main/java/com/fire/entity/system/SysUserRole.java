package com.fire.entity.system;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysUserRole)实体类
 *
 * @author xu.dm
 * @since 2020-04-20 13:26:17
 */
@Data
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -84769374002887727L;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 用户ID
    */
    private Long userId;

}