package com.spring.Controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.HttpUtils;
import com.spring.Model.User;
import com.spring.Model.RegisterForm;
import com.spring.Service.RegisterService;


@RestController
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private RegisterService msg;
	
	@ResponseBody
	@RequestMapping(value = "add1", method = { RequestMethod.POST })
	public Response add1(@RequestBody RegisterForm msgModel)
	{
		return msg.add1(msgModel);
	}
	
	@ResponseBody
	@RequestMapping(value = "getReviews", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getReviews()
	{
		return msg.getReviews();
	}
}
