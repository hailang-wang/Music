package com.njupt.service;

import com.njupt.entity.Rank;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/09/16:44
 * @Description:
 */
public interface RankService {
    //评价歌单
    boolean insert(Rank rank);

    //根据歌单的id查到歌单的总分
    Integer  selectSumScore(Integer songListId);

    //查找当前歌单评分的总人数
    Integer selectSumPeople(Integer songListId);
    /*计算歌单的平均分*/
    int avg(Integer songListId);
}
