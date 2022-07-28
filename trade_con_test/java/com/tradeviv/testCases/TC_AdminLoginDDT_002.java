package com.tradeviv.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tradeviv.pageObjects.AdminLoginPage;
import com.tradeviv.utilites.XLUtils;

public class TC_AdminLoginDDT_002 extends BaseClass
{

	@Test(dataProvider="AdminLoginData")
	public void adminLoginDDT(String aID, String pwd) throws IOException, InterruptedException
	{
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.setAdminId(aID);
		logger.info("Username entered");
		alp.setAdminPwd(pwd);
		logger.info("password entered");
		alp.clickSubmit();
//		boolean b=driver.getPageSource().contains("Credentials Doesn't Match !");
//		if(b==true)
//			{
//				Assert.assertTrue(false);
//				captureScreen(driver, "adminLoginDDT");
//			}
//		else
//		{
//			Assert.assertTrue(true);
//		}
		
	}
	
	@DataProvider(name="AdminLoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/tradeviv/testData/adminLoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
