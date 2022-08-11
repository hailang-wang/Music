package com.njupt.service;

import com.njupt.entity.Admin;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/05/19:47
 * @Description:
 */
public interface AdminService {
    boolean queryAdmin(String name,String password);
    boolean insertAdmin(Admin admin);

    boolean updatePassword(String name,String password);
}
