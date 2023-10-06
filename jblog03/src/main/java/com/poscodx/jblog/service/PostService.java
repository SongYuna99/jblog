package com.poscodx.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.PostRepository;
import com.poscodx.jblog.vo.PostVo;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public boolean insert(PostVo postVo) {
		return postRepository.insert(postVo);
	}

	public PostVo findByPostNo(Long postNo) {
		return postRepository.findByPostNo(postNo);
	}

	public List<PostVo> findByCategoryNo(PostVo viewPost) {
		return postRepository.findByCategoryNo(viewPost);
	}

	public PostVo findFirstPost(Long categoryNo) {
		return postRepository.findFirstPost(categoryNo);
	}
}
