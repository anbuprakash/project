package com.tradeviv.build;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TradevivAdminPage extends TradevivBase
{

	@FindBy (xpath="//input[@class='User Name']")
	private WebElement user;
	@FindBy (xpath="//input[@class='Password']")
	private WebElement password;
	@FindBy (xpath="//button[@class='submit-btn']")
	private WebElement button;


	public TradevivAdminPage()
	{ 
		PageFactory.initElements(driver, this);
		logger=Logger.getLogger(TradevivAdminPage.class);
	}
	public void userMail() 
	{  

		user.sendKeys(prop.getProperty("UserName"));
	}
	public void passWord () 
	{	
		password.sendKeys(prop.getProperty("Password"));

	}
	public void login()
	{	
		button.click();

	}


}
