package com.fire.system.service.impl;

import com.fire.common.utils.PermissionConstants;
import com.fire.entity.system.SysRolePermission;
import com.fire.system.dao.SysRolePermissionDao;
import com.fire.system.service.SysRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * (SysRolePermission)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-20 13:27:22
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private SysRolePermissionDao sysRolePermissionDao;

    @Override
    public List<Long> queryById(Long roleId) {
        return sysRolePermissionDao.queryById(roleId);
    }

    @Transactional
    @Override
    public int insertByBatch(List<SysRolePermission> list) throws Exception {
        //分配权限时，页面菜单和按钮自动给与API的权限
        //除了pid=0的API，菜单和按钮必然是API权限的上级，所以需要将以菜单和按钮为父类的API权限自动加入到分配表中
        Set<SysRolePermission> permissions = new HashSet<>();
        Set<Long> roleIds = new HashSet<>();
        Set<Long> permIds = new HashSet<>();
        for (SysRolePermission rolePermission : list) {
            Long roleId = rolePermission.getRoleId();
            Long permId = rolePermission.getPermissionId();
            roleIds.add(roleId);
            permIds.add(permId);
            //查找菜单或者按钮下的api子权限
            List<SysRolePermission> apiList =
                    sysRolePermissionDao.queryByTypeAndPid(
                            roleId,
                            PermissionConstants.PERMISSION_API,
                            permId);
            permissions.addAll(apiList); //加入api权限
            permissions.add(rolePermission);//加入当前菜单或者按钮权限
        }

        //加入对roleId和permId合法性校验
        if(permIds.size() > 0){
            int count = sysRolePermissionDao.checkPermissionId(new ArrayList<>(permIds));
            if(count!=permIds.size())
            {
                logger.warn("存在不合法的permId:"+permIds.toString()+"，合法count:"+count );
                throw new Exception("存在不合法的permIds："+permIds.toString());
            }
        }

        if(roleIds.size() > 0){
            int count = sysRolePermissionDao.checkRoleId(new ArrayList<>(roleIds));
            if(count!=roleIds.size()){
                logger.warn("存在不合法的roleId:"+roleIds.toString()+"，合法count:"+count );
                throw new Exception("存在不合法的roleId："+roleIds.toString());
            }
        }

        //先删除权限，然后再新增
        for (Long id : roleIds) {
            sysRolePermissionDao.deleteById(id);
        }
        return sysRolePermissionDao.insertByBatch(new ArrayList<>(permissions));
    }

    @Override
    public int deleteById(Long roleId) {
        return sysRolePermissionDao.deleteById(roleId);
    }
}