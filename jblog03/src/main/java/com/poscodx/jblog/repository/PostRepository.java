package com.poscodx.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.PostVo;

@Repository
public class PostRepository {
	@Autowired
	private SqlSession sqlSession;

	public boolean insert(PostVo postVo) {
		return sqlSession.insert("post.insert", postVo) == 1;
	}

	public PostVo findByPostNo(Long postNo) {
		return sqlSession.selectOne("post.findByPostNo", postNo);
	}

	public List<PostVo> findByCategoryNo(PostVo viewPost) {
		return sqlSession.selectList("post.findByCategoryNo", viewPost);
	}

	public PostVo findFirstPost(Long categoryNo) {
		return sqlSession.selectOne("post.findFirstPost", categoryNo);
	}

}
