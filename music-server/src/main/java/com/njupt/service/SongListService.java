package com.njupt.service;

import com.njupt.entity.SongList;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/12:22
 * @Description:
 */

public interface SongListService {
    //按照名字模糊查询歌单
    List<SongList> queryByName(String style);
    //显示所有的歌单
    List<SongList> queryAll();
    //添加歌单
    boolean insert(SongList songList);
    //删除歌单
    boolean delete(Integer id);
    //更新歌单
    boolean update(SongList songList);

}
