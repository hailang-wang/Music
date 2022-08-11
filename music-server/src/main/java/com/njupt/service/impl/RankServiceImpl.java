package com.njupt.service.impl;

import com.njupt.dao.RankDao;
import com.njupt.entity.Rank;
import com.njupt.service.RankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/09/16:46
 * @Description:
 */
@Service
public class RankServiceImpl implements RankService {

    @Resource
    RankDao rankDao;
    @Override
    public boolean insert(Rank rank) {

        return  rankDao.insert(rank)>0;
    }

    @Override
    public Integer selectSumScore(Integer songListId) {

        return rankDao.selectSumScore(songListId);
    }

    @Override
    public Integer selectSumPeople(Integer songListId) {

        return rankDao.selectSumPeople(songListId);
    }

    @Override
    public int avg(Integer songListId) {

        return rankDao.selectSumScore(songListId) /rankDao.selectSumPeople(songListId);
    }
}
