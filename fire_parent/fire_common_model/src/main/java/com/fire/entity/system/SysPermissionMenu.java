package com.fire.entity.system;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysPermissionMenu)实体类
 *
 * @author xu.dm
 * @since 2020-04-19 16:31:00
 */
@Data
public class SysPermissionMenu implements Serializable {
    private static final long serialVersionUID = 806350776272615019L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 权限代码
    */
    private String menuIcon;
    /**
    * 序号
    */
    private String menuOrder;


}