package com.njupt.service.impl;

import com.njupt.dao.SingerDao;
import com.njupt.entity.Singer;
import com.njupt.service.SingerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/05/21:21
 * @Description:
 */
@Service
public class SingerServiceImpl implements SingerService {
    @Resource
    SingerDao singerDao;

    @Override
    public Boolean insert(Singer singer) {
        int insert = singerDao.insert(singer);
        return insert>0;
    }

    @Override
    public boolean update(Singer singer) {
        int update = singerDao.update(singer);

        return update>0;
    }

    @Override
    public boolean deleteById(Integer id) {
        int i = singerDao.deleteById(id);
        return i>0;
    }

    @Override
    public Singer queryById(Integer id) {
        Singer singer = singerDao.queryById(id);
        return singer;
    }

    @Override
    public List<Singer> queryAll() {
        List<Singer> singers = singerDao.queryAll();
        return singers;
    }

    @Override
    public List<Singer> page(Integer number, Integer pageSize) {
        List<Singer> page = singerDao.page((number-1)*pageSize, pageSize);
        return page;
    }
}
