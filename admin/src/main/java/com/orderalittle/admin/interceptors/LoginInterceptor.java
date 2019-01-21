package com.orderalittle.admin.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	/*/
	 * 方法之前
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("登录拦截器拦截成功");
//		String jsessionid = request.getSession().getAttribute("JSESSIONID").toString();
//		logger.info(jsessionid);
//		String loginPath = "/login";
//		if(loginPath.equals(request.getRequestURI())) {
			return true;
//		};
		
//		response.sendRedirect("/login");
//		logger.info("用户未登录，跳转到登录界面");
//        return false;
    }

	/*/
	 * 方法之后，渲染视图之前
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	logger.info("方法之后，渲染视图之前");
    }

	/*/
	 * 渲染视图之后
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    	logger.info("渲染视图之后");
    }

}
