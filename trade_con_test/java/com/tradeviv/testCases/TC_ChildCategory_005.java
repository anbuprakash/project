package com.tradeviv.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.tradeviv.pageObjects.AddChildCategory;
import com.tradeviv.pageObjects.AdminLoginPage;

public class TC_ChildCategory_005 extends BaseClass{
	
	@Test
	public void addChildCategory()
	{
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.setAdminId(username);
		alp.setAdminPwd(password);
		alp.clickSubmit();
		
		AddChildCategory acc=new AddChildCategory(driver);
		acc.manageCategoryClick();
		acc.childCategoryClick();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		acc.addChildCategory();
		String main="sand";
		acc.selectMainCategory(main);
//		acc.selectSubCategory();
		acc.childCategoryField("Aluminium");
		acc.childSubField("aluminum");
		String imagepath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\subcategory.jpg";
		acc.childImgUpload(imagepath);
		acc.addTags("alumini");
		acc.submitChildCategory();
	}
}
