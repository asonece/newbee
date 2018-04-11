package com.example.newbee.service.impl;

import com.example.newbee.dao.UserDao;
import com.example.newbee.entity.User;
import com.example.newbee.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Ansai on 2018/4/10.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
