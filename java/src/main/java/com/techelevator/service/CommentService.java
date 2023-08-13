package com.techelevator.service;

import com.techelevator.dao.JdbcCommentDao;
import com.techelevator.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CommentService {

    private final JdbcCommentDao commentDao;

    @Autowired
    public CommentService(JdbcCommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> getCommentsByPostId(int postId) throws SQLException {
        return commentDao.getCommentsByPostId(postId);
    }
    public Comment createComment(Comment comment) {

        return commentDao.createComment(comment);

    }
}
