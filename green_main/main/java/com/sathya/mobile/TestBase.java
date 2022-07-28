package com.sathya.mobile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestBase {
	
	
  public  static Logger logger=null;
	public static WebDriver driver;
	public Properties prop;
	
	

	public TestBase(){

		prop =  new Properties(); 
		try {
			InputStream input = new	 FileInputStream(".//confi.properties");
			prop.load(input);

		} catch (Exception e) { e.printStackTrace(); } }

	public void openBrowser() {
		logger=Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", ".//ChromeDriver//chromedriver.exe");
		logger.info("Launch the ChromeBrowser");
		driver=new ChromeDriver();
		logger.info("Launch the url");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

}
