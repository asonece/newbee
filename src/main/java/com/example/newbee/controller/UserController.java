package com.example.newbee.controller;

import com.example.newbee.entity.User;
import com.example.newbee.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by Ansai on 2018/4/10.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private final Logger logger= LoggerFactory.getLogger(UserController.class);
    @GetMapping("/templates")
    public String toIndex(HttpServletRequest request,Model model){
        User user=userService.getUserById(1);
        request.setAttribute("key", "user hello world");
        model.addAttribute("user",user);
        return "index";
    }

}

