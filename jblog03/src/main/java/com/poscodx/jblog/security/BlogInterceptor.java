package com.poscodx.jblog.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.CategoryService;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;

public class BlogInterceptor implements HandlerInterceptor {
	@Autowired
	private BlogService blogService;

	@Autowired
	private CategoryService categoryService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(true);
		BlogVo blogVo = (BlogVo) session.getAttribute("blogVo");
		String authUserId = (String) session.getAttribute("authUserId");

		if (blogVo == null) {
			blogVo = blogService.findById(authUserId);
			session.setAttribute("blogVo", blogVo);
		}

		List<CategoryVo> categoryList = categoryService.findByBlogId(authUserId);

		session.setAttribute("categoryList", categoryList);

		return true;
	}

}
