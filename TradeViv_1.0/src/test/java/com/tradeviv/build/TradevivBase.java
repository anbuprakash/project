package com.tradeviv.build;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TradevivBase 
{
	public static WebDriver driver;
	public Properties prop;
	public  static Logger logger=null;

	public TradevivBase() 
	{
		prop =  new Properties(); //get data property file
		try 
		{
			InputStream input = new	 FileInputStream(".//Properties//Config.properties");
			prop.load(input);

		} 
		catch (Exception e) 
		{ 
			e.printStackTrace();
		} 
	}
	public void browserInitialization()
	{
		//open browser & launch url

		logger=Logger.getLogger(TradevivBase.class);
		PropertyConfigurator.configure(".//Properties//Log4j.properties");
		System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
		logger.info("Launch the ChromeBrowser");
		driver=new ChromeDriver();  //open chromeDriver
		logger.info("Launch the url");
		driver.get(prop.getProperty("Admin")); //get tradeviv url
		driver.manage().window().maximize();
	}
	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	public void explicitWait()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
	}

}
