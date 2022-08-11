package com.njupt.controller;

import com.alibaba.fastjson.JSONObject;
import com.njupt.entity.Song;
import com.njupt.service.SongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/06/16:21
 * @Description:
 */
@RestController
public class SongController {
    @Resource
    private SongService songService;

    @GetMapping("/song/id")
    public Object query(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        Song song = songService.queryById(Integer.valueOf(id));
        jsonObject.put("song",song);
        return jsonObject;
    }

    @GetMapping("/song/like")
    public Object queryLike(HttpServletRequest request){
        String songName = request.getParameter("songName");
        List<Song> songs1 = songService.queryLike(songName);
        JSONObject jsonObject = new JSONObject();


        jsonObject.put("songs",songs1);
        return jsonObject;
    }

    @GetMapping("/song/all")
    public Object queryAll(){
        JSONObject jsonObject = new JSONObject();

        List<Song> songs = songService.queryAll();
        jsonObject.put("songs",songs);
        return jsonObject;
    }

    @GetMapping("/song/delete")
    public Object delete(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        boolean b = songService.deleteById(Integer.valueOf(id));
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


    //更新之后，修改数据库中的路径信息
    @PostMapping("/song/update")
    public Object update(HttpServletRequest request){

        String id = request.getParameter("id");
        String path = request.getParameter("path");
        JSONObject jsonObject = new JSONObject();
        Song song = new Song();
        song.setId(Integer.valueOf(id));
        song.setPic(path);
        boolean b = songService.update(song);
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



    //希望修改歌曲的头像
    @PostMapping("/song/updateSongPic")
    public Object updateSongPic(@RequestParam("file") MultipartFile mpFile, @RequestParam("id") int id){
        JSONObject jsonObject = new JSONObject();
        if(mpFile.isEmpty()){
            jsonObject.put("code",0);
            jsonObject.put("state","上传文件失败");
            return jsonObject;
        }
        String filename=System.currentTimeMillis()+mpFile.getOriginalFilename();
        String filePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"img"+System.getProperty("file.separator")+"songPic";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdir();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + filename);
        String storePath="/img/songPic"+filename;
        ///img/songPic1638765336213张老师签命.jpgllll

        try {
            //Transfer the received file to the given destination file.
            mpFile.transferTo(dest);
            Song song = new Song();
            song.setId(id);
            song.setPic(storePath);
            //更新的方法
            boolean b = songService.update(song);
            if(b){
                jsonObject.put("code",1);
                jsonObject.put("state","歌曲上传成功");
                return jsonObject;
            }else {
                jsonObject.put("code",0);
                jsonObject.put("state","歌曲上传失败");
                return jsonObject;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return jsonObject;
        }
    }

    //新插入歌曲信息
    @PostMapping("/song/insert")
    public Object insert(HttpServletRequest request,@RequestParam("pic") MultipartFile pic,@RequestParam("mp") MultipartFile mp){
        String singer = request.getParameter("singer");
        String name = request.getParameter("name");
        String introduction = request.getParameter("introduction");
        String createTime = request.getParameter("createTime");
        String updateTime = request.getParameter("updateTime");
        //上传图片地址肯定是包含在上传的图片信息里
        //String pic = request.getParameter("pic");
        String lyric = request.getParameter("lyric");
        //上传音乐的肯定是包含在上传的音乐信息里
        //String url = request.getParameter("url");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date createDate = new Date();

        Date updateDate=new Date();
        try {
            createDate=dateFormat.parse(createTime);
            updateDate= dateFormat.parse(updateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        //现在要来处理接收的图片和歌曲信息，并把图片和歌曲存盘之后在进行信息提取和赋值
        //处理图片
        String picName=pic.getOriginalFilename();
        //准备指定当前上传的文件存在本地的位置
        String picPath=System.getProperty("user.dir")+System.getProperty("file.separator")+"img"+System.getProperty("file.separator")+"songPic";
        //只需要将文件的位置进行记录赋值即可，后面查找时可以根据字符串的拼接操作，直接到存储的位置找
        String picc="/img/songPic/"+picName;
        File picDest = new File(picPath + System.getProperty("file.separator") + picName);

        //处理音乐
        String mpName = mp.getOriginalFilename();
        String mpPath=System.getProperty("user.dir")+System.getProperty("file.separator")+"song";
        String url="/song/"+mpName;
        File mpfile = new File(mpPath + System.getProperty("file.separator") + mpName);

        try {
            pic.transferTo(picDest);
            mp.transferTo(mpfile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        JSONObject jsonObject = new JSONObject();
        Song song = new Song();
        song.setSinger(Integer.valueOf(singer));
        song.setName(name);
        song.setIntroduction(introduction);
        song.setCreate(createDate);
        song.setUpdate(updateDate);
        song.setPic(picc);
        song.setLyric(lyric);
        song.setUrl(url);
        Boolean insert = songService.insert(song);

        if(insert){
            jsonObject.put("code",1);
            jsonObject.put("state","图片和歌曲上传成功");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("state","图片和歌曲上传失败");
            return jsonObject;
        }
    }


    ///歌曲的分页
    @GetMapping("/song/page")
    public Object page(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String pageNumber = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");

        List<Song> page = songService.page(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
        jsonObject.put("code", 1);
        jsonObject.put("state", "查询成功");
        jsonObject.put("page", page);
        return jsonObject;
    }

}
