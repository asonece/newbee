package com.example.newbee.service;

import com.example.newbee.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by Ansai on 2018/4/10.
 */
public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);
}
