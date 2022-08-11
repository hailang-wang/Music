package com.njupt.controller;

import com.alibaba.fastjson.JSONObject;
import com.njupt.entity.Song;
import com.njupt.service.ListSongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/14:39
 * @Description:
 */
@RestController
public class ListSongController {

    @Resource
    private ListSongService listSongService;

    //展示当前分类中的所有歌曲
    @GetMapping("/list/query")
    public  Object queryByList(HttpServletRequest request){
        String id = request.getParameter("id");
        List<Song> songs = listSongService.showSongInTheList(Integer.valueOf(id));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",songs);
        return jsonObject;
    }

    //给歌单插入一首歌
    @PostMapping("/list/insert")
    public  Object insertByList(HttpServletRequest request){
        String listId = request.getParameter("listId");
        String songName = request.getParameter("songName");

        boolean b = listSongService.insertList(songName, Integer.valueOf(listId));
        JSONObject jsonObject = new JSONObject();
        if(b){
            jsonObject.put("result","插入成功");
            return jsonObject;
        }
        else {
            jsonObject.put("result","插入失败");
            return jsonObject;
        }
    }

    //删除当前表单的某一个歌曲,里面有当前歌单的id和歌曲的id,因此只要获取这两个参数，进行删除就可以

    @PostMapping("/list/delete")
    public  Object deleteByList(HttpServletRequest request){
        String listId = request.getParameter("listId");
        String songName = request.getParameter("songName");

        boolean b = listSongService.deleteList(songName, Integer.valueOf(listId));
        JSONObject jsonObject = new JSONObject();
        if(b){
            jsonObject.put("result","删除成功");
            return jsonObject;
        }
        else {
            jsonObject.put("result","删除失败");
            return jsonObject;
        }
    }
 }
