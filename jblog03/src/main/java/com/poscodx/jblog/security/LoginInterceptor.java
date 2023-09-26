package com.poscodx.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poscodx.jblog.service.UserService;
import com.poscodx.jblog.vo.UserVo;

public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		UserVo userVo = new UserVo();
		userVo.setId(request.getParameter("id"));
		userVo.setPassword(request.getParameter("password"));

		String authUserId = userService.login(userVo);

		if (authUserId == null) {
			request.setAttribute("id", userVo.getId());
			request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);

			return false;
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("authUserId", authUserId);

		response.sendRedirect(request.getContextPath());

		return false;
	}

}
