package com.poscodx.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.BlogRepository;
import com.poscodx.jblog.vo.BlogVo;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public void insert(String id) {
		blogRepository.insert(id);
	}

	public BlogVo findById(String authUserId) {
		return blogRepository.findById(authUserId);
	}

	public void Update(BlogVo blogVo) {
		blogRepository.update(blogVo);
	}
}
