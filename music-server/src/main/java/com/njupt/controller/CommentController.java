package com.njupt.controller;

import com.alibaba.fastjson.JSONObject;
import com.njupt.entity.Comment;
import com.njupt.entity.Song;
import com.njupt.service.CommentService;
import com.njupt.service.SongListService;
import com.njupt.service.SongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/09/20:03
 * @Description:
 */
@RestController
public class CommentController {
    @Resource
    private CommentService service;
    @Resource
    private SongService songService;

    @Resource
    private SongListService songListService;

    /*
    * private Integer id;
    private Integer userId;
    private Integer songId;
    private Integer songListId;
    private String content;
    private Date createTime;
    private Byte type;
    private Integer up;*/
    //插入
    @PostMapping("/comment/insert")
    public Object insert(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String songId = request.getParameter("songId");
        String songListId = request.getParameter("songListId");
        String content = request.getParameter("content");
        String type = request.getParameter("type");
        String up = request.getParameter("up");

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd mm:SS sss");
        String format = dateFormat.format(date);

        Comment comment = new Comment();
        comment.setUserId(Integer.valueOf(userId));
        comment.setSongId(Integer.valueOf(songId));
        comment.setSongListId(Integer.valueOf(songListId));
        comment.setContent(content);
        comment.setType(new Byte(type));
        comment.setUp(Integer.valueOf(up));
        comment.setCreateTime(date);

        JSONObject jsonObject = new JSONObject();
        if(service.insert(comment)){
            jsonObject.put("code",1);
            jsonObject.put("msg","插入成功");
            return jsonObject;
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","插入失败");
            return jsonObject;
        }
    }

    @GetMapping("/comment/getById")
    public Object queryByKey(HttpServletRequest request){
        String id = request.getParameter("id");

        Comment comment = service.queryByKey(Integer.valueOf(id));
        JSONObject jsonObject = new JSONObject();
        if(comment!=null){
            jsonObject.put("code","查询的结果成功");
            jsonObject.put("结果",comment.getContent());
            return jsonObject;
        }
        return jsonObject;
    }

    //根据歌曲的id查询哥的评论
    @GetMapping("/comment/getBySongId")
    public Object getBySongId(HttpServletRequest request){
        String id = request.getParameter("songId");

        Song song=songService.queryById(Integer.valueOf(id));
        String songName=song.getName();
        List<Comment> comments = service.queryCommentOfSong(Integer.valueOf(id));
        JSONObject jsonObject = new JSONObject();
        if (comments != null) {
            int i=0;
            for (Comment comment : comments) {
                    jsonObject.put("歌曲["+songName+"]评论"+(i++) , comment.getContent());
            }
            return jsonObject;
        }
        return jsonObject;
    }
    //根据歌单的id查询歌的评论
    @GetMapping("/comment/getByListId")
    public Object getByListId(HttpServletRequest request){
        String id = request.getParameter("songListId");
        List<Comment> comments = service.queryByListId(Integer.valueOf(id));
        JSONObject jsonObject = new JSONObject();

        if (comments != null) {
            int i=0;

            for (Comment comment : comments) {
                jsonObject.put("歌单评论"+(i++) , comment.getContent());
            }
            return jsonObject;
        }
        return jsonObject;
    }

    @GetMapping("/comment/deleteCommentByKey")
    public Object deleteCommentByKey(HttpServletRequest request){
        String id = request.getParameter("Id");
        boolean b = service.deleteCommentByKey(Integer.valueOf(id));
        JSONObject jsonObject = new JSONObject();
        if (b) {
            jsonObject.put("结果","删除成功");
            return jsonObject;
        }
        return jsonObject;
    }
}
