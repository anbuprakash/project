package com.pages.trade;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TradePages 
{

	@FindBy (xpath="//input[@class='User Name']")
	public static WebElement txtAdminId;
	@FindBy (xpath="//input[@class='Password']")
	public WebElement txtAdminPwd;
	@FindBy (xpath="//button[@class='submit-btn']")
	public WebElement btnAdminLogin;
	@FindBy(xpath="//div[@class='user-img']")
	public WebElement profile;
	@FindBy (xpath="//a[contains(text(),'Logout')]")
	public WebElement logout;
}
