package com.fire.system.service.impl;

import com.fire.common.exception.CommonException;
import com.fire.common.model.StatusCode;
import com.fire.entity.system.SysUserRole;
import com.fire.system.dao.SysUserRoleDao;
import com.fire.system.service.SysUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * (SysUserRole)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-20 13:26:27
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleDao sysUserRoleDao;


    @Override
    public List<Long> queryByUserId(Long userId) {
        return sysUserRoleDao.queryByUserId(userId);
    }

    @Transactional
    @Override
    public int insertByBatch(List<SysUserRole> roles) throws Exception {
        Set<Long> set = new HashSet<>();
        //去重
        for (SysUserRole userRole : roles) {
            set.add(userRole.getUserId());
        }
        //加入对用户id和角色id合法性校验
        int count = sysUserRoleDao.checkUserId(new ArrayList<>(set));
        if(count!=set.size())
        {
            System.out.println("count:"+count+"  userId:"+set.toString());
            throw new Exception("存在不合法的userId："+set.toString());
        }

        //先删除再新增
        for (Long userId : set) {
            deleteById(userId);
        }
        return sysUserRoleDao.insertByBatch(roles);
    }

    @Override
    public int insert(SysUserRole sysUserRole) {
        return sysUserRoleDao.insert(sysUserRole);
    }


    @Override
    public int deleteById(Long userId) {
        return sysUserRoleDao.deleteById(userId);
    }
}