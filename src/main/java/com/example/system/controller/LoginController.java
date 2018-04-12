package com.example.system.controller;

import com.example.system.model.LoginMsg;
import com.example.system.service.LoginService;
import com.example.system.utils.DigestForString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录
 * 
 * @author sai.an
 */
@Controller
@RequestMapping(value = "/loginMsg")
public class LoginController {

	@Resource
	private LoginService loginService;

	@RequestMapping(value = "/index")
	public String login(Model model, HttpSession session, HttpServletRequest request) {
		session.setAttribute("loginNo", null);
		return "login";
	}

	public static void main(String[] args) {
		try {
			String password ="17671765029";
			password = DigestForString.message(StringUtils.defaultString(password, ""),DigestForString.ENCODING_BASE64);
			System.out.println(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 登录验证
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute LoginMsg loginMsg, HttpServletRequest request, HttpSession session,
						Model model) {
		if (loginMsg != null){
            try {
				String password = loginMsg.getPassword();
				password = DigestForString.message(StringUtils.defaultString(password, ""),DigestForString.ENCODING_BASE64);
				loginMsg.setPassword(password);
				//根据工号查询
				int result=loginService.getLoginNoByLogin(loginMsg);
				if(result<=0){
					model.addAttribute("reason", "用户名或密码错误!");
					return "login";
				}
				//设置session
				session.setAttribute("loginNo", loginMsg.getLoginNo());// 工号
				session.setMaxInactiveInterval(900);//session过期15分钟
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("reason", "登录异常! result:"+e.getMessage());
				return "login";
			}
			return "redirect:/loginMsg/main";
		}
		return "login";
	}
	
	@RequestMapping(value = "/main")
	public String login(HttpSession session, Model model) {
		/*String loginNo=session.getAttribute("loginNo").toString();
		model.addAttribute("loginNo",loginNo);*/
		return "home";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("loginNo");
		return "redirect:/loginMsg/index";
	}
}
