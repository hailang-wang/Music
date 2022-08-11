package com.njupt.service.impl;

import com.njupt.dao.ListSongDao;
import com.njupt.dao.SongDao;
import com.njupt.entity.Song;
import com.njupt.service.ListSongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/14:36
 * @Description:
 */
@Service
public class ListSongServiceImpl implements ListSongService {
    @Resource
    ListSongDao listSongDao;
    @Resource
    SongDao songDao;
    @Override
    public List<Song> showSongInTheList(Integer listId) {
        return listSongDao.showSongInTheList(listId);
    }

    //作用是给歌单插入歌曲，只需要传过来歌名，就可以进行插入到所属的歌单
    @Override
    public boolean insertList(String songName, Integer listId) {
        int songId = songDao.queryByName(songName);
        int i1 = listSongDao.insertList(songId, listId);
        return i1>0;
    }

    @Override
    public boolean deleteList(String songName, Integer listId) {
        int songId = songDao.queryByName(songName);
        int i = listSongDao.deleteList(songId, listId);
        return i>0;
    }
}
