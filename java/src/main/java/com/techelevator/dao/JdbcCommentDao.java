package com.techelevator.dao;
import com.techelevator.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCommentDao implements CommentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Comment> getCommentsByPostId(int postId) throws SQLException {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM post_comments WHERE post_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, postId);
        while (results.next()) {
            Comment com = mapRowToComment(results);
            comments.add(com);
        }
        return comments;
    }


    @Override
    public Comment createComment(Comment comment) {
        String sql = "INSERT INTO post_comments ( user_id, post_id, username, date_time, comment_text) VALUES (?, ?, ?, ?, ?) RETURNING comment_id";
        Timestamp currentTimestamp = Timestamp.valueOf(LocalDateTime.now());
        int commentId = jdbcTemplate.queryForObject(sql, Integer.class, comment.getUserId(), comment.getPostId(), currentTimestamp, comment.getCommentText());
        comment.setCommentId(commentId);
        return comment;
    }
    private Comment mapRowToComment(SqlRowSet resultSet) throws SQLException {
        int commentId = resultSet.getInt("comment_id");
        int postId = resultSet.getInt("post_id");
        int userId = resultSet.getInt("user_id");
        String username = resultSet.getString("username");
        Timestamp dateTime = resultSet.getTimestamp("date_time");
        String commentText = resultSet.getString("comment_text");
        return new Comment(commentId, postId, userId, username, dateTime, commentText);
    }
}



