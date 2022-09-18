package com.spring.Model;

import com.andromeda.commons.model.BaseModel;

public class Login extends BaseModel
{
	private static final long serialVersionUID = 1L;
	private String username;
	private String mail;
	private String password; 
	private String type;
	private String ipAddress;
	private String logtime;
	private String location;
	
	

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	
	
	
	


}