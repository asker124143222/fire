package com.fire.system.service.impl;

import com.fire.common.exception.CommonException;
import com.fire.common.model.StatusCode;
import com.fire.common.utils.BeanMapUtils;
import com.fire.common.utils.IdWorker;
import com.fire.common.utils.PermissionConstants;
import com.fire.entity.system.SysPermission;
import com.fire.entity.system.SysPermissionApi;
import com.fire.entity.system.SysPermissionMenu;
import com.fire.entity.system.SysPermissionPoint;
import com.fire.entity.system.vo.PermissionVO;
import com.fire.system.dao.SysPermissionApiDao;
import com.fire.system.dao.SysPermissionDao;
import com.fire.system.dao.SysPermissionMenuDao;
import com.fire.system.dao.SysPermissionPointDao;
import com.fire.system.service.SysPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * (SysPermission)表服务实现类
 *
 * @author xu.dm
 * @since 2020-04-19 15:02:33
 */
@Transactional
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionDao sysPermissionDao;

    @Resource
    private SysPermissionMenuDao permissionMenuDao;

    @Resource
    private SysPermissionPointDao permissionPointDao;

    @Resource
    private SysPermissionApiDao permissionApiDao;

    @Resource
    private IdWorker idWorker;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return PermissionVO 实例对象
     */
    @Override
    public PermissionVO queryById(Long id) throws Exception {
        SysPermission perm = sysPermissionDao.queryById(id);
        if(perm == null) return null;
        int type = perm.getType();
        Object object = null;
        switch (type) {
            case PermissionConstants.PERMISSION_MENU:
                object = permissionMenuDao.queryById(id);
                break;
            case PermissionConstants.PERMISSION_POINT:
                object = permissionPointDao.queryById(id);
                break;
            case PermissionConstants.PERMISSION_API:
                object = permissionApiDao.queryById(id);
                break;
            default:
                throw new CommonException(StatusCode.ERROR,"未知权限类型");
        }

        Map<String, Object> map = BeanMapUtils.beanToMap(object);
        Map<String,Object> permMap = BeanMapUtils.beanToMap(perm);

        for(Map.Entry<String,Object> entry:permMap.entrySet()){
            map.put(entry.getKey(),entry.getValue());
        }

        return BeanMapUtils.mapToBean(map,PermissionVO.class);
    }

    @Override
    public List<SysPermission> queryAll(SysPermission sysPermission) {
        return this.sysPermissionDao.queryAll(sysPermission);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysPermission> queryAllByLimit(int offset, int limit) {
        return this.sysPermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param vo 实例对象
     * @return 实例对象
     */
    @Override
    public PermissionVO insert(PermissionVO vo) throws Exception {
        //设置主键的值
        Long id = idWorker.nextId();
        vo.setId(id);
        vo.setCreateTime(new Date());
        //分解视图对象到map，通过BeanMapUtils工具类将map分解到多个对象
        Map map = BeanMapUtils.beanToMap(vo);

        //1.通过map构造permission对象
        SysPermission  perm = BeanMapUtils.mapToBean(map,SysPermission.class);

        //2.根据类型构造不同的资源对象（菜单，按钮，api）
        int type = perm.getType();
        switch (type) {
            case PermissionConstants.PERMISSION_MENU:
                SysPermissionMenu menu = BeanMapUtils.mapToBean(map,SysPermissionMenu.class);
                menu.setId(id);
                permissionMenuDao.insert(menu);
                break;
            case PermissionConstants.PERMISSION_POINT:
                SysPermissionPoint point = BeanMapUtils.mapToBean(map,SysPermissionPoint.class);
                point.setId(id);
                permissionPointDao.insert(point);
                break;
            case PermissionConstants.PERMISSION_API:
                SysPermissionApi api = BeanMapUtils.mapToBean(map,SysPermissionApi.class);
                api.setId(id);
                permissionApiDao.insert(api);
                break;
            default:
                throw new CommonException(StatusCode.ERROR,"未知权限类型");
        }
        //3.保存
        sysPermissionDao.insert(perm);
        return vo;
    }

    /**
     * 修改数据
     *
     * @param vo 实例对象
     * @return 实例对象
     */
    @Override
    public PermissionVO update(PermissionVO vo) throws Exception {
        //设置主键的值
        Long id = vo.getId();
        //分解视图对象到map，通过BeanMapUtils工具类将map与
        vo.setUpdateTime(new Date());
        Map map = BeanMapUtils.beanToMap(vo);

        //1.通过map构造permission对象
        SysPermission  perm = BeanMapUtils.mapToBean(map,SysPermission.class);
//        perm.setUpdateTime(new Date());

        //2.根据类型构造不同的资源对象（菜单，按钮，api）
        int type = perm.getType();
        switch (type) {
            case PermissionConstants.PERMISSION_MENU:
                SysPermissionMenu menu = BeanMapUtils.mapToBean(map,SysPermissionMenu.class);
                menu.setId(id);
                permissionMenuDao.update(menu);
                break;
            case PermissionConstants.PERMISSION_POINT:
                SysPermissionPoint point = BeanMapUtils.mapToBean(map,SysPermissionPoint.class);
                point.setId(id);
                permissionPointDao.update(point);
                break;
            case PermissionConstants.PERMISSION_API:
                SysPermissionApi api = BeanMapUtils.mapToBean(map,SysPermissionApi.class);
                api.setId(id);
                permissionApiDao.update(api);
                break;
            default:
                throw new CommonException(StatusCode.ERROR,"未知权限类型");
        }
        //3.保存
        sysPermissionDao.update(perm);
        return vo;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) throws CommonException {
        int count = 0;

        SysPermission  perm = sysPermissionDao.queryById(id);

        count = this.sysPermissionDao.deleteById(id);


        //2.根据类型构造不同的资源对象（菜单，按钮，api）
        int type = perm.getType();
        switch (type) {
            case PermissionConstants.PERMISSION_MENU:
                count += permissionMenuDao.deleteById(id);
                break;
            case PermissionConstants.PERMISSION_POINT:
                count +=permissionPointDao.deleteById(id);
                break;
            case PermissionConstants.PERMISSION_API:
                count +=permissionApiDao.deleteById(id);
                break;
            default:
                throw new CommonException(StatusCode.ERROR,"未知权限类型");
        }

        return count > 0;
    }


    @Override
    public List<String> queryPermCodeAll(SysPermission sysPermission) {
        List<SysPermission> permissions = this.sysPermissionDao.queryAll(sysPermission);
        Set<String> codes = new HashSet<>();
        for (SysPermission permission : permissions) {
            codes.add(permission.getCode());
        }
        return new ArrayList<>(codes);
    }

}