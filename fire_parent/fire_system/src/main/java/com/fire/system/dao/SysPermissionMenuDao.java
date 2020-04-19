package com.fire.system.dao;

import com.fire.entity.system.SysPermissionMenu;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SysPermissionMenu)表数据库访问层
 *
 * @author xu.dm
 * @since 2020-04-19 16:31:00
 */
public interface SysPermissionMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermissionMenu queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysPermissionMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysPermissionMenu 实例对象
     * @return 对象列表
     */
    List<SysPermissionMenu> queryAll(SysPermissionMenu sysPermissionMenu);

    /**
     * 新增数据
     *
     * @param sysPermissionMenu 实例对象
     * @return 影响行数
     */
    int insert(SysPermissionMenu sysPermissionMenu);

    /**
     * 修改数据
     *
     * @param sysPermissionMenu 实例对象
     * @return 影响行数
     */
    int update(SysPermissionMenu sysPermissionMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}