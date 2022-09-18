package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.spring.Model.RegisterForm;

@Repository
public class RegisterDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void add1(RegisterForm msgModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", msgModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("message.Insert", params);
		sqlSession.close();
	}


	public List<RegisterForm> getReviews() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<RegisterForm> RegisterDetails=sqlSession.selectList("message.getReviews");
		sqlSession.close();
		return RegisterDetails;
	}
}