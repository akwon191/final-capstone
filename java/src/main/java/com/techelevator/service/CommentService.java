package com.techelevator.service;


import com.techelevator.dao.CommentDao;
import com.techelevator.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentDao commentDao;

    @Autowired
    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> getCommentsByPostId(int postId) {

        return commentDao.getCommentsByPostId(postId);
    }
    public Comment createComment(Comment comment) {

        return commentDao.createComment(comment);
        
    }
}
