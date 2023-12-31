package com.poscodx.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.CategoryRepository;
import com.poscodx.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public void insertBasicCategory(String id) {
		categoryRepository.insertBasicCategory(id);
	}

	public List<CategoryVo> findByBlogId(String blogId) {
		return categoryRepository.findByBlogId(blogId);
	}

	public boolean insertNewCategory(CategoryVo categoryVo) {
		return categoryRepository.insertNewCategory(categoryVo);
	}

	public boolean deleteByNo(Long no) {
		return categoryRepository.deleteByNo(no);
	}

}
