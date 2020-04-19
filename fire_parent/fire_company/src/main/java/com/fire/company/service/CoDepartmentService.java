package com.fire.company.service;

import com.fire.entity.company.CoDepartment;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (CoDepartment)表服务接口
 *
 * @author xu.dm
 * @since 2020-04-18 16:22:09
 */
public interface CoDepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CoDepartment queryById(Long id);

    List<CoDepartment> queryAll(CoDepartment coDepartment);

    PageInfo<CoDepartment> queryByPage(CoDepartment coDepartment,int pageNum, int pageSize);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CoDepartment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param coDepartment 实例对象
     * @return 实例对象
     */
    CoDepartment insert(CoDepartment coDepartment);

    /**
     * 修改数据
     *
     * @param coDepartment 实例对象
     * @return 实例对象
     */
    CoDepartment update(CoDepartment coDepartment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}