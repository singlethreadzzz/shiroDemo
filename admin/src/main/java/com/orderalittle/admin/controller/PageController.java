package com.orderalittle.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.orderalittle.admin.domain.ManagerInfo;
import com.orderalittle.admin.pojo.LoginInfo;

@Controller
public class PageController {
	
	@GetMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		LoginInfo LoginInfo = new LoginInfo();
		mv.addObject(LoginInfo);
		return mv;
	}
	
//	@GetMapping("/index")
//	public ModelAndView indexPage() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("index");
//		mv.addObject("index", "你好");
//		return mv;
//	}
	
	@GetMapping("/error")
	public ModelAndView errorPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		return mv;
	}
	
	@GetMapping("/managerInfo")
	public ModelAndView managerInfoPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("managerInfo");
		ManagerInfo managerInfo = new ManagerInfo();
		mv.addObject(managerInfo);
		return mv;
	}

}
