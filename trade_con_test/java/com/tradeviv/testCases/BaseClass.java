package com.tradeviv.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.tradeviv.utilites.ReadConfig;
import com.tradeviv.utilites.XLUtility;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	private String baseURL=readconfig.getApplicaionURl();
	public String uRL=readconfig.getURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void setup(String br)
	{
		logger= Logger.getLogger("tradeviv");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
		driver =new ChromeDriver();
		}
		else if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie")){
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
//	@AfterClass(alwaysRun=true)
//	public void tearDown()
//	{
//		driver.quit();
//	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshots/" +tname+".png");
		FileUtils.copyFile(source,target);
//		System.out.println("Screenshot taken");
		logger.info("Screenshot taken");
	}
	
	public void callJavascriptExecutor(WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",ele);
//		js.executeAsyncScript("window.scrollBy(0,1000)");
	}
	
	public void unhandeledAlertException()
	{
	    try
	    {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      System.out.println("Alert data: " + alertText);
		      alert.accept();
		 } 
	    catch (NoAlertPresentException e) {
		        e.printStackTrace();
		 }
	}
	
	public void explicitWait(WebElement ele, WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.visibilityOf(ele));
//		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public String [][] dataProvider(String path) throws IOException
	{

		XLUtility xlutil=new XLUtility(path);
	
	
	int totalrows=xlutil.getRowCount("Sheet1");
	int totalcols=xlutil.getCellCount("Sheet1",1);	
			
	String myData[][]=new String[totalrows][totalcols];
		
	
	for(int i=1;i<=totalrows;i++) //1
	{
		for(int j=0;j<totalcols;j++) //0
		{
			myData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
		}
			
	}	
	return myData;
	}
}
