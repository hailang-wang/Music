package com.njupt.service;

import com.njupt.entity.Song;

import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/06/16:11
 * @Description:
 */
public interface SongService {

    Boolean insert(Song song);

    boolean update(Song song);

    boolean deleteById(Integer id);

    Song queryById(Integer id);

    int queryByName(String name);

    List<Song> queryAll();

    //按照歌名模糊查询
    List<Song> queryLike(String name);

    List<Song> page(Integer number,Integer pageSize);
}
