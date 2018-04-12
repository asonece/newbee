package com.example.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Ansai on 2018/4/12.
 */
public class PassportInterceptor implements HandlerInterceptor {

    /**
     * controller 执行之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        System.out.println("------preHandle-----");
        String url = request.getRequestURL().toString();
        HttpSession session = request.getSession();
        String loginNo = (String) session.getAttribute("loginNo");
        if (url.contains("static/css")||url.contains("static/jquery")||url.contains("static/images")) {
            return true;
        }
        if (!url.matches("[\\w/:\\.]*loginMsg/(index|login)")) {
            if (loginNo == null || "".equals(loginNo)) {
                response.sendRedirect("/loginMsg/index");
                return false;
            }
        }
        if (loginNo != null && !"".equals(loginNo)) {
            if (url.matches("[\\w/:\\.]*loginMsg/(index|login)")) {
                response.sendRedirect("/loginMsg/main");
                return false;
            }
        }
        return true;
    }

    /**
     * controller 执行之后，且页面渲染之前调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("------postHandle-----");
    }

    /**
     * 页面渲染之后调用，一般用于资源清理操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("------afterCompletion-----");

    }

    public static void main(String[] args) {
        String url="http://192.168.23.81/static/css/style.css";
        if (url.contains("static/css")||url.contains("static/jquery")||url.contains("static/images")) {
            System.out.println(1);
        }
    }
}
