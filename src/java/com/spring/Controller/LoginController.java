package com.spring.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.util.Md5Utils;
import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.HttpUtils;

import commons.util.Base64;
/*import in.apssdc.model.FileModel;*/
import com.spring.Model.Login;
import com.spring.Service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController 
{
	@Autowired
	private LoginService loginService;

	@ResponseBody
	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public Response login(@RequestBody Login login, HttpServletRequest httpServletRequest)
			throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipAddress = "CLIENT:" + clientIp + ", CLIENT_PROXY:" + clientProxyIp;
		login.setIpAddress(ipAddress);
		return loginService.login(login);
	}
	
}