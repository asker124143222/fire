package com.fire.system.dao;

import com.fire.entity.system.SysPermissionPoint;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SysPermissionPoint)表数据库访问层
 *
 * @author xu.dm
 * @since 2020-04-19 16:31:12
 */
public interface SysPermissionPointDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermissionPoint queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysPermissionPoint> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysPermissionPoint 实例对象
     * @return 对象列表
     */
    List<SysPermissionPoint> queryAll(SysPermissionPoint sysPermissionPoint);

    /**
     * 新增数据
     *
     * @param sysPermissionPoint 实例对象
     * @return 影响行数
     */
    int insert(SysPermissionPoint sysPermissionPoint);

    /**
     * 修改数据
     *
     * @param sysPermissionPoint 实例对象
     * @return 影响行数
     */
    int update(SysPermissionPoint sysPermissionPoint);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}