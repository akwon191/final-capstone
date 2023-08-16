package com.techelevator.dao;


import com.techelevator.model.Comment;
import com.techelevator.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcPostDao implements PostDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcPostDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM posts";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        List<Post> posts = new ArrayList<>();
        while (rowSet.next()) {
            Post post = mapPost(rowSet);
            posts.add(post);
        }
        return posts;
    }

    public int addPost(Post post) {
        String sql = "INSERT INTO posts (user_id, date_time, caption, image_data_id) VALUES (?, ?, ?, ?) RETURNING post_id";

        Timestamp currentTimestamp = Timestamp.valueOf(LocalDateTime.now()); // Create Timestamp from current date and time

        return jdbcTemplate.queryForObject(sql, Integer.class, post.getUserId(), currentTimestamp, post.getCaption(), post.getImgId());
    }

    private Post mapPost(SqlRowSet rowSet) {
        int postId = rowSet.getInt("post_id");
        int userId = rowSet.getInt("user_id");
        String username = getUsername(userId);
        int imgId = rowSet.getInt("image_data_id");
        Timestamp dateTime = rowSet.getTimestamp("date_time");
        String caption = rowSet.getString("caption");

        int likeCount = getReactionCount("thanks", postId);
        int dislikeCount = getReactionCount("no_thanks", postId);
        int vibeCount = getReactionCount("vibes", postId);

        Post post = new Post(postId, userId, username, imgId, dateTime, caption, likeCount, dislikeCount, vibeCount);
        loadComments(post);
        return post;
    }

    private String getUsername(int userId) {
        String sql = "SELECT username FROM users WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, userId);
    }

    private int getReactionCount(String reactionType, int postId) {
        String sql = "SELECT COUNT(*) AS count FROM " + reactionType + " WHERE post_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, postId);
    }

    private void loadComments(Post post) {
        String sql = "SELECT * FROM post_comments WHERE post_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, post.getPostId());
        while (rowSet.next()) {
            Comment comment = mapComment(rowSet);
            post.addComment(comment);
        }
    }

    private Comment mapComment(SqlRowSet rowSet) {
        int commentId = rowSet.getInt("comment_id");
        int postId = rowSet.getInt("post_id");
        int userId = rowSet.getInt("user_id");
        String username = rowSet.getString("username");
        Timestamp dateTime = rowSet.getTimestamp("date_time");
        String commentText = rowSet.getString("comment_text");
        return new Comment(commentId, postId, userId, username, dateTime, commentText);
    }

}
