package com.njupt.service.impl;

import com.njupt.dao.CommentDao;
import com.njupt.entity.Comment;
import com.njupt.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/09/19:18
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Override
    public boolean insert(Comment comment) {
        int insert = commentDao.insert(comment);
        return insert>0;
    }

    @Override
    public Comment queryByKey(Integer id) {
        return commentDao.queryByKey(id);
    }

    @Override
    public List<Comment> queryAllComment() {
        return commentDao.queryAllComment();
    }

    @Override
    public List<Comment> queryCommentOfSong(Integer songId) {
        return commentDao.queryCommentOfSong(songId);
    }

    @Override
    public List<Comment> queryByListId(Integer listId) {
        return commentDao.queryByListId(listId);
    }

    @Override
    public boolean deleteCommentByKey(Integer id) {
        return commentDao.deleteCommentByKey(id)>0;
    }
}
