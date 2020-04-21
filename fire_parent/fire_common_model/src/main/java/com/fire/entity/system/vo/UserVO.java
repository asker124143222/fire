package com.fire.entity.system.vo;

import com.fire.entity.system.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xu.dm
 * @Date: 2020/4/21 10:58
 * @Version: 1.0
 * @Description: TODO
 **/
@EqualsAndHashCode(callSuper = false)
@Data
public class UserVO extends SysUser implements Serializable {
    private String password;//覆盖父类属性
    private Set<Long> roleIds = new HashSet<>();

    public UserVO(SysUser user) {
        BeanUtils.copyProperties(user, this);
        this.password = "";//隐藏密码
    }
}
