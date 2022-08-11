package com.njupt.dao;

import com.njupt.entity.Singer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/05/20:57
 * @Description:
 */
@Mapper
public interface SingerDao {

    int insert(Singer singer);

    int update(Singer singer);

    int deleteById(Integer id);

    Singer queryById(Integer id);

    List<Singer> queryAll();

    List<Singer> page(Integer number,Integer pageSize);
}
