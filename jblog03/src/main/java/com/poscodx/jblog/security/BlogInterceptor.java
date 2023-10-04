package com.poscodx.jblog.security;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.UserService;
import com.poscodx.jblog.vo.BlogVo;

public class BlogInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		BlogVo blogVo = (BlogVo) request.getServletContext().getAttribute("blogVo");
		String authUserId = request.getParameter("authUserId");
		
		if(blogVo == null) {
			blogVo = blogService.findById(authUserId);
		}
		
		if(blogVo == null) {
			blogService.insert(authUserId);
			blogVo = blogService.findById(authUserId);
		}
		
		// category

		HttpSession session = request.getSession(true);
		request.getServletContext().setAttribute("blogVo", blogVo);

		return true;
	}

}
