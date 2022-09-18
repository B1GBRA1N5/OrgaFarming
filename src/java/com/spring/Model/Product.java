package com.spring.Model;

import com.andromeda.commons.model.BaseModel;

public class Product extends BaseModel {

	private static final long serialVersionUID = 1L;
	public String p_name;
	public String p_cost;
	public String p_img;
	public String Base64String;
	
	
	
	public String getBase64String() {
		return Base64String;
	}
	public void setBase64String(String base64String) {
		Base64String = base64String;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_cost() {
		return p_cost;
	}
	public void setP_cost(String p_cost) {
		this.p_cost = p_cost;
	}
	public String getP_img() {
		return p_img;
	}
	public void setP_img(String p_img) {
		this.p_img = p_img;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
