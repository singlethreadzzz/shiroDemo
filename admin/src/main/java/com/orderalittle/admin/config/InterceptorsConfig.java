package com.orderalittle.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.orderalittle.admin.interceptors.LoginInterceptor;

//@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {
	
	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
//		List<String> excludePathPatternsList = new ArrayList<String>();
//		excludePathPatternsList.add("/js/**");
//		excludePathPatternsList.add("/css/**");
//		excludePathPatternsList.add("/icon/**");
//		excludePathPatternsList.add("/image/**");
//		excludePathPatternsList.add("/error/**");
		
		registry.addInterceptor(loginInterceptor)
//		        .excludePathPatterns(excludePathPatternsList)
				.addPathPatterns("/**");
	}

}
