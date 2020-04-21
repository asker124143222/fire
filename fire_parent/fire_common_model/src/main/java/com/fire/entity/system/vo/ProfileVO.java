package com.fire.entity.system.vo;

import com.fire.common.utils.PermissionConstants;
import com.fire.entity.system.SysPermission;
import com.fire.entity.system.SysUser;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * @Author: xu.dm
 * @Date: 2020/4/21 16:33
 * @Version: 1.0
 * @Description: TODO
 **/
@Data
public class ProfileVO implements Serializable {
    private String mobile;
    private String username;
    private String company;
    private Map<String,Object> permMap = new HashMap<>();

    public ProfileVO(SysUser user, List<SysPermission> permissionList ) {
        this.mobile = user.getMobile();
        this.username =user.getUsername();
        this.company = user.getCompanyName();

        Set<String> menus = new HashSet<>();
        Set<String> points = new HashSet<>();
        Set<String> apis = new HashSet<>();

        for (SysPermission permission : permissionList) {
            switch (permission.getType()){
                case PermissionConstants.PERMISSION_MENU:
                    menus.add(permission.getCode());
                    break;
                case PermissionConstants.PERMISSION_POINT:
                    points.add(permission.getCode());
                    break;
                case PermissionConstants.PERMISSION_API:
                    apis.add(permission.getCode());
                    break;
                default:
                    break;
            }
        }
        this.permMap.put("menus",menus);
        this.permMap.put("points",points);
        this.permMap.put("apis",apis);
    }
}
