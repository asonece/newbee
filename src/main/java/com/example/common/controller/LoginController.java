package com.example.common.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ansai on 2018/4/11.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping("/")
    public String toIndex(HttpServletRequest request, Model model){
        return "redirect:/loginMsg/index";
    }

    @GetMapping("/loginMsg/index")
    public String index(HttpServletRequest request,Model model){
        request.setAttribute("key", "login hello world");
        return "/indexs";
    }
}
