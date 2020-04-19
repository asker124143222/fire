package com.fire.entity.system;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysPermissionApi)实体类
 *
 * @author xu.dm
 * @since 2020-04-19 16:30:33
 */
@Data
public class SysPermissionApi implements Serializable {
    private static final long serialVersionUID = -16221311955043016L;
    /**
    * 主键ID
    */
    private Long id;
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


}