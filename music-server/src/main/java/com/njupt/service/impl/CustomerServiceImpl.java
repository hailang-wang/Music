package com.njupt.service.impl;

import com.njupt.dao.CustomerDao;
import com.njupt.entity.Customer;
import com.njupt.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/21:16
 * @Description:
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;

    @Override
    public List<Customer> queryAll() {
        return customerDao.queryAll();
    }

    @Override
    public int queryMan() {
        System.out.println(customerDao.queryMan());
        return customerDao.queryMan();
    }

    @Override
    public boolean deleteById(Integer id) {
        return customerDao.deleteById(id)>0;
    }

    @Override
    public boolean update(Customer customer) {
        return customerDao.update(customer)>0;
    }


    @Override
    public Customer login(String name, String password) {
        return customerDao.login(name,password);
    }

    @Override
    public Customer verify(String name, String phone) {
        return customerDao.verify(name,phone);
    }
}
