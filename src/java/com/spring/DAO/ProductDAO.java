package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.spring.Model.Product;
import com.spring.Model.User;

@Repository
public class ProductDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void addProduct(Product proModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", proModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("product.addProduct", params);
		sqlSession.close();
	}
	public List<Product> getProducts() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Product> productdetails=sqlSession.selectList("product.getProducts");
		sqlSession.close();
		return productdetails;                      
	}

}

	