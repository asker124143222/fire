package com.fire.system.service.impl;

import com.fire.entity.system.SysPermissionMenu;
import com.fire.system.dao.SysPermissionMenuDao;
import com.fire.system.service.SysPermissionMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysPermissionMenu)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-19 16:31:00
 */
@Service("sysPermissionMenuService")
public class SysPermissionMenuServiceImpl implements SysPermissionMenuService {
    @Resource
    private SysPermissionMenuDao sysPermissionMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysPermissionMenu queryById(Long id) {
        return this.sysPermissionMenuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysPermissionMenu> queryAllByLimit(int offset, int limit) {
        return this.sysPermissionMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysPermissionMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermissionMenu insert(SysPermissionMenu sysPermissionMenu) {
        this.sysPermissionMenuDao.insert(sysPermissionMenu);
        return sysPermissionMenu;
    }

    /**
     * 修改数据
     *
     * @param sysPermissionMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermissionMenu update(SysPermissionMenu sysPermissionMenu) {
        this.sysPermissionMenuDao.update(sysPermissionMenu);
        return this.queryById(sysPermissionMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysPermissionMenuDao.deleteById(id) > 0;
    }
}