package com.tradeviv.register;

import java.io.IOException;

import org.testng.annotations.Test;

public class RegistrationTest extends RegistrationBase {
	@Test
	public void test() throws IOException {
		browserOpen();   //open browser
		delay();  //time taken
		RegistrationPage register=new RegistrationPage();  //object create registrationpage
		register.vendorRegister();  //call method
		
	}

}
