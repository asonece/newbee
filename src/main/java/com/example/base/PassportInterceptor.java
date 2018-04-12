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
@Component
public class PassportInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(PassportInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.print("------------------------------in--------------------------------");
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        String url = request.getRequestURL().toString();
        HttpSession session = request.getSession();
        String loginNo = (String) session.getAttribute("loginNo");
		/*if (!url.matches("[\\w/:\\.]*loginMsg/(index|login)") &&
			!url.matches("[\\w/:\\.]*task/(delTask|publishTask|getTaskList|getTaskDetail|getAllRegion|getAllSchool)")&&
			!url.matches("[\\w/:\\.]*communitytob/(submitPost|uploadPicture|deletePost|operatePostReply|copyPost)")) {
			if (loginNo == null || "".equals(loginNo)) {
				response.sendRedirect("/loginMsg/index");
				return false;
			}
		}*/
        if (!url.matches("[\\w/:\\.]*loginMsg/(index|login)")) {
            if (loginNo == null || "".equals(loginNo)) {
                response.sendRedirect("/loginMsg/index");
                return false;
            }
        }
        if (loginNo != null && !"".equals(loginNo)) {
            if (url.matches("[\\w/:\\.]*loginMsg/index")) {
                response.sendRedirect("/loginMsg/main");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }
}
