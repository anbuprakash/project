package com.tradeviv.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tradeviv.pageObjects.AddSubCategory;
import com.tradeviv.pageObjects.AdminLoginPage;
import com.tradeviv.utilites.XLUtility;

public class TC_SubCategoryDDT_001 extends BaseClass{
	@Test(dataProvider="getData")
	public void addSubCategory(String subcategory, String slug)
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
		asc.mainCategoryDropDown(main);
		asc.subCategoryField(subcategory);
		asc.subSlugField(slug);
		String imagepath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\subcategory.jpg";
		asc.subImageUpload(imagepath);
		asc.submitSubCategory();
	}
	
	@DataProvider
	public String [][] getData() throws IOException
	{
		//get the data from excel
		String path=System.getProperty("user.dir")+"/src/test/java/com/tradeviv/testData/subCategory.xlsx";
		String[][] subCatData=dataProvider(path);
		return subCatData;
	}


}
