package com.poscodx.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.UserVo;

@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;

	public String login(UserVo userVo) {
		return sqlSession.selectOne("user.login", userVo);
	}

	public void join(UserVo userVo) {
		sqlSession.insert("user.join", userVo);
	}

}
