package com.njupt.service;

import com.njupt.entity.Singer;

import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/05/21:20
 * @Description:
 */
public interface SingerService {

    Boolean insert(Singer singer);

    boolean update(Singer singer);

    boolean deleteById(Integer id);

    Singer queryById(Integer id);

    List<Singer> queryAll();

    List<Singer> page(Integer number,Integer pageSize);
}
