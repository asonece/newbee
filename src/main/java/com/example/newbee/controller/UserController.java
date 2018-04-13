package com.example.newbee.controller;

import com.example.common.redis.RedisUtils;
import com.example.newbee.entity.User;
import com.example.newbee.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ansai on 2018/4/10.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        redisUtils.set("123", "hello world");
        System.out.println("进入了方法");
        String string= redisUtils.get("123").toString();
        return string;
    }

}

