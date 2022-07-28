package sample.cucumbersample;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SathyaBase 
{
	public  static Logger logger=null;
	public static WebDriver driver;
	public Properties prop;



	public SathyaBase()
	{

		prop =  new Properties(); 
		try 
		{
			InputStream input = new	 FileInputStream(".//properties//confi.properties");
			prop.load(input);

		} 
		catch (Exception e) 
		{ 
			e.printStackTrace();
		} 
	}

	public void openBrowser()
	{
		logger=Logger.getLogger(SathyaBase.class);
		PropertyConfigurator.configure(".//properties//log4j.properties");
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		logger.info("Launch the ChromeBrowser");
		driver=new ChromeDriver();
		logger.info("Launch the url");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

}
