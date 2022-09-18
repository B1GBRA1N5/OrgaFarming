package com.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.spring.DAO.RegisterDAO;
import com.spring.Model.Email;
import com.spring.Model.RegisterForm;



@Service
public class RegisterService {
	
	Response response = new Response();
	@Autowired
	EmailService emailService;

	@Autowired
	private RegisterDAO registerDAO;

	public Response add1(RegisterForm msgModel) {
		response.setSuccessful(false);
		registerDAO.add1(msgModel);
		response.setSuccessful(true);
		response.setResponseObject(msgModel);
	/*	Email email = new Email();
		email.setFrom(" <luciferrocky216@gmail.com>");
		email.setTo(msgModel.getEmail().trim());
		email.setSubject("Orga-Farms Registration ");
		String msg = "Hi, "+msgModel.getName() + "<br><br>"
				+ " Welcome to OrgaFarms Community"+"<br><br>"+"Thanks For your Valueable FEEDBACK ....";
				
		email.setText(msg);
		emailService.sendHtmlMsg(email);*/
		return response;
	}

	public Response getReviews() {
		response.setSuccessful(false);
		List<RegisterForm> RegisterDetails = registerDAO.getReviews();
		response.setSuccessful(true);
		response.setResponseObject(RegisterDetails);
		return response;
	}
}
