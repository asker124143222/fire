package com.fire.entity.system.vo;

import com.fire.entity.system.SysRole;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xu.dm
 * @Date: 2020/4/21 11:33
 * @Version: 1.0
 * @Description: TODO
 **/
@Data
public class RoleVO extends SysRole implements Serializable {
    private Set<Long> permIds = new HashSet<>();

    public RoleVO(SysRole sysRole) {
        BeanUtils.copyProperties(sysRole,this);
    }
}
