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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CompanyDetails extends LoginBase{

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
	@FindBy (xpath="//a[@class='wave-effect  waves-effect waves-button']")
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
	@FindBy(name="cemail")
	private WebElement companyemail;
	@FindBy(name="cmobile")
	private WebElement companymobile;
	@FindBy(name="clandline")
	private WebElement companylandline;
	@FindBy(xpath = "//*[@id=\"geniusfor\"]/div[15]/div[2]/div[2]/div")
	private WebElement address;
	@FindBy(id="file_cc")
	private WebElement companycertification;
	@FindBy(id="file_pc")
	private WebElement productcertification;
	@FindBy(id="file_cv")
	private WebElement companyvideos;
	@FindBy(id="file_cp")
	private WebElement companyphotos;
	@FindBy(id="image-upload")
	private WebElement imageupload;
	@FindBy(xpath = "//button[@class='addProductSubmit-btn']")
	private WebElement submit1;
	
	

	
	public CompanyDetails (){ 
		PageFactory.initElements(driver,this);
		logger=Logger.getLogger(CompanyDetails.class);

	}

	public void vendorLogin() throws IOException {

		logger.info("Get Data In Excel");

		

//		for(int i=1;i<2;i++) {   //iterate 50 times

			logger.info("Click Account & Lists");
			List.click();  //click Accounts & List

			logger.info("Click Sign in Button");
			Sign.click();   //Click Sign In

			logger.info("Click Vendor Login");

			LoginVendor.click();  //Click vendor login

			logger.info("Write User Mail id");

			VendorMail.sendKeys("mprakashmani33@gmail.com");  //find & send user id

			logger.info("Write Password");
			Password.sendKeys("BjCjNV");   //find & send password

			logger.info("Click Login Button");
			submit.click();  //find & click login button
			company.click();
			shop.clear();
			shop.sendKeys("Trade viv");
			cmyname.clear();
			cmyname.sendKeys("company123");
			priorityname.clear();
			priorityname.sendKeys("company12");
			total.clear();
			total.sendKeys("10");
			category.click();
			Select select=new Select(category);
			select.selectByVisibleText("Distributor");
			year.clear();
			year.sendKeys("1991");
			legal.clear();
			legal.sendKeys("status");
			gst.clear();
			gst.sendKeys("4563128");
			pan.clear();
			pan.sendKeys("dine234");
			cin.clear();
			cin.sendKeys("1234567");
			annual.clear();
			annual.sendKeys("10000");
			companyemail.clear();
			companyemail.sendKeys("vendor134@gmail.com");
			companymobile.clear();
			companymobile.sendKeys("8743257964");
			companylandline.clear();
			companylandline.sendKeys("245673");
			address.clear();
			address.sendKeys("thiruvanmiyur");
			
			
		WebElement ele=	companycertification;
		ele.sendKeys(".//flie//companycertification.docx");

		WebElement elem=productcertification;
		elem.sendKeys(".//flie//companycertification.docx");
		
		WebElement eleme=companyvideos;
		eleme.sendKeys(".//flie//company videos.mp4");
		
		WebElement elemen=companyphotos;
		elemen.sendKeys(".//flie//photo (1).jpg");

		WebElement element=imageupload;
		 element.sendKeys(".//flie//logo.png");
		 submit1.click();
		 
		
	//	}

	}



}

