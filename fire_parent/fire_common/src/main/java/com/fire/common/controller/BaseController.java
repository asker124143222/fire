package com.fire.common.controller;

import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Long companyId;
    protected String companyName;
    protected Claims claims;

    //被@ModelAttribute注释的方法会在每个继承BaseController的子类Controller每个方法执行前被执行
    @ModelAttribute
    public void setResAnReq(HttpServletRequest request,HttpServletResponse response) {
        this.request = request;
        this.response = response;
        Object obj = request.getAttribute("user_claims");

        if(obj != null) {
            this.claims = (Claims) obj;
            this.companyId =   ((Integer)claims.get("companyId")).longValue();
            this.companyName = (String)claims.get("companyName");
        }
    }

}
