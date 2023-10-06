package com.poscodx.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.CategoryVo;

@Repository
public class CategoryRepository {
	@Autowired
	private SqlSession sqlSession;

	public void insertBasicCategory(String id) {
		sqlSession.insert("category.insertBasicCategory", id);
	}

	public List<CategoryVo> findByBlogId(String blogId) {
		return sqlSession.selectList("category.findByBlogId", blogId);
	}

	public boolean insertNewCategory(CategoryVo categoryVo) {
		return sqlSession.insert("category.insertNewCategory", categoryVo) == 1;
	}

	public boolean deleteByNo(Long no) {
		return sqlSession.delete("category.deleteByNo", no) == 1;
	}

}
