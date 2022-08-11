package com.njupt.service.impl;

import com.njupt.dao.SongListDao;
import com.njupt.entity.SongList;
import com.njupt.service.SongListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/12:23
 * @Description:
 */
@Service
public class SongListServiceImpl implements SongListService {

    @Resource
    SongListDao songListDao;
    @Override
    public List<SongList> queryByName(String style) {
        return songListDao.queryByName("%"+style+"%");
    }

    @Override
    public List<SongList> queryAll() {
        return songListDao.queryAll();
    }

    @Override
    public boolean insert(SongList songList) {
        return songListDao.insert(songList)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return songListDao.delete(id)>0;
    }

    @Override
    public boolean update(SongList songList) {
        return songListDao.update(songList)>0;
    }
}
