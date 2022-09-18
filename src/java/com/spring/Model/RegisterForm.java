package com.spring.Model;

import com.andromeda.commons.model.BaseModel;

public class RegisterForm extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	public String name;
	public String email;
	public String review_text;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReview_text() {
		return review_text;
	}
	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	


}
