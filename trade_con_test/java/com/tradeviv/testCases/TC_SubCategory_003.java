package com.tradeviv.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tradeviv.pageObjects.AddSubCategory;
import com.tradeviv.pageObjects.AdminLoginPage;

public class TC_SubCategory_003 extends BaseClass
{
	@Test
	public void addSubCategory()
	{
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.setAdminId(username);
		alp.setAdminPwd(password);
		alp.clickSubmit();
		
		AddSubCategory asc=new AddSubCategory(driver);
		asc.manageCategoryClick();
		asc.subCategoryClick();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		asc.createSubCategory();
		String main="main";
		asc.subCategoryField("Copper wire");
		asc.subSlugField("copperwire");
		String imagepath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\subcategory.jpg";
		asc.subImageUpload(imagepath);
		asc.submitSubCategory();
		
	}
}
