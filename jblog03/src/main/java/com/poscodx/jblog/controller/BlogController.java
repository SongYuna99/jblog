package com.poscodx.jblog.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.CategoryService;
import com.poscodx.jblog.service.PostService;
import com.poscodx.jblog.service.FileUploadService;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

@Controller
@RequestMapping("/blog/{id:^(?!assets).*}")
public class BlogController {
	@Autowired
	private BlogService blogService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PostService postService;

	@Autowired
	private FileUploadService fileUploadService;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping({ "", "/{categoryNo}", "/{categoryNo}/{postNo}" })
	public String index(@PathVariable("id") String blogId,
			@PathVariable(value = "categoryNo", required = false) Long categoryNo,
			@PathVariable(value = "postNo", required = false) Long postNo, Model model) {
		PostVo viewPost = postService.findFirstPost(categoryNo);
		if (postNo != null) {
			viewPost = postService.findByPostNo(postNo);
		}
		List<PostVo> list = postService.findByCategoryNo(viewPost);

		model.addAttribute("viewPost", viewPost);
		model.addAttribute("list", list);
		return "blog/main";
	}

	@RequestMapping({ "/admin/basic" })
	public String adminBasic(@PathVariable("id") String blogId, Model model) {
		BlogVo blogVo = blogService.findById(blogId);

		model.addAttribute("blogVo", blogVo);
		return "blog/admin-basic";
	}

	@RequestMapping({ "/admin/basic/update" })
	public String adminBasicUpdate(@PathVariable("id") String blogId, @RequestParam("logo-file") MultipartFile file) {
		BlogVo blogVo = blogService.findById(blogId);
		String url = fileUploadService.restore(file);

		if (url != null) {
			blogVo.setImage(url);
		}
		blogService.Update(blogVo);
		servletContext.setAttribute("blogVo", blogVo);

		return "redirect:/blog/" + blogId + "/admin/basic";
	}

	@RequestMapping(value = { "/admin/category" }, method = RequestMethod.GET)
	public String adminCategory(@PathVariable("id") String blogId, Model model) {
		List<CategoryVo> list = categoryService.findByBlogId(blogId);

		model.addAttribute("list", list);
		return "blog/admin-category";
	}

	@RequestMapping(value = { "/admin/category/add" }, method = RequestMethod.POST)
	public String adminCategoryAdd(@PathVariable("id") String blogId, CategoryVo categoryVo) {
		categoryVo.setBlogId(blogId);
		if (categoryService.insertNewCategory(categoryVo)) {
		}

		return "redirect:/blog/" + blogId + "/admin/category";
	}

	@RequestMapping(value = { "/admin/category/delete/{categoryNo}" })
	public String adminCategoryDelete(@PathVariable("id") String blogId, @PathVariable("categoryNo") Long no) {
		if (categoryService.deleteByNo(no)) {
		}

		return "redirect:/blog/" + blogId + "/admin/category";
	}

	@RequestMapping(value = { "/admin/write" }, method = RequestMethod.GET)
	public String adminWrite(@PathVariable("id") String blogId, Model model) {
		List<CategoryVo> list = categoryService.findByBlogId(blogId);

		model.addAttribute("list", list);
		return "blog/admin-write";
	}

	@RequestMapping(value = { "/admin/write" }, method = RequestMethod.POST)
	public String adminWrite2(@PathVariable("id") String blogId, PostVo postVo) {
		if (postService.insert(postVo)) {

		}

		return "redirect:/blog/" + blogId + "/admin/write";
	}
}
