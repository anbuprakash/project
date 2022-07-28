package com.tradeviv.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class LoginPage extends LoginBase{

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
	@FindBy(xpath="//a[@class='wave-effect  waves-effect waves-button']")
	private WebElement company;
	@FindBy(xpath="//*[@id=\"geniusfor\"]/div[1]/div[2]/div[2]/div")
	private WebElement shop;
	@FindBy(name="company_name")
	private WebElement cmyname;

	@FindBy(name="company_p_name")
	private WebElement priorityname;

	@FindBy(name="employee")
	private WebElement total;
	
	@FindBy(name="category")
	private WebElement category;
	@FindBy(name="year_open")
	private WebElement year;
	@FindBy(name="legal")
	private WebElement legal;
	@FindBy(name="gst")
	private WebElement gst;
	@FindBy(name="pan")
	private WebElement pan;
	@FindBy(name="cin")
	private WebElement cin;
	@FindBy(name="annual")
	private WebElement annual;

	



	public LoginPage (){
		PageFactory.initElements(driver,this); 
		logger=Logger.getLogger(LoginPage.class);

	}

	public void vendorLogin() throws IOException {

		logger.info("Get Data In Excel");

		FileInputStream fis = new FileInputStream("D:\\prakash\\excelldata\\logindata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);


		for(int j=1;j<=2;j++) {


			String vendormail=sheet.getRow(j).getCell(1).getStringCellValue();
			String password=sheet.getRow(j).getCell(2).getStringCellValue();
			details.add(new LoginData(vendormail, password));


		}
		fis.close();

		for(int i=1;i<2;i++) {   //iterate 50 times

			logger.info("Click Account & Lists");
			List.click();  //click Accounts & List

			logger.info("Click Sign in Button");
			Sign.click();   //Click Sign In

			logger.info("Click Vendor Login");

			LoginVendor.click();  //Click vendor login

			logger.info("Write User Mail id");
//			VendorMail.clear();
			VendorMail.sendKeys(details.get(i-1).getvendormail());  //find & send user id

			logger.info("Write Password");
	//		Password.clear();
			Password.sendKeys(details.get(i-1).getpassword());   //find & send password

			logger.info("Click Login Button");
			submit.click();  //find & click login button
			
			company.click();
			shop.sendKeys("Trade viv");
			cmyname.sendKeys("company123");
			priorityname.sendKeys("company12");
			total.sendKeys("10");
			category.click();
			Select select=new Select(category);
			select.selectByVisibleText("Distributor");
			year.sendKeys("1991");
			legal.sendKeys("status");
			gst.sendKeys("4563128");
			pan.sendKeys("dine234");
			cin.sendKeys("1234567");
			annual.sendKeys("10000");
			
			
			
			
//			logger.info("Take Screenshot");
//			TakesScreenshot scrShot =((TakesScreenshot) driver);
//			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//			File DestFile=new File(".//Screenshot"+".//Screenshot.png");
//			FileHandler.copy(SrcFile, DestFile);
//
//			logger.info("Click Logout button");
//			File DestFile1=new File(".//Screenshot"+".//Screenshot1.png");
//			FileHandler.copy(SrcFile, DestFile1);

	



		}

	}



}
