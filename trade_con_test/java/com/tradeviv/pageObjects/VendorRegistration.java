package com.tradeviv.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tradeviv.testCases.BaseClass;

public class VendorRegistration extends BaseClass{

WebDriver ldriver;
BaseClass bc=new BaseClass();
//WebDriverWait wait2 = new WebDriverWait(ldriver, 10);
	
	public VendorRegistration(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@class='sell-btn']")
//	@CacheLookup
	WebElement sellbtn;
	
	@FindBy(xpath="//a[@href='#nav-reg11']")
//	@CacheLookup
	WebElement ven_reg;
	
	@FindBy(xpath="//input[@placeholder='Vendor Name']")
//	@CacheLookup
	WebElement vendorname;
	
	@FindBy(xpath="//input[@placeholder='Company E-mail']")
//	@CacheLookup
	WebElement vendor_email;
	
	@FindBy(xpath="//input[@placeholder='Vendor Phone number']")
//	@CacheLookup
	WebElement vendor_phone;
	
	@FindBy(xpath="//input[@placeholder='Company Name']")
//	@CacheLookup
	WebElement company_name;
	
	@FindBy(xpath="(//button[@class='submit-btn'])[5]")
//	@CacheLookup
	WebElement reg_submit;
	
	@FindBy(xpath="(//button[@class='close alert-close'])[10]")
//	@CacheLookup
	WebElement alert_close;
	
	@FindBy(xpath="(//button[@class='close'])[3]")
	@CacheLookup
	WebElement closepop;
	
	
	
	public void sellButton()
	{
		bc.explicitWait(sellbtn, driver);
//		bc.callJavascriptExecutor(sellbtn);
		sellbtn.click();
	}
	
	public void vendorRegBtn()
	{
		ven_reg.click();
	}
	
	public void vendorNameField(String name)
	{
		vendorname.clear();
		vendorname.sendKeys(name);
	}
	
	public void vendorEmailField(String email)
	{
		vendor_email.clear();
		vendor_email.sendKeys(email);
	}
	
	public void vendorPhoneField(String phone)
	{
		vendor_phone.clear();
		vendor_phone.sendKeys(phone);
	}
	
	public void vendorCompanyField(String company)
	{
		bc.explicitWait(company_name,driver);
		company_name.clear();
		company_name.sendKeys(company);
	}
	
	public void regButton()
	{
//		wait2.until(ExpectedConditions.elementToBeClickable(reg_submit));
		bc.explicitWait(reg_submit, driver);
		reg_submit.click();
	}
	
	public void alertClose()
	{
		alert_close.click();
	}
	
	public void closePOP()
	{
		bc.explicitWait(closepop, driver);
		bc.callJavascriptExecutor(closepop);
//		closepop.click();
	}

}
