package com.njupt.service.impl;

import com.njupt.dao.SongDao;
import com.njupt.entity.Song;
import com.njupt.service.SongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/06/16:12
 * @Description:
 */
@Service
public class SongServiceImpl implements SongService {

    @Resource
    private SongDao songDao;

    @Override
    public Boolean insert(Song song) {

        int insert = songDao.insert(song);
        return insert>0;
    }

    @Override
    public boolean update(Song song) {
        int update = songDao.update(song);
        return update>0;
    }

    @Override
    public boolean deleteById(Integer id) {
        int i = songDao.deleteById(id);
        return i>0;
    }

    @Override
    public Song queryById(Integer id) {

        return songDao.queryById(id);
    }

    /*根据歌曲的名字查询出歌曲的id*/
    @Override
    public int  queryByName(String name) {
        return songDao.queryByName(name);
    }

    @Override
    public List<Song> queryAll() {

        return songDao.queryAll();
    }

    @Override
    public List<Song> queryLike(String name) {
        String real="%"+name+"%";
        return songDao.queryLike(real);
    }

    @Override
    public List<Song> page(Integer number, Integer pageSize) {
        return songDao.page((number-1)*pageSize,pageSize);
    }
}
