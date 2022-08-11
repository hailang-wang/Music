package com.njupt.controller;

import com.alibaba.fastjson.JSONObject;
import com.njupt.entity.SongList;
import com.njupt.service.SongListService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/12:26
 * @Description:
 */
@RestController
public class SongListController {

    @Resource
    private SongListService songListService;

    @GetMapping("/songList/all")
    public Object queryAll(){

        JSONObject jsonObject = new JSONObject();
        List<SongList> songLists = songListService.queryAll();

        if(songLists!=null){
            jsonObject.put("code",1);
            jsonObject.put("mess","查询成功");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("mess","查询失败");
            return jsonObject;
        }
    }
    //按照歌单的风格查询
    @GetMapping("/songList/likeStyle")
    public Object queryLikeStyle(HttpServletRequest request){
        String style = request.getParameter("style");

        JSONObject jsonObject = new JSONObject();
        List<SongList> songLists = songListService.queryByName(style);
        if(songLists!=null){
            jsonObject.put("code",1);
            jsonObject.put("mess","查询成功");
            jsonObject.put("result",songLists);
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("mess","查询失败");
            return jsonObject;
        }
    }

    //歌单的插入操作
    @PostMapping("/songList/insert")
    public Object insert(HttpServletRequest request, @RequestParam("file") MultipartFile pic){
        String title=request.getParameter("title");
        String style = request.getParameter("style");
        String introduction = request.getParameter("introduction");

        //处理上传的图片信息
        String filename = pic.getOriginalFilename();
        String storePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"img"+System.getProperty("file.separator")+"songListPic";

        String dest=storePath + System.getProperty("file.separator") + filename;
        File file = new File(dest);

        try {
            pic.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String picPath="/img/songListPic/"+filename;
        SongList songList = new SongList();
        songList.setTitle(title);
        songList.setPic(picPath);
        songList.setIntroduction(introduction);
        songList.setStyle(style);

        boolean insert = songListService.insert(songList);
        JSONObject jsonObject = new JSONObject();
        if(insert){
            jsonObject.put("code",1);
            jsonObject.put("mess","插入成功");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("mess","插入失败");
            return jsonObject;
        }
    }

    //歌单的修改，要传入修改的id值.从而修改所有的信息
    @PostMapping("/songList/update")
    public Object update(HttpServletRequest request, @RequestParam("file") MultipartFile pic) {

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String style = request.getParameter("style");
        String introduction = request.getParameter("introduction");
        //这里最好做一个判断，因为不知道修改什么，可以加入
        SongList songList = new SongList();
        songList.setTitle(title);
        songList.setIntroduction(introduction);
        songList.setStyle(style);
        songList.setId(Integer.valueOf(id));
        //处理上传的图片信息
        if (!pic.isEmpty()) {
            String filename = pic.getOriginalFilename();
            String storePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "songListPic";
            String picPath = "/img/songListPic/" + filename;
            String dest = storePath + System.getProperty("file.separator") + filename;
            File file = new File(dest);
            songList.setPic(picPath);
            try {
                pic.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        boolean insert = songListService.update(songList);
        JSONObject jsonObject = new JSONObject();
        if (insert) {
            jsonObject.put("code", 1);
            jsonObject.put("mess", "修改成功");
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("mess", "修改失败");
            return jsonObject;
        }
    }

    //按照id删除歌单
    @GetMapping("/songList/delete")
    public Object delete(HttpServletRequest request){
        String id = request.getParameter("id");
        JSONObject jsonObject = new JSONObject();
        boolean delete = songListService.delete(Integer.valueOf(id));
        if(delete){
            jsonObject.put("code",1);
            jsonObject.put("mess","删除成功");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("mess","删除失败");
            return jsonObject;
        }
    }

}
