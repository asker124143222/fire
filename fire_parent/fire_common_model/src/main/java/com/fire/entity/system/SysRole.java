package com.fire.entity.system;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author xu.dm
 * @since 2020-04-19 13:30:16
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = 524400651848437473L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 权限名称
    */
    private String name;
    /**
    * 说明
    */
    private String description;
    /**
    * 企业id
    */
    private Long companyId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;



}