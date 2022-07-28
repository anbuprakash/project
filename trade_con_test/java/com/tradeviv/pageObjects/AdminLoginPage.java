package com.tradeviv.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	WebDriver ldriver;
	
	public AdminLoginPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}	
	
	@FindBy(name="email")
	@CacheLookup
	WebElement txtAdminId;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtAdminPwd;
	
	@FindBy(xpath="//*[@id=\"loginform\"]/button")
	@CacheLookup
	WebElement btnAdminLogin;
	
	@FindBy(xpath="(//a[contains(@class,'dropdown-toggle-1')])[6]")
	@CacheLookup
	WebElement profile;
	
	@FindBy(xpath="//a[contains(@href,'logout')]")
	@CacheLookup
	WebElement logout;
	
	public void setAdminId(String adminId)
	{
		txtAdminId.sendKeys(adminId);
	}
	
	public void setAdminPwd(String adminPwd)
	{
		txtAdminPwd.sendKeys(adminPwd);
	}
	
	public void clickSubmit()
	{
		btnAdminLogin.click();
		
	}
	
	public void profileClick()
	{
		profile.click();
	}
	
	public void logout()
	{
		logout.click();
	}
}
