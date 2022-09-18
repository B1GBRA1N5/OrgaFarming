package com.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.spring.DAO.ProductDAO;
import com.spring.Model.Email;
import com.spring.Model.Product;
import com.spring.Model.User;


@Service
public class ProductService {
	
	Response response = new Response();
	@Autowired
	EmailService emailService;

	@Autowired
	private ProductDAO productDAO;

	public Response addProduct(Product proModel) {
		response.setSuccessful(false);
		productDAO.addProduct(proModel);
		response.setSuccessful(true);
		response.setResponseObject(proModel);
		return response;
	}
	public Response getProducts() {
		response.setSuccessful(false);
		List<Product> productdetails = productDAO.getProducts();
		response.setSuccessful(true);
		response.setResponseObject(productdetails);
		return response; 
	}                       
}                                           