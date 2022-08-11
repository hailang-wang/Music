package com.njupt.controller;

import com.alibaba.fastjson.JSONObject;
import com.njupt.entity.Customer;
import com.njupt.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/21:18
 * @Description:
 */
@RestController
public class CustomerController {

    @Resource
    private CustomerService customerService;


    //用户的登录验证
    //用户的注册，在注册时不可以有重复的用户名和密码，因此要先查找用户名和密码是否已经存在

    @GetMapping("/customer/all")
    public Object queryAll(){
        List<Customer> customers = customerService.queryAll();
        JSONObject jsonObject = new JSONObject();
        if(customers!=null){
            jsonObject.put("code","1");
            jsonObject.put("msg","查询成功");
            return jsonObject;
        }else {
            jsonObject.put("code","0");
            jsonObject.put("msg","查询失败");
            return jsonObject;
        }
    }

    @GetMapping("/customer/man")
    public Object queryAllMan(){
        int num= customerService.queryMan();
        JSONObject jsonObject = new JSONObject();
        if(num!=0){
            jsonObject.put("code","1");
            jsonObject.put("msg","查询成功");
            jsonObject.put("男人总数为",num);
            return jsonObject;
        }else {
            jsonObject.put("code","0");
            jsonObject.put("msg","查询失败");
            return jsonObject;
        }
    }
    @PostMapping("/customer/deleteById")
    public Object deleteById(HttpServletRequest request){
        String id = request.getParameter("id");
        boolean b = customerService.deleteById(Integer.valueOf(id));
        JSONObject jsonObject = new JSONObject();
        if(b){
            jsonObject.put("code","1");
            jsonObject.put("msg","删除成功");
            return jsonObject;
        }
        else {
            jsonObject.put("code","0");
            jsonObject.put("msg","删除失败");
            return jsonObject;
        }
    }

    @PostMapping("/customer/update")
    public Object update(HttpServletRequest request,@RequestParam("img") MultipartFile img){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex=request.getParameter("sex");
        String phoneNum = request.getParameter("phoneNum");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String introduction = request.getParameter("introduction");
        String location=request.getParameter("location");
        String createTime=request.getParameter("createTime");


        //首先处理时间问题
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date current = new Date();
        String currentTime = simpleDateFormat.format(current);

        //System.out.println(currentTime);
        Date MyCreateTime=new Date();
        Date mybirth=new Date();
        Date updateTime=new Date();

        try {
            mybirth = simpleDateFormat.parse(birth);
            MyCreateTime = simpleDateFormat.parse(createTime);
            updateTime = simpleDateFormat.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //处理上传的照片问题
        String filename = img.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "avatarImages" ;
        String pic="/avatarImages/"+filename;

        File file = new File(filePath + System.getProperty("file.separator") + filename);
        try {
            img.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Customer customer = new Customer();
        customer.setId(Integer.valueOf(id));
        customer.setCreateTime(MyCreateTime);
        customer.setEmail(email);
        customer.setIntroduction(introduction);
        customer.setPassword(password);
        customer.setLocation(location);
        customer.setSex(Integer.valueOf(sex));
        customer.setAvator(pic);
        customer.setBirth(mybirth);
        customer.setPhoneNum(phoneNum);
        customer.setUsername(name);
        customer.setUpdateTime(updateTime);

        boolean b = customerService.update(customer);
        JSONObject jsonObject = new JSONObject();
        if(b){
            jsonObject.put("code","1");
            jsonObject.put("msg","修改成功");
            return jsonObject;
        }
        else {
            jsonObject.put("code","0");
            jsonObject.put("msg","修改失败");
            return jsonObject;
        }
    }

}
