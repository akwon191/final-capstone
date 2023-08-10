package com.techelevator.dao;

import com.techelevator.model.Comment;

import java.util.List;

public interface CommentDao {

    List<Comment> getCommentsByPostId(int postId);

    Comment createComment(Comment comment);
}