package com.poscodx.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.CategoryService;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/blog/{id:^(?!assets).*}")
public class BlogController {
	@Autowired
	private BlogService blogService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping({ "", "/{categoryNo}", "/{categoryNo}/{postNo}" })
	public String index(@PathVariable("id") String blogId,
			@PathVariable(value = "categoryNo", required = false) Long categoryNo,
			@PathVariable(value = "postNo", required = false) Long postNo) {
		return "blog/main";
	}

	@RequestMapping({ "/admin/basic" })
	public String adminBasic(@PathVariable("id") String blogId, Model model) {
		BlogVo blogVo = blogService.findById(blogId);

		model.addAttribute("blogVo", blogVo);
		return "blog/admin-basic";
	}

	@RequestMapping({ "/admin/category" })
	public String adminCategory(@PathVariable("id") String blogId, Model model) {
		List<CategoryVo> list = categoryService.findByBlogId(blogId);

		model.addAttribute("list", list);
		return "blog/admin-category";
	}

	@RequestMapping({ "/admin/write" })
	public String adminWrite(@PathVariable("id") String blogId, Model model) {
		List<CategoryVo> list = categoryService.findByBlogId(blogId);

		model.addAttribute("list", list);
		return "blog/admin-write";
	}
}
