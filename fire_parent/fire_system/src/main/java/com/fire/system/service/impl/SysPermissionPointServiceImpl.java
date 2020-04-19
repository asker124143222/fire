package com.fire.system.service.impl;

import com.fire.entity.system.SysPermissionPoint;
import com.fire.system.dao.SysPermissionPointDao;
import com.fire.system.service.SysPermissionPointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysPermissionPoint)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-19 16:31:12
 */
@Service("sysPermissionPointService")
public class SysPermissionPointServiceImpl implements SysPermissionPointService {
    @Resource
    private SysPermissionPointDao sysPermissionPointDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysPermissionPoint queryById(Long id) {
        return this.sysPermissionPointDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysPermissionPoint> queryAllByLimit(int offset, int limit) {
        return this.sysPermissionPointDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysPermissionPoint 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermissionPoint insert(SysPermissionPoint sysPermissionPoint) {
        this.sysPermissionPointDao.insert(sysPermissionPoint);
        return sysPermissionPoint;
    }

    /**
     * 修改数据
     *
     * @param sysPermissionPoint 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermissionPoint update(SysPermissionPoint sysPermissionPoint) {
        this.sysPermissionPointDao.update(sysPermissionPoint);
        return this.queryById(sysPermissionPoint.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysPermissionPointDao.deleteById(id) > 0;
    }
}