package com.fire.entity.company;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (CoCompany)实体类
 *
 * @author xu.dm
 * @since 2020-04-17 11:03:28
 */
@Data
@NoArgsConstructor
public class CoCompany implements Serializable {
    private static final long serialVersionUID = -70602871622981306L;
    /**
    * ID
    */
    private Long id;
    /**
    * 公司名称
    */
    private String name;
    /**
    * 企业登录账号ID
    */
    private Long managerId;
    /**
    * 当前版本
    */
    private String version;
    /**
    * 续期时间
    */
    private Date renewalDate;
    /**
    * 到期时间
    */
    private Date expirationDate;
    /**
    * 公司地区
    */
    private String companyArea;
    /**
    * 公司地址
    */
    private String companyAddress;
    /**
    * 营业执照-图片ID
    */
    private String businessLicenseId;
    /**
    * 法人代表
    */
    private String legalRepresentative;
    /**
    * 公司电话
    */
    private String companyPhone;
    /**
    * 邮箱
    */
    private String mailbox;
    /**
    * 公司规模
    */
    private String companySize;
    /**
    * 所属行业
    */
    private String industry;
    /**
    * 备注
    */
    private String remarks;
    /**
    * 审核状态
    */
    private String auditState;
    /**
    * 状态
    */
    private Integer state;
    /**
    * 当前余额
    */
    private double balance;
    /**
    * 创建时间
    */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}