package com.tradeviv.login;

import java.io.IOException;

import org.testng.annotations.Test;

public class LoginTest extends LoginBase{
	@Test
	public void test() throws IOException {
		browserOpen(); //browser open
		delay();  //time take
		LoginPage login=new LoginPage(); //object create page class
		login.vendorLogin();  //call method
	
	}

}
