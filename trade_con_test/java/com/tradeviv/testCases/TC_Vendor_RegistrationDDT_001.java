package com.tradeviv.testCases;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tradeviv.pageObjects.VendorRegistration;
import com.tradeviv.utilites.XLUtility;

public class TC_Vendor_RegistrationDDT_001 extends BaseClass {
		
	@Test(dataProvider="getData")
	public void vendorReg(String name, String email, String mobile, String company) throws InterruptedException, IOException
	{
		VendorRegistration vr=new VendorRegistration(driver);
		
			vr.sellButton();
			vr.vendorRegBtn();
			vr.vendorNameField(name);
			vr.vendorEmailField(email);
			vr.vendorPhoneField(mobile);
			vr.vendorCompanyField(company);
			vr.regButton();
			Thread.sleep(2000);
			if(isAlertPresent()==true)
			{
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}
			else
			{
				Assert.assertTrue(true);
				driver.switchTo().defaultContent();
			}
			vr.alertClose();
			vr.closePOP();
			
		
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
	
	
	
	@DataProvider
	public String [][] getData() throws IOException
	{
		//get the data from excel
		String path="C:\\Users\\RAJ\\eclipse-workspace\\tradeVIV_V1\\src\\test\\java\\com\\tradeviv\\testData\\vendorRegData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		}	
		return loginData;
	}

		
}
