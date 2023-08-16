package com.techelevator.model;

import java.util.Objects;

public class Profile {

    private int userId;
    private String description;
    private String username;

    public Profile() {

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Profile(int userId, String description, String username) {
        this.userId = userId;
        this.description = description;
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return userId == profile.userId && Objects.equals(description, profile.description) && Objects.equals(username, profile.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, description, username);
    }
}
