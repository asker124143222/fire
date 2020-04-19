package com.fire.system.service;

import com.fire.entity.system.SysRole;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SysRole)表服务接口
 *
 * @author xu.dm
 * @since 2020-04-19 13:30:16
 */
public interface SysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRole queryById(Long id);

    List<SysRole> queryAll(SysRole sysRole);

    PageInfo<SysRole> queryByPage(SysRole sysRole, int pageNum, int pageSize);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    SysRole insert(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    SysRole update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}