package com.techelevator.service;

import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final JdbcUserDao userDao;

    public UserService(JdbcUserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public int findIdByUsername(String username) {
        return userDao.findIdByUsername(username);
    }

    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public boolean createUser(String username, String password, String role) {
        return userDao.create(username, password, role);
    }
}