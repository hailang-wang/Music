package com.njupt.service.impl;

import com.njupt.dao.AdminDao;
import com.njupt.entity.Admin;
import com.njupt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/05/19:48
 * @Description:
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao dao;
    @Override
    public boolean queryAdmin(String name, String password) {
        Admin admin = dao.queryAdmin(name, password);
        //System.out.println(admin);
        if(admin==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean insertAdmin(Admin admin) {
        int i = dao.insertAdmin(admin);
        return i>0;
    }

    @Override
    public boolean updatePassword(String name, String password) {
        if(queryAdmin(name,password)){
            int i = dao.updatePassword(name, password);
            return i>0;
        }else {
            return false;
        }
    }
}
