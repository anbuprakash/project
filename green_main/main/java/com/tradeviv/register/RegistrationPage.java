package com.tradeviv.register;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegistrationPage extends RegistrationBase {

	ArrayList<RegistrationData> details=new ArrayList<RegistrationData>();
	String vendorName,companyName,CompanyEmail,phoneNumbers;



	//pagefactory

	@FindBy(xpath="//span[contains(text(),'Accounts & Lists')]") 
	private WebElement List;
	@FindBy(className="sign-in-btn") 
	private WebElement Sign;
	@FindBy(id="nav-reg-tab11") 
	private WebElement RegisterVendor;
	@FindBy(xpath="//input[@name='name'and@placeholder='Vendor Name']") 
	private WebElement VendorName;
	@FindBy(xpath="//input[@name='email'and@placeholder='Company E-mail']") 
	private WebElement Email;
	@FindBy(xpath="//input[@name='phone'and@placeholder='Vendor Phone number']") 
	private WebElement PhoneNumber;
	@FindBy(xpath="//input[@name='shop_name'and@placeholder='Company Name']") 
	private WebElement Company;
	@FindBy(xpath="//div[@id='nav-reg11']//button[@type='submit']") 
	private WebElement Register;
	@FindBy(xpath="//div[@id='vendor-login']//button[@class='close']") 
	private WebElement Close;

	public RegistrationPage() {
		PageFactory.initElements(driver,this);
		logger=Logger.getLogger(RegistrationPage.class);  //initiate 

	}

	public void vendorRegister() throws IOException {

		logger.info(" Get Data From Excel File");

		//read data from excel file
		FileInputStream fis = new FileInputStream("D:\\prakash\\excelldata\\Vendordetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for(int j=23;j<=50;j++) {

			String vendorName=sheet.getRow(j).getCell(1).getStringCellValue();
			String companyName=sheet.getRow(j).getCell(2).getStringCellValue();
			String companyEmail=sheet.getRow(j).getCell(4).getStringCellValue();
			String phoneNumbers=sheet.getRow(j).getCell(3).getStringCellValue();
			details.add(new RegistrationData(vendorName, companyName, companyEmail, phoneNumbers));

		}
		fis.close(); //file close

		for(int i=23;i<50;i++) {  //iterate 50 times


            logger.info("Click Account & List");
			List.click();  //Accounts & list click

			logger.info("Click Sign in");
			Sign.click();  //Click sign in

			logger.info("Click Vendor Registration");
			RegisterVendor.click();   //click vendorRegistration

			logger.info("Write Vendor Name");
			VendorName.clear();
			VendorName.sendKeys(details.get(i-1).getvendorName());   //find & send vendor name

			logger.info("Write Email id");
			Email.clear();
			Email.sendKeys(details.get(i-1).getCompanyEmail());  //find & send mail id

			logger.info("Write Phone Number");
			PhoneNumber.clear();
			PhoneNumber.sendKeys(details.get(i-1).getphoneNumber());  //find & send phone number

			logger.info("write Company Name");
			Company.clear();
			Company.sendKeys(details.get(i-1).getcompanyName());  //find & send company name



			logger.info("Click Register button");

			Register.click(); //find & click register



			WebElement web=Close;   //find & close * button
			Actions action = new Actions(driver);
			action.moveToElement(web,3, 1).click().build().perform();




		}

	}

}
