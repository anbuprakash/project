package com.tradeviv.register;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegistrationBase {
	
	public static WebDriver driver;
	public Properties prop;
	public  static Logger logger=null;
	
	public RegistrationBase() {
		
		//get data from property file 
		
		prop =  new Properties(); 
		try {
			InputStream input = new	 FileInputStream(".//confi.properties");
			prop.load(input);

		} catch (Exception e) { e.printStackTrace(); } }

	
	public void browserOpen() {
		
		//open browser & launch url
		
		logger=Logger.getLogger(RegistrationBase.class);
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", ".//ChromeDriver//chromedriver.exe");
		logger.info("Launch the ChromeBrowser");
		driver=new ChromeDriver();  //open chrome browser
		logger.info("Launch the url");
		driver.get(prop.getProperty("url1"));  //get tradeviv url
		driver.manage().window().maximize();
		
	}
	
	public void delay() {
		
		
		//time taken
		
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}

}
