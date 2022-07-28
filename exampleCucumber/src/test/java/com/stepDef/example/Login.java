package com.stepDef.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tradeviv.login.LoginBase;
import com.tradeviv.login.LoginData;
import com.tradeviv.login.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	public static WebDriver driver;
	public Properties prop;
	public  static Logger logger=null;
	
	public Login() {
		prop =  new Properties(); //get data property file
		try {
			InputStream input = new	 FileInputStream(".//Properties//info.properties");
			prop.load(input);

		} catch (Exception e) { e.printStackTrace(); } }

	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		logger=Logger.getLogger(LoginBase.class);
		PropertyConfigurator.configure(".//Properties//Log4j.properties");
		System.setProperty("webdriver.chrome.driver", ".//Browser//chromedriver.exe");
		logger.info("Launch the ChromeBrowser");
		driver=new ChromeDriver();  //open chromeDriver
		logger.info("Launch the url");
		driver.get(prop.getProperty("url")); //get tradeviv url
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   
	}
	
	ArrayList<LoginData> details=new ArrayList<LoginData>();
	String vendormail,password;
	


	//pagefactory

	@FindBy(xpath="//span[contains(text(),'Accounts & Lists')]") 
	private WebElement List;
	@FindBy(className="sign-in-btn") 
	private WebElement Sign;
	@FindBy(id="nav-log-tab11") 
	private WebElement LoginVendor;
	@FindBy(xpath="//div[@id='nav-log11']//input[@name='email']") 
	private WebElement VendorMail;
	@FindBy(xpath="//div[@id='nav-log11']//input[@type='password']") 
	private WebElement Password;
	@FindBy(xpath="//div[@id='nav-log11']//button[@type='submit']") 
	private WebElement submit;
	@FindBy(xpath="//div[@id='vendor-login']//button[@class='close']") 
	private WebElement Close;
	@FindBy(xpath="//div[@class='user-img']") 
	private WebElement Logout;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement Logout1;
	

	@When("User Navigate to LogIn Page")
	public void user_navigate_to_log_in_page() {
		
		PageFactory.initElements(driver,this);
		logger=Logger.getLogger(LoginPage.class);
		
		logger.info("Click Account & Lists");
		List.click();  //click Accounts & List

		logger.info("Click Sign in Button");
		Sign.click();   //Click Sign In

		logger.info("Click Vendor Login");

		LoginVendor.click();  //Click vendor login
		
	  
	}


	@When("User enters UserName and Password")
	public void user_enters_user_name_and_password() throws IOException {
		
		PageFactory.initElements(driver,this);
		logger=Logger.getLogger(LoginPage.class);
		logger.info("Get Data In Excel");

		FileInputStream fis = new FileInputStream("D:\\prakash\\excelldata\\logindata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

			String vendormail=sheet.getRow(1).getCell(1).getStringCellValue();
			String password=sheet.getRow(1).getCell(2).getStringCellValue();
			details.add(new LoginData(vendormail, password));

		fis.close();
		logger.info("Write User Mail id");
		VendorMail.clear();
		VendorMail.sendKeys(details.get(0).getvendormail());  //find & send user id

		logger.info("Write Password");
		Password.clear();
		Password.sendKeys(details.get(0).getpassword());   //find & send password

		logger.info("Click Login Button");
		submit.click();  //find & click login button
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() throws IOException {
		
		PageFactory.initElements(driver,this);
		logger=Logger.getLogger(LoginPage.class);
		
		logger.info("Take Screenshot");
		TakesScreenshot scrShot =((TakesScreenshot) driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(".//Screenshot"+".//Screenshot.png");
		FileHandler.copy(SrcFile, DestFile);

		logger.info("Click Logout button");
		
		Logout.click();     //logout

		Logout1.click();
		File DestFile1=new File(".//Screenshot"+".//Screenshot1.png");
		FileHandler.copy(SrcFile, DestFile1);


	  
	}


}
