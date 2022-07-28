package com.tradeviv.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tradeviv.pageObjects.AddMainCategory;
import com.tradeviv.pageObjects.AdminLoginPage;
import com.tradeviv.utilites.XLUtility;

public class TC_MainCategoryDDT_001 extends BaseClass{
	
	
	@Test (dataProvider="getData")
	public void addMainCategory(String mainname, String slug)
	{
		logger.info("URL is opened");
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.setAdminId(username);
		alp.setAdminPwd(password);
		alp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		AddMainCategory amc=new AddMainCategory(driver);
		amc.manageCategoryClick();
		amc.mainCategoryClick();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		amc.createMainCategory();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		amc.mainCategoryField("Leather");
		amc.slugField("leather");
		String imagepath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\main category.jpg";
		amc.mainImgUpload(imagepath);
		amc.submitMainCategory();	
	}
	
	@DataProvider
	public String [][] getData() throws IOException
	{
		//get the data from excel
		String path=System.getProperty("user.dir")+"/src/test/java/com/tradeviv/testData/Addmaincategory.xlsx";
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
