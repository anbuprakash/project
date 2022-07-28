package com.green.dms;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

	@FindBy(id="details-button") private WebElement Advance;
	@FindBy(id="proceed-link") private WebElement Proceed;
	@FindBy(id="txtLoginId") private WebElement UserName;
	@FindBy(id="txtPassword") private WebElement Password;
	@FindBy(id="btnLogin") private WebElement Submit;
	
	public LoginPage() {
		System.out.println(driver);
		PageFactory.initElements(driver,this);;
	}

	
	public void advance() {
		Advance.click();
	}
	public void proceed() {
		Proceed.click();
	}
	public void inputName(String username) {
		UserName.sendKeys(username);
	}
	public void passwordBox(String password) {
		Password.sendKeys(password);
	}
	public void submit() {
		Submit.click();
	}
	


}
