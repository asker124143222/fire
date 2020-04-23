package com.fire.entity.company;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (CoDepartment)实体类
 *
 * @author xu.dm
 * @since 2020-04-20 10:32:57
 */
@Data
@NoArgsConstructor
public class CoDepartment implements Serializable {
    private static final long serialVersionUID = 836330082093016610L;
    
    private Long id;
    /**
    * 企业ID
    */
    private Long companyId;
    /**
    * 父级部门ID
    */
    private Long pid;
    /**
    * 部门名称
    */
    private String name;
    /**
    * 部门编码
    */
    private String code;
    /**
    * 负责人ID
    */
    private Long managerId;
    /**
    * 部门负责人
    */
    private String manager;
    /**
    * 介绍
    */
    private String introduce;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

}