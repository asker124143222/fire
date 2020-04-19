package com.fire.company.dao;

import com.fire.entity.company.CoDepartment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CoDepartment)表数据库访问层
 *
 * @author xu.dm
 * @since 2020-04-18 16:22:09
 */
public interface CoDepartmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CoDepartment queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CoDepartment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param coDepartment 实例对象
     * @return 对象列表
     */
    List<CoDepartment> queryAll(CoDepartment coDepartment);

    /**
     * 新增数据
     *
     * @param coDepartment 实例对象
     * @return 影响行数
     */
    int insert(CoDepartment coDepartment);

    /**
     * 修改数据
     *
     * @param coDepartment 实例对象
     * @return 影响行数
     */
    int update(CoDepartment coDepartment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}