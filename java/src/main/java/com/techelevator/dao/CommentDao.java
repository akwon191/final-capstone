package com.techelevator.dao;

import com.techelevator.model.Comment;

import java.sql.SQLException;
import java.util.List;

public interface CommentDao {

    List<Comment> getCommentsByPostId(int postId) throws SQLException;

    Comment createComment(Comment comment);
}