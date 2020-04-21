package com.fire.system.dao;

import com.fire.entity.system.SysPermission;
import com.fire.entity.system.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author xu.dm
 * @since 2020-04-18 23:16:55
 */
public interface SysUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    List<SysUser> queryAll(SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    @Select("select * from sys_user where mobile=#{mobile}")
    SysUser queryByMobile(String mobile);


    /**
     * 通过userId查询用户的权限
     * @param userId
     * @return List<SysPermission>
     */
    @Select("select a.* from sys_permission a\n" +
            "inner join sys_role_permission b on b.permission_id=a.id\n" +
            "inner join sys_user_role c on c.role_id=b.role_id and c.user_id=#{userId}")
    List<SysPermission> queryByUserId(Long userId);

}