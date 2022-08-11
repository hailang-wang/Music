package com.njupt.dao;

import com.njupt.entity.SongList;
import org.apache.ibatis.annotations.Mapper;

import java.awt.*;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/11:54
 * @Description:
 */

@Mapper
public interface SongListDao {

    //按照名字模糊查询歌单
    List<SongList> queryByName(String style);
    //显示所有的歌单
    List<SongList> queryAll();
    //添加歌单
    int insert(SongList songList);
    //删除歌单
    int delete(Integer id);
    //更新歌单
    int update(SongList songList);

}
