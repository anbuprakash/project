package com.tradeviv.login;

public class LoginData {
	private String vendormail,password;

	public  LoginData(String vendormail,String password) {
		this.vendormail=vendormail;
		this.password=password;

	}

	public String getvendormail() {
		return vendormail;
	}
	public String getpassword() {
		return password;
	}

}
