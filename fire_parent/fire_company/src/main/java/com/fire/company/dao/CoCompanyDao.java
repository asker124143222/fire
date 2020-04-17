package com.fire.company.dao;

import com.fire.entity.company.CoCompany;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CoCompany)表数据库访问层
 *
 * @author xu.dm
 * @since 2020-04-17 11:03:34
 */
public interface CoCompanyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CoCompany queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CoCompany> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param coCompany 实例对象
     * @return 对象列表
     */
    List<CoCompany> queryAll(CoCompany coCompany);

    /**
     * 新增数据
     *
     * @param coCompany 实例对象
     * @return 影响行数
     */
    int insert(CoCompany coCompany);

    /**
     * 修改数据
     *
     * @param coCompany 实例对象
     * @return 影响行数
     */
    int update(CoCompany coCompany);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}