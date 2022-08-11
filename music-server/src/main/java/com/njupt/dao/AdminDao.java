package com.njupt.dao;

import com.njupt.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/05/19:34
 * @Description:
 */
@Mapper
public interface AdminDao {
    Admin queryAdmin(String name,String password);
    //插入用户
    int insertAdmin(Admin admin);

    int updatePassword(String name,String password);
}
