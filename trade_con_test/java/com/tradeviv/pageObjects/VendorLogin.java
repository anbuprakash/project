package com.tradeviv.pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tradeviv.testCases.BaseClass;

public class VendorLogin extends BaseClass{

WebDriver ldriver;
	public VendorLogin(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(@class,'sell')]")
	@CacheLookup
	WebElement sellbtn;
	
	@FindBy(xpath="//*[@id=\"nav-log-tab11\"]")
	@CacheLookup
	WebElement loginsection;
	
	@FindBy(xpath="(//input[contains(@placeholder,'Type Email Address')])[2]")
	@CacheLookup
	WebElement vendor_email;
	
	@FindBy(xpath="(//input[contains(@class,'Password')])[4]")
	@CacheLookup
	WebElement vendor_password;
	
	@FindBy(xpath="(//button[@class='submit-btn' and text()='Login' and @type='submit'])[2]")
	@CacheLookup
	WebElement login_btn;
	
	public void sellButton()
	{
		sellbtn.click();
	}
	
	public void vendorLoginSection()
	{
		loginsection.click();
	}
	
	public void emailField(String email)
	{
		explicitWait(vendor_email, driver);
		vendor_email.sendKeys(email);
	}
	
	public void passwordField(String pwd)
	{
		vendor_password.sendKeys(pwd);
	}
	
	public void loginVendor()
	{
		login_btn.click();
	}

}
