package com.poscodx.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{id}")
public class BlogController {

	@RequestMapping({ "", "/{categoryNo}", "/{categoryNo}/{postNo}" })
	public String index(@PathVariable("id") String blogId, @PathVariable("categoryNo") Long categoryNo,
			@PathVariable("postNo") Long postNo) {
		return "main/index";
	}

	@RequestMapping({ "/admin/basic" })
	public String adminBasic(@PathVariable("id") String blogId) {
		return "blog/admin-basic";
	}

	@RequestMapping({ "/admin/category" })
	public String adminCategory(@PathVariable("id") String blogId) {
		return "blog/admin-category";
	}
}