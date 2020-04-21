package com.fire.system.controller;

import com.fire.common.controller.BaseController;
import com.fire.common.model.Result;
import com.fire.common.model.StatusCode;
import com.fire.entity.system.SysRole;
import com.fire.entity.system.SysRolePermission;
import com.fire.entity.system.vo.RoleVO;
import com.fire.system.service.SysRolePermissionService;
import com.fire.system.service.SysRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * (SysRole)表控制层
 *
 * @author xu.dm
 * @since 2020-04-19 13:30:16
 */
@RestController
@RequestMapping("role")
@CrossOrigin
public class SysRoleController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysRolePermissionService sysRolePermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public RoleVO selectOne(@PathVariable Long id) {
        SysRole sysRole = this.sysRoleService.queryById(id);
        if(sysRole == null) return null;
        RoleVO vo = new RoleVO(sysRole);
        List<Long> permIds = this.sysRolePermissionService.queryById(id);
        Set<Long> set = new HashSet<>();
        set.addAll(permIds);
        vo.setPermIds(set);

        return vo;
    }

    @GetMapping
    public List<SysRole> getAllUser() {
        SysRole sysRole = new SysRole();
        sysRole.setCompanyId(super.companyId);
        return sysRoleService.queryAll(sysRole);
    }

    @GetMapping("/page/{pageNum}/{pageSize}")
    public PageInfo<SysRole> getUserByPage(@RequestBody SysRole sysRole, @PathVariable int pageNum, @PathVariable int pageSize) {
        sysRole.setCompanyId(super.companyId);
        return sysRoleService.queryByPage(sysRole, pageNum, pageSize);
    }

    @PostMapping
    public Result<SysRole> insert(@RequestBody SysRole sysRole) {
        sysRole.setCompanyId(super.companyId);
        return new Result<>(true, StatusCode.OK, "新增完成", sysRoleService.insert(sysRole));
    }

    @PutMapping
    public Result<SysRole> update(@RequestBody SysRole sysRole) {
        return new Result<>(true, StatusCode.OK, "修改完成", sysRoleService.update(sysRole));
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Long id) {
        if (sysRoleService.deleteById(id)) {
            return new Result(true, StatusCode.OK, "删除成功");
        } else {
            return new Result(false, StatusCode.OK, "删除失败");
        }
    }

    //批量更新角色的权限，可以对多个不用的roleId操作，无论新增、更新、删除用户角色，都是调用此方法
    @PutMapping("/permission")
    public Result<Integer> insertRolePermission(@RequestBody List<SysRolePermission> list) throws Exception {
        int count = this.sysRolePermissionService.insertByBatch(list);
        return new Result<>(true,StatusCode.OK,"更新成功",count);
    }

    //根据roleId查询权限id列表
    @GetMapping("/permission/{roleId}")
    public List<Long> queryPermissionByRole(@PathVariable Long roleId){
        return this.sysRolePermissionService.queryById(roleId);
    }

}