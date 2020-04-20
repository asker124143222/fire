package com.fire.system.dao;

import com.fire.entity.system.SysUserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (SysUserRole)表数据库访问层
 *
 * @author xu.dm
 * @since 2020-04-20 13:26:27
 */
public interface SysUserRoleDao {

    /**
     * 通过userId查询角色列表
     *
     * @param userId
     * @return 角色id列表
     */
    @Select("select role_id from sys_user_role where user_id=#{userId}")
    List<Long> queryByUserId(Long userId);


    /**
     * 新增角色数据
     *
     * @param roles 入参SysUserRole集合
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into sys_user_role(user_id,role_id) values ",
            "<foreach collection='roles' item='item' index='index' separator=','>",
            "(#{item.userId}, #{item.roleId})",
            "</foreach>",
            "</script>"
    })
    int insertByBatch(@Param(value = "roles") List<SysUserRole> roles);


    /**
     * 单行插入
     *
     * @param sysUserRole
     * @return
     */
    @Insert("insert into sys_user_role values(#{userId},#{roleId})")
    int insert(SysUserRole sysUserRole);

    /**
     * 通过userId删除角色
     *
     * @param userId
     * @return 影响行数
     */
    @Delete("delete from sys_user_role where user_id=#{userId}")
    int deleteById(Long userId);


    //检查userId是否在sys_user中存在，传入userId集合，返回count数量，
    // 如果传入数量与返回数量不等，则存在异常userId
    @Select({
            "<script>",
            "select count(0) from sys_user where id in ",
            "<foreach collection='userIds' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</script>"
    })
    Integer checkUserId(@Param(value = "userIds") List<Long> userIds);

    //检查roleId是否在sys_role中存在，传入roleId集合，返回count数量，
    // 如果传入数量与返回数量不等，则存在异常roleId
    @Select({
            "<script>",
            "select count(0) from sys_role where id in ",
            "<foreach collection='roleIds' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</script>"
    })
    Integer checkRoleId(@Param(value = "roleIds") List<Long> roleIds);
}