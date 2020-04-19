package com.fire.system.service.impl;

import com.fire.entity.system.SysPermissionApi;
import com.fire.system.dao.SysPermissionApiDao;
import com.fire.system.service.SysPermissionApiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysPermissionApi)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-19 16:30:33
 */
@Service("sysPermissionApiService")
public class SysPermissionApiServiceImpl implements SysPermissionApiService {
    @Resource
    private SysPermissionApiDao sysPermissionApiDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysPermissionApi queryById(Long id) {
        return this.sysPermissionApiDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysPermissionApi> queryAllByLimit(int offset, int limit) {
        return this.sysPermissionApiDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysPermissionApi 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermissionApi insert(SysPermissionApi sysPermissionApi) {
        this.sysPermissionApiDao.insert(sysPermissionApi);
        return sysPermissionApi;
    }

    /**
     * 修改数据
     *
     * @param sysPermissionApi 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermissionApi update(SysPermissionApi sysPermissionApi) {
        this.sysPermissionApiDao.update(sysPermissionApi);
        return this.queryById(sysPermissionApi.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysPermissionApiDao.deleteById(id) > 0;
    }
}