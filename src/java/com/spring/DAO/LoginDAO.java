package com.spring.DAO;


import com.spring.Model.Login;
import com.spring.Model.User;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.andromeda.commons.dao.BaseDAO;

@Repository
public class LoginDAO extends BaseDAO
{

	public Integer checkUser(Login login)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);
		Integer userStatus = sqlSessionTemplate.selectOne("Login.checkUser", map);
		return userStatus;
	}

	public Login getUserDetails(Login login)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

		Login details = sqlSessionTemplate.selectOne("Login.getUserDetails", map);
		return details;
	}
}