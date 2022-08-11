package com.njupt.dao;

import com.njupt.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/20:29
 * @Description:
 */
@Mapper
public interface CustomerDao {
    //查询所有的用户
    List<Customer> queryAll();
    //查询所有的男性guanzhong
    int queryMan();
    //删除用户
    int deleteById(Integer id);
    //更改用户的信息
    int update(Customer customer);
    //用户的登录验证
    Customer login(String name,String password);
    //用户忘记密码
    Customer verify(String name,String phone);
}
