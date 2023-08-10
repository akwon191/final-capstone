package com.techelevator.dao;
import com.techelevator.model.Comment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Component
public class JdbcCommentDao implements CommentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Comment> getCommentsByPostId(int postId) {
        return null;
    }

    @Override
    public Comment createComment(Comment comment) {
        String sql = "INSERT INTO comments (post_id, user_id, date_time, comment_text) VALUES (?, ?, ?, ?) RETURNING comment_id";


        int commentId = jdbcTemplate.queryForObject(sql, Integer.class, comment.getPostId(), comment.getUserId(), comment.getDateTime(), comment.getCommentText());
        comment.setCommentId(commentId);
        return comment;
    }
    private Comment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int commentId = resultSet.getInt("comment_id");
        int postId = resultSet.getInt("post_id");
        int userId = resultSet.getInt("user_id");
        Timestamp dateTime = resultSet.getTimestamp("date_time");
        String commentText = resultSet.getString("comment_text");
        return new Comment(commentId, postId, userId, dateTime, commentText);
    }
}



