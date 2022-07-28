package com.tradeviv.build;
import java.awt.List;
//Author : PRAKASH M
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tradeviv_UserStory_07 extends TradevivBase
{
	@FindBy(xpath="//a[@href='#vendor']") //page factory
	private WebElement vendor;

	@FindBy(xpath="//span[contains(text(),'Approve VENDOR')]") 
	WebElement a_vendor;

	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	WebElement searchBox;

	@FindBy(xpath="//ul[@id='vendor']//li")
	WebElement dropDown;

	@FindBy(xpath="//table[@id='geniustable']//thead")
	WebElement v_list;

	@FindBy(xpath="//table[@id='geniustable']//tbody")
	WebElement body1;

	@FindBy(xpath="//table[@id='geniustable']//button")
	WebElement underReview;

	@FindBy(xpath="//a[@href='https://www.tradeviv.com/admin/vendors/289/show']")
	WebElement details;

	@FindBy(xpath="//a[@href='https://www.tradeviv.com/admin/vendor/edit/289']")
	WebElement edit;

	@FindBy(xpath="//table[@id='geniustable']//a[3]")
	WebElement companyEdit;

	@FindBy(xpath="//a[@data-href='https://www.tradeviv.com/admin/vendors/delete/289']")
	WebElement delete;

	@FindBy(name="vendor_status")
	WebElement status;

	@FindBy(xpath="//option[@value='5']")
	WebElement approve;

	@FindBy(xpath="//option[@value='4']")
	WebElement reject;

	@FindBy(xpath="//button[@class='addProductSubmit-btn']")
	WebElement submit;
	@FindBy(name="clandline")WebElement landLineNo;
	@FindBy(xpath="//pre[@style='word-wrap: break-word; white-space: pre-wrap;']")
	WebElement app;

	public Tradeviv_UserStory_07() 
	{
		PageFactory.initElements(driver, this);
		logger=Logger.getLogger(Tradeviv_UserStory_07.class);
	}
	public void vendor()  //click vendors
	{
		logger.info("Click vendors");
		vendor.click();
	}
	public void dropDown() throws Exception //vendor dropDown options
	{
		for(int i=1;i<=6;i++)
		{
			String dD_Option=driver.findElement(By.xpath("//ul[@id='vendor']//li["+i+"]")).getText();
			System.out.println(dD_Option);
		}
	}
	public void approveVendor()  //click approve vendor
	{
		logger.info("Click approve vendor");
		a_vendor.click();
	}
	public void approveV_List()   //vendor header label
	{
		System.out.println(v_list.getText());
		//		for(int i=1;i<=5;i++)
		//		{
		//			String head=driver.findElement(By.xpath("//table[@id='geniustable']//tr//th["+i+"]")).getText();
		//			System.out.println(head);

		//		}
	}
	public void body() throws Exception  //vendor list write excell
	{

		Collection<WebElement> rows = driver.findElements(By.xpath("//table[@id='geniustable']//tbody//tr"));
		int count = rows.size();
		WebDriverWait wait=new WebDriverWait(driver,30);
		String body=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='geniustable']//tbody"))).getText();
		System.out.println(body);
		
		File file=new File(".//TestData//approve vendor.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		for(int i=1;i<=count;i++) 
		{
			for(int j=1;j<=4;j++)
			{
				String s=driver.findElement(By.xpath("//table[@id='geniustable']//tr["+i+"]//td["+j+"]")).getText();
				sheet.getRow(i).createCell(j).setCellValue(s);
			}
		}
		fis.close();
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
		wb.close();

	}
	public void search() throws Exception  //search vendor mail
	{
		logger.info("Search company Email");
		FileInputStream fis = new FileInputStream(".//TestData//approve vendor.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		for(int i=1;i<2;i++)
		{
			String mail=sheet.getRow(i).getCell(2).getStringCellValue();
			searchBox.sendKeys(mail);
		}
		fis.close();
		workbook.close();
	}
	public void underReview()  //click underReview
	{
		logger.info("Click underReview");
		underReview.click();
	}
	public void uR_Options()  //underReview options
	{
		for(int i=1;i<=4;i++)
		{
			String u_Review=driver.findElement(By.xpath("//div[@style='display: block;']//a["+i+"]")).getText();
			System.out.println(u_Review);
		}
	}
	public void companyEdit()  //click Company Edit
	{
		logger.info("Click CompanyEdit");
		companyEdit.click();
	}
	public void companyEditDetails()  //company details
	{
		for(int i=1;i<=21;i++)
		{
			String c_Edit=driver.findElement(By.xpath("//form[@id='geniusfor']//div["+i+"]//div[1]//div//h4")).getText();
			System.out.println(c_Edit);
		}
	}
	public void status()  //click status
	{
		logger.info("Click status");
		status.click();
	}
	public void approve()  //select approve
	{
		logger.info("Select approved");
		approve.click();
	}
	public void reject()  //select reject
	{
		logger.info("select reject");
		reject.click();
	}
	public void submit()   //click submit button
	{
		logger.info("Click Submit button");
		submit.click();
	}
	public void app()
	{
		System.out.println(app.getText());
	}
	public void approve_Vendor() throws Exception  //vendor approve function
	{
		vendor();
		dropDown();
		approveVendor();
		approveV_List();
		body();
		search();
		underReview();
		uR_Options();
		companyEdit();
		companyEditDetails();
		approve();
		submit();
	}
	public void reject_vendor() throws Exception  //vendor reject function
	{
		vendor();
		dropDown();
		approveVendor();
		approveV_List();
		body();
		search();
		underReview();
		uR_Options();
		companyEdit();
		companyEditDetails();
		reject();
		submit();
	}
	public void landLineNo()
	{
		boolean ele=landLineNo.isDisplayed();
		if(ele==true)
		{
			status();
			approve();
			submit();
			app();
			driver.navigate().back();
		}
		else 
		{
			status();
			reject();
			submit();
		}
	}


}
