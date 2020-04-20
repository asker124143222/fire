package com.fire.system.dao;

import com.fire.entity.system.SysRolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (SysRolePermission)表数据库访问层
 *
 * @author xu.dm
 * @since 2020-04-20 13:27:22
 */
public interface SysRolePermissionDao {

    //通过角色id查询权限id列表
    @Select("select permission_id from sys_role_permission where role_id=#{roleId}")
    List<Long> queryById(Long roleId);

    //为角色分配权限
    @Insert({
            "<script>",
            "insert into sys_role_permission(role_id,permission_id) values ",
            "<foreach collection='list' item='item' index='index' separator=','>",
            "(#{item.roleId}, #{item.permissionId})",
            "</foreach>",
            "</script>"
    })
    int insertByBatch(@Param("list") List<SysRolePermission> list);

    //删除角色下所有权限
    @Delete("delete from sys_role_permission where role_id=#{roleId}")
    int deleteById(Long roleId);

    //查询permissionId的子权限
    @Select("select #{roleId},id as permissionId from sys_permission a where a.pid = #{permissionId} and a.type=#{type}")
    List<SysRolePermission> queryByTypeAndPid(@Param("roleId") Long roleId,@Param("type") int type,@Param("permissionId") Long permissionId);

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

    //检查permissionId是否在sys_permission中存在，传入permissionId集合，返回count数量，
    // 如果传入数量与返回数量不等，则存在异常permissionId
    @Select({
            "<script>",
            "select count(0) from sys_permission where id in ",
            "<foreach collection='permissionIds' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</script>"
    })
    Integer checkPermissionId(@Param(value = "permissionIds") List<Long> permissionIds);
}