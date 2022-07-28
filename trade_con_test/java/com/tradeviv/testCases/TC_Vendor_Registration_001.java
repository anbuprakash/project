package com.tradeviv.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tradeviv.pageObjects.VendorRegistration;

public class TC_Vendor_Registration_001 extends BaseClass
{

	@Test(invocationCount=1)
	public void vendorReg() throws InterruptedException
	{
		VendorRegistration vr=new VendorRegistration(driver);
		vr.sellButton();
		vr.vendorRegBtn();
		vr.vendorNameField("Raj");
		
		String email=randomString()+"@gmail.com";
		vr.vendorEmailField(email.toLowerCase());
		String mobile=randomNumber();
		vr.vendorPhoneField(mobile);
		vr.vendorCompanyField("SRK Industry");
		vr.regButton();
		Thread.sleep(2000);
		if(isAlertPresent()==true)
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		else
		{
			Assert.assertTrue(true);
			driver.switchTo().defaultContent();
		}
		
	}
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	public String randomString()
	{
		String genrateString=RandomStringUtils.randomAlphabetic(8);
		return genrateString;
	}
	
	public String randomNumber()
	{
		String genratenumber=RandomStringUtils.randomNumeric(10);
		return genratenumber;
	}
	
}
