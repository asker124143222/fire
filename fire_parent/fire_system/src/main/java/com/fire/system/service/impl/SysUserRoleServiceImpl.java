package com.fire.system.service.impl;

import com.fire.entity.system.SysUserRole;
import com.fire.system.dao.SysUserRoleDao;
import com.fire.system.service.SysUserRoleService;
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
 * (SysUserRole)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-20 13:26:27
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private SysUserRoleDao sysUserRoleDao;


    @Override
    public List<Long> queryByUserId(Long userId) {
        return sysUserRoleDao.queryByUserId(userId);
    }

    /**
     * 批量给用户分别角色，用户可以是多个
     * @param roles
     * @return
     * @throws Exception
     */
    @Transactional
    @Override
    public int insertByBatch(List<SysUserRole> roles) throws Exception {
        Set<Long> userIdsSet = new HashSet<>();
        Set<Long> roleIdsSet = new HashSet<>();
        //去重
        for (SysUserRole userRole : roles) {
            userIdsSet.add(userRole.getUserId());
            roleIdsSet.add(userRole.getRoleId());
        }
        //加入对用户id和角色id合法性校验
        if(userIdsSet.size() > 0){
            int count = sysUserRoleDao.checkUserId(new ArrayList<>(userIdsSet));
            if(count!=userIdsSet.size())
            {
                logger.warn("存在不合法的userId:"+userIdsSet.toString()+"，合法count:"+count );
                throw new Exception("存在不合法的userId："+userIdsSet.toString());
            }
        }

        if(roleIdsSet.size() > 0){
            int count = sysUserRoleDao.checkRoleId(new ArrayList<>(roleIdsSet));
            if(count!=roleIdsSet.size()){
                logger.warn("存在不合法的roleId:"+roleIdsSet.toString()+"，合法count:"+count );
                throw new Exception("存在不合法的roleId："+roleIdsSet.toString());
            }
        }



        //先删除再新增
        for (Long userId : userIdsSet) {
            //必须调用dao里的deleteById，不能调用本类里的deleteById，否则事务将会失效
            //事务的原理是动态代理
            sysUserRoleDao.deleteById(userId);
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