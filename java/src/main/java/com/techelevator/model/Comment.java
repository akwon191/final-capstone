package com.techelevator.model;
import java.sql.Timestamp;

public class Comment {

    private int comment_id;
    private int post_id;
    private int user_id;
    private Timestamp date_time;
    private String comment_text;

    public Comment(int comment_id, int post_id, int user_id, Timestamp date_time, String comment_text) {
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.user_id = user_id;
        this.date_time = date_time;
        this.comment_text = comment_text;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }
}