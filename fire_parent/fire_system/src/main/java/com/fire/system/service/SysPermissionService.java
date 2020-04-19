package com.fire.system.service;

import com.fire.common.exception.CommonException;
import com.fire.entity.system.SysPermission;
import com.fire.entity.system.vo.PermissionVO;

import java.util.List;

/**
 * (SysPermission)表服务接口
 *
 * @author xu.dm
 * @since 2020-04-19 15:02:33
 */
public interface SysPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PermissionVO queryById(Long id) throws Exception;

    List<SysPermission> queryAll(SysPermission sysPermission);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysPermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param vo 实例对象
     * @return 实例对象
     */
    PermissionVO insert(PermissionVO vo) throws Exception;

    /**
     * 修改数据
     *
     * @param vo 实例对象
     * @return 实例对象
     */
    PermissionVO update(PermissionVO vo) throws Exception;

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id) throws CommonException;

}