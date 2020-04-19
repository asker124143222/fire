package com.fire.system.controller;

import com.fire.common.controller.BaseController;
import com.fire.common.model.Result;
import com.fire.common.model.StatusCode;
import com.fire.entity.system.SysRole;
import com.fire.system.service.SysRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public SysRole selectOne(@PathVariable Long id) {
        return this.sysRoleService.queryById(id);
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

}