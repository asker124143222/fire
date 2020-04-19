package com.fire.entity.system;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysPermissionPoint)实体类
 *
 * @author xu.dm
 * @since 2020-04-19 16:31:12
 */
@Data
public class SysPermissionPoint implements Serializable {
    private static final long serialVersionUID = -37735486351007076L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 按钮类型
    */
    private String pointClass;
    /**
    * 按钮icon
    */
    private String pointIcon;
    /**
    * 状态
    */
    private Integer pointStatus;


}