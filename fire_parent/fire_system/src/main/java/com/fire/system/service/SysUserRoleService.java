package com.fire.system.service;

import com.fire.common.exception.CommonException;
import com.fire.entity.system.SysUserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (SysUserRole)表服务接口
 *
 * @author xu.dm
 * @since 2020-04-20 13:26:27
 */
public interface SysUserRoleService {


    /**
     * 通过userId查询角色列表
     *
     * @param userId
     * @return 角色id列表
     */
    List<Long> queryByUserId(Long userId);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    int insert(SysUserRole sysUserRole);

    /**
     * 批量新增数据
     */
    int insertByBatch(List<SysUserRole> roles) throws Exception;

    /**
     * 通过userId删除角色列表
     *
     * @param userId
     * @return 影响行数
     */
    int deleteById(Long userId);

}