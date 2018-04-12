package com.example.newbee.service;


import com.example.newbee.entity.User;

/**
 * Created by Ansai on 2018/4/10.
 */
public interface UserService {
    public User getUserById(int userId);

    public User findByName(String name);

    boolean addUser(User record);
}
