package com.njupt.dao;

import com.njupt.entity.Rank;
import com.njupt.entity.SongList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/11:54
 * @Description:
 */

@Mapper
public interface RankDao {

    //评价歌单
    int insert(Rank rank);

    //根据歌单的id查到歌单的总分
    int selectSumScore(Integer songListId);

    //查找当前歌单评分的总人数
    int selectSumPeople(Integer songListId);

}
