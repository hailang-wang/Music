package com.njupt.dao;

import com.njupt.entity.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/06/15:52
 * @Description:
 */
@Mapper
public interface SongDao {

    int insert(Song song);

    int update(Song song);

    int deleteById(Integer id);

    Song queryById(Integer id);
    //希望通过歌名查找返回哥的id，可以供列表歌单查询所属的歌
    int queryByName(String name);

    List<Song> queryAll();

    //按照歌名模糊查询
    List<Song> queryLike(String name);

    List<Song> page(Integer number,Integer pageSize);
}
