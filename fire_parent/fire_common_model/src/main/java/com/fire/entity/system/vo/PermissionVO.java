package com.fire.entity.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xu.dm
 * @Date: 2020/4/19 17:26
 * @Description: 将权限、API、菜单、按钮组合成一个VO
 */
@Data
public class PermissionVO implements Serializable {
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
     * 父节点
     **/
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
    /**
     * 权限等级，1为通用接口权限，2为需校验接口权限
     */
    private String apiLevel;
    /**
     * 请求类型
     */
    private String apiMethod;
    /**
     * 链接
     */
    private String apiUrl;

    /**
     * 权限代码
     */
    private String menuIcon;
    /**
     * 序号
     */
    private String menuOrder;

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
