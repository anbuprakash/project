package com.yahoo.acc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatYahooAccount {
	
	public WebDriver driver;
	
	public void browserLaunch()  {
		
		driver=new ChromeDriver();  //launch ChromeDriver
		driver.get("https://in.yahoo.com/?p=us");  //Yahoo url
		driver.manage().window().maximize();   //maximize window
		driver.findElement(By.linkText("Sign in")).click();  //click sign in
		driver.findElement(By.id("createacc")).click();  //click create an account
		
	//	driver.findElement(By.id("usernamereg-altreg")).click();  //change to  email
		
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("anbu");  //find & send first name
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("prakash"); //find & send last name
		
		WebElement suggestname= driver.findElement(By.id("usernamereg-yid"));  //select mail address
		suggestname.sendKeys("anbarasuprakash");
		suggestname.sendKeys(Keys.ARROW_DOWN);
		suggestname.sendKeys(Keys.ENTER);
	
		driver.findElement(By.id("usernamereg-password")).sendKeys("@smple12345678");   //find & send password
		driver.findElement(By.id("usernamereg-phone")).sendKeys("7639237483");  //find & send mobile number
	    WebElement dropdown=driver.findElement(By.id("usernamereg-month"));  //find & select month
	    Select select=new Select(dropdown);
	    select.selectByVisibleText("April");
	    
	    driver.findElement(By.id("usernamereg-day")).sendKeys("10");   //find & send day
	    driver.findElement(By.id("usernamereg-year")).sendKeys("1995"); //find & send year
	    driver.findElement(By.id("usernamereg-freeformGender")).sendKeys("male"); //find & send name
	    driver.findElement(By.id("reg-submit-button")).click();  //click continue
	    
	 
	    
	    
//	    driver.close();
	}
	

	
}
