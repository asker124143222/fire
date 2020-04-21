package com.fire.system.controller;

import com.fire.common.model.Result;
import com.fire.common.model.StatusCode;
import com.fire.common.utils.JwtUtils;
import com.fire.entity.system.SysPermission;
import com.fire.entity.system.SysUser;
import com.fire.entity.system.vo.ProfileVO;
import com.fire.system.service.SysPermissionService;
import com.fire.system.service.SysUserService;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xu.dm
 * @Date: 2020/4/21 15:32
 * @Version: 1.0
 * @Description: 登录
 **/
@Controller
@RestController
@CrossOrigin
public class HomeController {
    private final String SAAS_ADMIN ="saasAdmin";
    private final String CO_ADMIN ="coAdmin";
    private final String CO_USER ="user";

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysPermissionService sysPermissionService;

    @Resource
    private JwtUtils jwtUtils;

    /**
     * 用户登录
     *  1.通过service根据mobile查询用户
     *  2.比较password
     *  3.生成jwt信息
     *
     */
    @PostMapping({"/","/login"})
    public Result<String> login(@RequestBody Map<String,String> loginMap) {
        String mobile = loginMap.get("mobile");
        String password = loginMap.get("password");
        SysUser user = sysUserService.queryByMobile(mobile);
        //登录失败
        if(user == null || !user.getPassword().equals(password)) {
            return new Result<>(false, StatusCode.LOGINERROR,"登录失败");
        }else {
            //登录成功
            Map<String,Object> map = new HashMap<>();
            map.put("companyId",user.getCompanyId());
            map.put("companyName",user.getCompanyName());
            String token = jwtUtils.createJwt(user.getId().toString(), user.getUsername(), map);
            return new Result<>(true,StatusCode.OK,"登录成功",token);
        }
    }

    /**
     * 用户登录成功之后，获取用户信息
     *      1.获取用户id
     *      2.根据用户id查询用户
     *      3.构建返回值对象
     *      4.响应
     */
    @PostMapping("/profile")
    public Result<ProfileVO> profile(HttpServletRequest request) throws Exception {
        /**
         * 从请求头信息中获取token数据
         *   1.获取请求头信息：名称=Authorization
         *   2.替换Bearer+空格
         *   3.解析token
         *   4.获取clamis
         */
        //1.获取请求头信息：名称=Authorization
        String authorization = request.getHeader("Authorization");
        if(StringUtils.isEmpty(authorization)) {
            throw new Exception("Authorization failed");
        }
        //2.替换Bearer+空格
        String token = authorization.replace("Bearer ","");
        //3.解析token
        Claims claims = jwtUtils.parseJwt(token);
        Long userId = Long.parseLong(claims.getId());

        SysUser user = this.sysUserService.queryById(userId);
        List<SysPermission> permissions = null;
        String level = user.getLevel();

        if(this.CO_USER.equals(level)){
            permissions = this.sysUserService.queryByUserId(userId);
        }else {
            SysPermission perm = new SysPermission();
            if(this.CO_ADMIN.equals(level)){
                //如果是coAdmin用户获取企业内部所有权限
                perm.setEnVisible(1);
            }else if (this.SAAS_ADMIN.equals(user.getLevel())){
                //如果是saasAdmin用户获取应用所有权限
            }else{
                throw new Exception("未知类型用户");
            }
            permissions = sysPermissionService.queryAll(perm);
        }
        ProfileVO result = new ProfileVO(user,permissions);
        return new Result<ProfileVO>(true,StatusCode.OK,"获取权限成功",result);
    }

}
