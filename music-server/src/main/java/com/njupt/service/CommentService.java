package com.njupt.service;

import com.njupt.entity.Comment;

import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/09/19:17
 * @Description:
 */
public interface CommentService {
    //插入评论的对象
    boolean insert(Comment comment);
    //根据主键查询整个对象
    Comment queryByKey(Integer id);
    //查询所有的评论
    List<Comment> queryAllComment();
    //根据歌曲下的所有评论
    List<Comment> queryCommentOfSong(Integer SongId);
    //根据歌单查询评论
    List<Comment> queryByListId(Integer ListId);
    //根据主键删除对象
    boolean deleteCommentByKey(Integer id);
}
