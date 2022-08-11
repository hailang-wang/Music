package com.njupt.dao;

import com.njupt.entity.Comment;

import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/09/18:36
 * @Description:评论功能
 */
public interface CommentDao {

    //新建评论
    int insert(Comment comment);

    //根据主键查询整个对象
    Comment queryByKey(Integer id);
    //查询所有的评论
    List<Comment> queryAllComment();
    //根据歌曲下的所有评论
    List<Comment> queryCommentOfSong(Integer SongId);
    //根据歌单查询评论
    List<Comment> queryByListId(Integer ListId);
    //根据主键删除对象
    int deleteCommentByKey(Integer id);

}
