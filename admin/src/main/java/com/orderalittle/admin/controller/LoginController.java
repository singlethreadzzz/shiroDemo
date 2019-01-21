package com.orderalittle.admin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.orderalittle.admin.pojo.LoginInfo;

@Controller
public class LoginController {
	
	@PostMapping("/login")
	public ModelAndView login(LoginInfo loginInfo) {
		
		ModelAndView mv = new ModelAndView();
		
		if(loginInfo.getName() == null || loginInfo.getPassword() == null){
			mv.setViewName("error");
			return mv;
		}
		
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(loginInfo.getName(),loginInfo.getPassword());
			if(true == loginInfo.getIsRememberMe()) {
				token.setRememberMe(true);
			}
			
			try {
				currentUser.login(token);
			}catch (Exception e) {
				System.out.println("登录失败：" + e);
				mv.setViewName("error");
				return mv;
			}
		}
		
		mv.setViewName("index");
		mv.addObject("index", "hello");
		return mv;	
	}

}
