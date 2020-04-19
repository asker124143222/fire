package com.fire.entity.system;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysPermission)实体类
 *
 * @author xu.dm
 * @since 2020-04-19 15:02:33
 */
@Data
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 384497280493092106L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 权限描述
    */
    private String description;
    /**
    * 权限名称
    */
    private String name;
    /**
    * 权限类型 1为菜单 2为功能 3为API
    */
    private Integer type;
    /**
    * 主键
    */
    private Long pid;
    
    private String code;
    /**
    * 企业可见性 0：不可见，1：可见
    */
    private Integer enVisible;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;


}