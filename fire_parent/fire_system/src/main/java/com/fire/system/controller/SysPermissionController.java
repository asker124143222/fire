package com.fire.system.controller;

import com.fire.common.exception.CommonException;
import com.fire.common.model.Result;
import com.fire.common.model.StatusCode;
import com.fire.entity.system.SysPermission;
import com.fire.entity.system.vo.PermissionVO;
import com.fire.system.service.SysPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysPermission)表控制层
 *
 * @author xu.dm
 * @since 2020-04-19 15:02:33
 */
@RestController
@RequestMapping("permission")
public class SysPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private SysPermissionService sysPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public PermissionVO selectOne(@PathVariable Long id) throws Exception {
        return this.sysPermissionService.queryById(id);
    }

    @GetMapping
    public List<SysPermission> getAll(@RequestBody SysPermission sysPermission){
        return sysPermissionService.queryAll(sysPermission);
    }

    @PostMapping
    public PermissionVO insert(@RequestBody PermissionVO vo) throws Exception {
        return sysPermissionService.insert(vo);
    }

    @PutMapping
    public PermissionVO update(@RequestBody PermissionVO vo) throws Exception {
        return sysPermissionService.update(vo);
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Long id) throws CommonException {
        if (sysPermissionService.deleteById(id)) {
            return new Result(true, StatusCode.OK, "删除成功");
        } else {
            return new Result(false, StatusCode.OK, "删除失败");
        }
    }
}