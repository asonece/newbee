package com.example.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Ansai on 2018/4/11.
 */
@Controller
public class CommonController {

    @RequestMapping(value = "/")
    public String index(Model model, HttpSession session, HttpServletRequest request) {
        return "redirect:/loginMsg/index";
    }
}
