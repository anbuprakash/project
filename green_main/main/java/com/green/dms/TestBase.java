package com.green.dms;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestBase {
	
	public static WebDriver driver;
	public Properties prop;
	  
	  public TestBase(){
	  prop =  new Properties(); 
	  try {
	  InputStream input = new	 FileInputStream(".//src//main//java//com//green//dms//info.properties");
	  prop.load(input);
//	  System.out.println(prop.getProperty("url"));
//	  System.out.println(prop.getProperty("userName"));
//	  System.out.println(prop.getProperty("passWord"));
	  } catch (Exception e) { e.printStackTrace(); } }
	 

	
	public void browesrOpen() {
		System.setProperty("webdriver.chrome.driver", ".//ChromeDriver//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}

}
