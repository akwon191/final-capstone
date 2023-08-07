package com.techelevator.dao;

import com.techelevator.model.Post;
import com.techelevator.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPostDao implements PostDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPostDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM post";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        List<Post> posts = new ArrayList<>();
        while (rowSet.next()) {
            Post post = mapPost(rowSet);
            posts.add(post);
        }
        return posts;
    }

    private Post mapPost(SqlRowSet rowSet) {
        int postId = rowSet.getInt("post_id");
        int userId = rowSet.getInt("user_id");
        Timestamp dateTime = rowSet.getTimestamp("date_time");
        String caption = rowSet.getString("caption");

        int likeCount = getReactionCount("like", postId);
        int dislikeCount = getReactionCount("dislike", postId);
        int vibeCount = getReactionCount("vibe", postId);

        Post post = new Post(postId, userId, dateTime, caption,
                likeCount, dislikeCount, vibeCount);
        loadComments(post);
        return post;
    }

    //Call DB with relevant attribute for counts
    private int getReactionCount(String reactionType, int postId) {
        String sql = "SELECT COUNT(*) AS count FROM " + reactionType + " WHERE post_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, postId);
    }

    private void loadComments(Post post) {
        String sql = "SELECT user_id, comment_text, date_time FROM comment WHERE post_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, post.getPostId());
        while (rowSet.next()) {
            Comment comment = mapComment(rowSet);
            post.addComment(comment);
        }
    }

    private Comment mapComment(SqlRowSet rowSet) {
        int userId = rowSet.getInt("user_id");
        String commentText = rowSet.getString("comment_text");
        Timestamp dateTime = rowSet.getTimestamp("date_time");
        return new Comment(userId, commentText, dateTime);
    }
}
