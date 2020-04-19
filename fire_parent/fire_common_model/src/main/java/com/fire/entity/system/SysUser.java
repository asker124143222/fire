package com.fire.entity.system;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author xu.dm
 * @since 2020-04-18 23:16:53
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -59964887569822493L;
    /**
    * ID
    */
    private Long id;
    /**
    * 手机号码
    */
    private String mobile;
    /**
    * 用户名称
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 启用状态 0是禁用，1是启用
    */
    private Integer enableState;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 部门ID
    */
    private Long departmentId;
    /**
    * 入职时间
    */
    private Date timeOfEntry;
    /**
    * 聘用形式
    */
    private Integer formOfEmployment;
    /**
    * 工号
    */
    private String workNumber;
    /**
    * 管理形式
    */
    private String formOfManagement;
    /**
    * 工作城市
    */
    private String workingCity;
    /**
    * 转正时间
    */
    private Date correctionTime;
    /**
    * 在职状态 1.在职  2.离职
    */
    private Integer inServiceStatus;
    /**
    * 企业ID
    */
    private Long companyId;
    
    private String companyName;
    
    private String departmentName;
    /**
    * 用户级别：saasAdmin，coAdmin，user
    */
    private String level;
    /**
    * 照片地址
    */
    private String staffPhoto;
    /**
    * 更新时间
    */
    private Date updateTime;

}