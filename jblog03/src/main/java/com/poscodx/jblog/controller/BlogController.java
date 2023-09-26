package com.poscodx.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog/{id:^(?!assets).*}")
public class BlogController {

	@RequestMapping({ "", "/{categoryNo}", "/{categoryNo}/{postNo}" })
	public String index(@PathVariable("id") String blogId,
			@PathVariable(value = "categoryNo", required = false) Long categoryNo,
			@PathVariable(value = "postNo", required = false) Long postNo) {
		return "blog/main";
	}

	@RequestMapping({ "/admin/basic" })
	public String adminBasic(@PathVariable("id") String blogId) {
		return "blog/admin-basic";
	}

	@RequestMapping({ "/admin/category" })
	public String adminCategory(@PathVariable("id") String blogId) {
		return "blog/admin-category";
	}
	
	@RequestMapping({ "/admin/write" })
	public String adminWrite(@PathVariable("id") String blogId) {
		return "blog/admin-write";
	}
}
