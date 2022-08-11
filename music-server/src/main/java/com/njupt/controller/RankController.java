package com.njupt.controller;

import com.alibaba.fastjson.JSONObject;
import com.njupt.entity.Rank;
import com.njupt.service.RankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/09/16:57
 * @Description:歌单的打分模块
 */
@RestController
public class RankController {
    @Resource
    private RankService rankService;
    @PostMapping("/rank/add")
    public Object add(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String songListId = request.getParameter("songListId");
        String consumerId = request.getParameter("consumerId");
        String score = request.getParameter("score");
        Rank rank = new Rank();
        rank.setConsumerId(Integer.valueOf(consumerId));
        rank.setScore(Integer.valueOf(score));
        rank.setSongListId(Integer.valueOf(songListId));

        if(rankService.insert(rank)){
            jsonObject.put("code",1);
            jsonObject.put("mess","加入成功");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("mess","加入失败");
            return jsonObject;
        }
    }

    //返回歌单的总分
    @GetMapping("/rank/sumScore")
    public Object sumScore(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String songListId = request.getParameter("songListId");
        Integer score = rankService.selectSumScore(Integer.valueOf(songListId));

        jsonObject.put("code", 1);
        jsonObject.put("mess", "查找成功");
        jsonObject.put("score", score);
        return jsonObject;
    }
    //返回歌单的总人数

    @GetMapping("/rank/sumPeople")
    public Object sumPeople(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String songListId = request.getParameter("songListId");
        Integer sumPeople = rankService.selectSumPeople(Integer.valueOf(songListId));

        jsonObject.put("code", 1);
        jsonObject.put("mess", "查找成功");
        jsonObject.put("peopleNum", sumPeople);
        return jsonObject;
    }
    //返回平均分
    @GetMapping("/rank/avg")
    public Object avg(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String songListId = request.getParameter("songListId");
        Integer avg = rankService.avg(Integer.valueOf(songListId));

        jsonObject.put("code", 1);
        jsonObject.put("mess", "查找成功");
        jsonObject.put("score", avg);
        return jsonObject;
    }
}
