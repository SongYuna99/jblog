package com.poscodx.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscodx.jblog.service.UserService;
import com.poscodx.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login2(UserVo userVo, Model model) {
//		String id = userService.login(userVo);
//		
//		if(id == null) {
//			id=userVo.getId();
//			model.addAttribute("id", id);
//			return "user/login";
//		}
//
//		model.addAttribute("id", id);
//		return "main/index";
//	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join2(UserVo userVo) {
		userService.join(userVo);
		
		return "user/joinsuccess";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "main/index";
	}
}
