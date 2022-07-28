package com.green.dms;

import org.testng.annotations.Test;

public class LoginTest  extends TestBase{
	
	@Test
	public void login() {
		
		browesrOpen();
		LoginPage lg=new LoginPage();
		lg.advance();
		lg.proceed();
		lg.inputName(prop.getProperty("userName"));
		lg.passwordBox(prop.getProperty("passWord"));
		lg.submit();

		
	}


}
