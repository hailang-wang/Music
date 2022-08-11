package com.njupt.dao;

import com.njupt.entity.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/14:23
 * @Description:
 */
@Mapper
public interface ListSongDao {
    //根据前台传来的歌单id,查找歌单内所有的歌曲
    List<Song> showSongInTheList(Integer listId);

    //在歌单的界面希望增加编辑按钮，可以增删改查歌单里的歌
    //增加,这个song的id可以通过输入的歌曲名进行模糊查询
    int insertList(Integer songId,Integer listId);

    int deleteList(Integer songId,Integer listId);


}
