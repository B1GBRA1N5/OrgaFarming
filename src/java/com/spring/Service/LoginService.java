package com.spring.Service;

import com.spring.Model.Email;
import com.spring.Model.Login;
import com.spring.Model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.andromeda.commons.model.Response;
import com.spring.DAO.LoginDAO;
import com.andromeda.commons.util.AadhaarUtils;
import com.andromeda.commons.util.CryptoUtils;
import com.andromeda.commons.util.IDGenerator;

@Service
public class LoginService
{
	@Autowired
	EmailService emailService;
	
	@Autowired
	private LoginDAO loginDAO;
	Response response = new Response();

	public Response login(Login login)
	{
		response.setSuccessful(false);
		
		login.setPassword(login.getPassword());
		Integer userStatus = loginDAO.checkUser(login);

		if (userStatus == 0)
		{
			response.setSuccessful(false);
		}
		else if (userStatus > 0)
		{
			Login details = loginDAO.getUserDetails(login);
			response.setSuccessful(true);
			response.setResponseObject(details);
		}
		
		return response;
	}
}