package com.njupt.controller;

import com.alibaba.fastjson.JSONObject;
import com.njupt.entity.Singer;
import com.njupt.service.SingerService;
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
 * @Date:2021/12/05/21:26
 * @Description:
 */
@RestController
public class SingerController {
    @Resource
    private SingerService singerService;

    @GetMapping("/singer/id")
    public Object query(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        Singer singer = singerService.queryById(Integer.valueOf(id));
        jsonObject.put("singer",singer);

        return jsonObject;
    }

    @GetMapping("/singer/all")
    public Object queryAll(){
        JSONObject jsonObject = new JSONObject();

        List<Singer> singers = singerService.queryAll();
        jsonObject.put("singers",singers);
        return jsonObject;
    }

    @GetMapping("/singer/delete")
    public Object delete(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        boolean b = singerService.deleteById(Integer.valueOf(id));
        if(b){
            jsonObject.put("code",1);
            jsonObject.put("state","删除成功");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("state","删除失败");
            return jsonObject;
        }
    }

    @PostMapping("/singer/update")
    public Object update(HttpServletRequest request){

        String id = request.getParameter("id");
        String path = request.getParameter("path");
        JSONObject jsonObject = new JSONObject();
        Singer singer = new Singer();
        singer.setId(Integer.valueOf(id));
        singer.setPic(path);
        boolean b = singerService.update(singer);
        if(b){
            jsonObject.put("code",1);
            jsonObject.put("state","修改成功");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("state","修改失败");
            return jsonObject;
        }
    }



    //希望修改歌手的头像
    @PostMapping("/singer/updateSingerPic")
    public Object updateSingerPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id") int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put("code",0);
            jsonObject.put("state","上传文件失败");
            return jsonObject;
        }
        String filename=System.currentTimeMillis()+avatorFile.getOriginalFilename();
        String filePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"img"+System.getProperty("file.separator")+"singerPic";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdir();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + filename);
        String storePath="/img/singerPic"+filename;
        ///img/singerPic1638765336213张老师签命.jpgllll

        try {
            //Transfer the received file to the given destination file.
            avatorFile.transferTo(dest);
            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(storePath);
            //更新的方法
            boolean b = singerService.update(singer);
            if(b){
                jsonObject.put("code",1);
                jsonObject.put("state","图片上传成功");
                return jsonObject;
            }else {
                jsonObject.put("code",0);
                jsonObject.put("state","图片上传失败");
                return jsonObject;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return jsonObject;
        }
    }

    ///歌手的分页
    @GetMapping("/singer/page")
    public Object page(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String pageNumber = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");

        List<Singer> page = singerService.page(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
        jsonObject.put("code", 1);
        jsonObject.put("state", "查询成功");
        jsonObject.put("page", page);
        return jsonObject;
    }

}
