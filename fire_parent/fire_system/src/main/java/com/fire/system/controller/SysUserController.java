package com.fire.system.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fire.common.controller.BaseController;
import com.fire.common.model.Result;
import com.fire.common.model.StatusCode;
import com.fire.entity.company.CoCompany;
import com.fire.entity.system.SysUser;
import com.fire.entity.system.SysUserRole;
import com.fire.entity.system.vo.UserVO;
import com.fire.system.client.CompanyFeignClient;
import com.fire.system.service.SysUserRoleService;
import com.fire.system.service.SysUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * (SysUser)表控制层
 *
 * @author xu.dm
 * @since 2020-04-18 23:16:57
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class SysUserController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysUserRoleService sysUserRoleService;

    @Resource
    private CompanyFeignClient companyFeignClient;

    //测试使用
    @GetMapping("/company/{userId}")
    public CoCompany findCompanyDetailByUserId(@PathVariable Long userId) throws JsonProcessingException {
        List<CoCompany> companies = companyFeignClient.selectAll();
        SysUser user = sysUserService.queryById(userId);
        for (CoCompany company : companies) {
            if(company.getId().equals(user.getCompanyId())){
                return company;
            }
        }
        return null;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return UserVO 单条数据
     */
    @GetMapping("{id}")
    public UserVO selectOne(@PathVariable Long id) {
        SysUser user = this.sysUserService.queryById(id);
        if(user == null) return null;
        UserVO userVO = new UserVO(user);

        Set<Long> roleIds = new HashSet<>(this.sysUserRoleService.queryByUserId(id));
        userVO.setRoleIds(roleIds);

        return userVO;
    }

    @GetMapping
    public List<SysUser> getAllUser() {
        SysUser sysUser = new SysUser();
        sysUser.setCompanyId(super.companyId);
        return sysUserService.queryAll(sysUser);
    }

    @GetMapping("/page/{pageNum}/{pageSize}")
    public PageInfo<SysUser> getUserByPage(@RequestBody SysUser sysUser, @PathVariable int pageNum, @PathVariable int pageSize) {
        sysUser.setCompanyId(super.companyId);
        return sysUserService.queryByPage(sysUser, pageNum, pageSize);
    }

    @PostMapping(name = "POINT-USER-ADD")
    public Result<SysUser> insert(@RequestBody SysUser sysUser) {
        sysUser.setCompanyId(super.companyId);
        sysUser.setCompanyName(super.companyName);
        return new Result<>(true, StatusCode.OK, "新增完成", sysUserService.insert(sysUser));
    }

    @PutMapping
    public Result<SysUser> update(@RequestBody SysUser sysUser) {
        return new Result<>(true, StatusCode.OK, "修改完成", sysUserService.update(sysUser));
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Long id) {
        if (sysUserService.deleteById(id)) {
            return new Result(true, StatusCode.OK, "删除成功");
        } else {
            return new Result(false, StatusCode.OK, "删除失败");
        }
    }


    //批量更新角色，可以对多个不用的userId操作，无论新增、更新、删除用户角色，都是调用此方法
    @PutMapping("/role")
    public Result<Integer> insertUserRole(@RequestBody List<SysUserRole> list) throws Exception {
        int count = sysUserRoleService.insertByBatch(list);
        return new Result<>(true, StatusCode.OK, "更新完成", count);
    }

    //根据userId查询角色id列表
    @GetMapping("/role/{userId}")
    public List<Long> queryRoleByUserId(@PathVariable Long userId) {
        return sysUserRoleService.queryByUserId(userId);
    }

}