package com.tradeviv.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.tradeviv.pageObjects.AddMainCategory;
import com.tradeviv.pageObjects.AdminLoginPage;

public class TC_MainCategory_004 extends BaseClass{
	
	@Test
	public void addMainCategory()
	{
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.setAdminId(username);
		alp.setAdminPwd(password);
		alp.clickSubmit();
		
		AddMainCategory amc=new AddMainCategory(driver);
		amc.manageCategoryClick();
		amc.mainCategoryClick();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		amc.createMainCategory();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		amc.mainCategoryField("Leather");
		amc.slugField("leather");
		String imagepath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\subcategory.jpg";
		amc.mainImgUpload(imagepath);
		amc.submitMainCategory();
	}

}
