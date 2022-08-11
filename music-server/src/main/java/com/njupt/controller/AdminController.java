package com.njupt.controller;

import com.alibaba.fastjson.JSONObject;
import com.njupt.entity.Admin;
import com.njupt.service.AdminService;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/05/19:50
 * @Description:
 */
@RestController
public class AdminController {
    @Resource
    private AdminService service;

    @PostMapping("/admin/login/status")
    public Object login(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if(service.queryAdmin(name, password)){
            jsonObject.put("code",1);
            jsonObject.put("msg","登陆成功！");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","登陆失败！");
            return jsonObject;
        }
    }

    @PostMapping("/admin/login/insert")
    public Object insert(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Admin admin = new Admin();
        admin.setId(null);
        admin.setName(name);
        admin.setPassword(password);
        if(service.insertAdmin(admin)){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功！");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","添加失败！");
            return jsonObject;
        }
    }
    @PostMapping("/admin/login/update")
    public Object update(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if(service.updatePassword(name,password)){
            jsonObject.put("code",1);
            jsonObject.put("msg","修改成功！");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","修改失败！可能没有该用户！");
            return jsonObject;
        }
    }

}
