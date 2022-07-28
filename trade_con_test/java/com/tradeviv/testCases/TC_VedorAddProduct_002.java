package com.tradeviv.testCases;


import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tradeviv.pageObjects.VendorAddProduct;
import com.tradeviv.pageObjects.VendorLogin;

public class TC_VedorAddProduct_002 extends BaseClass{
	
	@BeforeClass
	public void vendorLogin()
	{
		VendorLogin vl=new VendorLogin(driver);
		vl.sellButton();
		vl.vendorLoginSection();
		vl.emailField("tradeviv99@gmail.com");
		vl.passwordField("wDfkBM");
		vl.loginVendor();
	}
	
	@Test(invocationCount=100)
	public void addNewproduct() throws InterruptedException, IOException
	{
		
		try {
			
			VendorAddProduct vap=new VendorAddProduct(driver);
			vap.clickProductMenu();
			vap.clickAddNewProductMenu();
//			Thread.sleep(2000);
			String p_name="product_"+randomNumber();
			vap.addproductName(p_name);
			vap.selectMainCategory(1);
			Thread.sleep(2000);
			WebDriverWait wait=new WebDriverWait(driver,30);
//			wait.until(ExpectedConditions.visibilityOf(vap.selectSubCategory(2)));
			Thread.sleep(2000);
			vap.selectSubCategory(2);
			Thread.sleep(2000);
			vap.selectChildCategory(3);
			Thread.sleep(2000);
			int location_index=Integer.parseInt(randomLocation());
			vap.selectLocation(location_index);
			vap.productFeatureSNo();
			vap.productFeatureSpeci("product specification");
			vap.productFeatureValue("product values");
			vap.productDescription("Something about product");
			vap.produtPrice(randomNumber());
			vap.productMeasurement(1);
			vap.priceVaraintQty("100");
			vap.priceVariantPrice("20000");
			vap.priceVaraintMeas("per product");
			vap.producAvailability("10000");
			vap.productShippingDescription();
			vap.estimateDeleiveryQty("100");
			vap.estimateDeliverDays("5 days");
			
			String img_path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\Plywood.jpg";
			vap.productImage(img_path);
			
			String pp_path1=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\subcategory.jpg";
			vap.productpackageImage(pp_path1);
			
			String pt_path1=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\subcategory.jpg";
			vap.productTransportaionImg(pt_path1);
			
			vap.addProductSubmit();
			vap.successfullMessage();
			logger.info(p_name+":"+vap.successfullMessage());
			
		}
		catch(Exception e)
		{
			
			captureScreen(driver, "TC_VedorAddProduct_002_Bug_");
			logger.info(e);
			Assert.assertTrue(false);
			
		}
				
	}
	
	public String randomString()
	{
		String genrateString=RandomStringUtils.randomAlphabetic(8);
		return genrateString;
	}
	
	public String randomNumber()
	{
		String genratenumber=RandomStringUtils.randomNumeric(5);
		return genratenumber;
	}
	public String randomLocation()
	{
		String genratenumber=RandomStringUtils.randomNumeric(2);
		return genratenumber;
	}

}
