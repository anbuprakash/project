package com.tradeviv.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.tradeviv.pageObjects.AdminLoginPage;

import junit.framework.Assert;

public class TC_AdminLoginTest_001 extends BaseClass 
{
	@Test
	public void adminLoginTest() throws IOException
	{
		
		logger.info("URL is opened");
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.setAdminId(username);
		logger.info("username pass");
		alp.setAdminPwd(password);
		alp.clickSubmit();
		captureScreen(driver, "TC_AdminLoginTest_001");
		Assert.assertTrue(false);
		logger.info("TC_AdminLoginTest_001 failed");
		
		
//		if()
//		{
//			alp.profileClick();
//			alp.logout();
//			Assert.assertTrue(true);
//		}
//		else
//		{
//			Assert.assertTrue(false);
//			captureScreen(driver, "TC_AdminLoginTest_001");
//		}
	}

}
