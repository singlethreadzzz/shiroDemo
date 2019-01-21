package com.orderalittle.admin.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.orderalittle.admin.domain.ManagerInfo;
import com.orderalittle.admin.servicesImpl.ManagerInfoServiceImpl;
import com.orderalittle.admin.utils.EncryptUtils;

@Controller
public class ManagerInfoController {
	
	@Autowired
	private ManagerInfoServiceImpl managerInfoService;
	
	@RequiresRoles("admin")
	@PostMapping("/addUser")
	public ModelAndView addUser(ManagerInfo managerInfo) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("managerInfo");
		
		if(this.managerInfoService.selectManagerInfoByName(managerInfo.getName()) != null) {
			mv.addObject("massage", "用户已存在");
			return mv;
		}
		
		managerInfo.setPassword(EncryptUtils.shiroSHA256(managerInfo.getName(), managerInfo.getPassword()));
		mv.addObject("massage", this.managerInfoService.addUser(managerInfo));
		mv.addObject(new ManagerInfo());
		return mv;
	}

}
