package com.cognizant;

public class UserManager2 {

    private UserDao dao;

    public UserManager2(UserDao dao) {
        this.dao = dao;
    }

    public void register(String username) {
        dao.save(username);
    }
}