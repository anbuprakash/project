package com.tradeviv.build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

//Author : PRAKASH M
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditVendor extends TradevivBase{
	@FindBy(xpath="//a[@href='#vendor']")
	WebElement vendor;

	@FindBy(xpath="//span[contains(text(),'Manage VENDOR')]")
	WebElement manageVendor;
	@FindBy(xpath="//table[@id='geniustable']//tbody")
	WebElement manageVendor_Body;

	@FindBy(name="geniustable_length")
	WebElement show;

	@FindBy(id="geniustable_next")
	WebElement next;

	@FindBy(id="geniustable_previous")
	WebElement previous;

	@FindBy(xpath="//input[@type='search']")
	WebElement search;

	@FindBy(xpath="//button[@class='go-dropdown-toggle']")
	WebElement action;
	
	@FindBy(xpath="//div[@style='display: block;']")
	WebElement actionList;

	@FindBy(xpath="//table[@id='geniustable']//thead")
	WebElement thead;

	@FindBy(xpath="//table[@id='geniustable']//a[2]")
	WebElement edit;
	
	@FindBy(xpath="//form[@id='geniusform']//h4")
	WebElement editOption;
	
	@FindBy(xpath="//table[@id='geniustable']//a[3]")
	WebElement companyEdit;

	@FindBy(xpath="//a[@class='delete']")
	WebElement delete;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(name="shop_name")
	WebElement shopName;
	
	@FindBy(xpath="//button[@class='addProductSubmit-btn']")
	WebElement editSubmit;
	
	@FindBy(xpath="//div[@class='alert alert-success validation']")
	WebElement update;
	
	@FindBy(name="vendor_status")
	WebElement status;
	
	@FindBy(xpath="//option[@value='5']")
	WebElement approve;
	
	@FindBy(xpath="//option[@value='4']")
	WebElement reject;

	@FindBy(xpath="//p[@class='text-left']")
	WebElement alert;
	
	@FindBy(xpath="//a[@class='add-btn']")
	WebElement back;

	WebDriverWait wait=new WebDriverWait(driver,10);
	String myData[] [];
	public EditVendor() 
	{
		PageFactory.initElements(driver, this);
		logger=Logger.getLogger(EditVendor.class);
	}

	public void vendors() //click vendors
	{
		logger.info("Click vendors");
		vendor.click();
	}
	public void dropDown() throws Exception //vendors dropDown options
	{
		for(int i=1;i<=6;i++)
		{
			String dD_Option=driver.findElement(By.xpath("//ul[@id='vendor']//li["+i+"]")).getText();
			System.out.println(dD_Option);
		}
	}

	public void manageVendor()  //click manage vendor
	{
		logger.info("Click manage vendor");
		manageVendor.click();
	}
	public void show()  //change 100 rows in vendors list
	{
		WebElement web=show;
		web.click();
		Select select=new Select(web);
		select.selectByVisibleText("100");
	}
	public void head()   //get vendor header label
	{
		System.out.println(thead.getText());
	}
	public void m_Body() throws Exception //vendors list write excell
	{
		String v=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='geniustable']//tbody"))).getText();
		System.out.println(v);
		Excell e=new Excell();
		e.m_Body();
		Collection<WebElement> rows = driver.findElements(By.xpath("//table[@id='geniustable']//tbody//tr"));
		int count = rows.size();
		File file=new File(".//TestData//approve vendor.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(2);

		for(int i=1;i<=count;i++)
		{
			for(int j=1;j<=4;j++)
			{
				String data=driver.findElement(By.xpath("//table[@id='geniustable']//tr["+i+"]//td["+j+"]")).getText();
				sheet.getRow(i).createCell(j).setCellValue(data);	
			}
		}
		fis.close();
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
		wb.close();
	}
	public void next() throws Exception  //click next button
	{
		logger.info("Click next button");
		next.click();
		m_Body();
	}
	public void previous()  //click previous button
	{
		logger.info("click previous button");
		previous.click();
	}

	
	public void search() throws Exception  //find & search vendor mail
	{
		
		
		
		logger.info("Search company Email");
		FileInputStream fis = new FileInputStream(".//TestData//approve vendor.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		for(int i=3;i<4;i++)
		{
			String mail=sheet.getRow(i).getCell(2).getStringCellValue();
			search.sendKeys(mail);
		}
		fis.close();
		workbook.close();
	}
	public void action() throws Exception  //click action
	{
		Thread.sleep(3000);
		logger.info("Click action button");
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='go-dropdown-toggle']"))).click();
		action.click();
	}
	public void actionList()
	{
		System.out.println(actionList.getText());
	}
	public void edit()  //click edit
	{
		edit.click();
	}
	public void editOption()
	{
		System.out.println(editOption.getText());
	}
	public void shopName()  //update shop name
	{
		shopName.clear();
		shopName.sendKeys("trade&co");
	}
	public void submit() //click submit button
	{
		submit.click();
	}
	public void update()  //update alert message
	{
	String s=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-left']"))).getText();
	System.out.println(s);
	}
	public void back()
	{
		back.click();
	}
	public void editVendor() throws Exception  //vendor edit function
	{
		
		vendors();
		dropDown();
		manageVendor();
	 	show();
		head();
		m_Body();
//		next();
//		previous();
		for(int i=1;i<=5;i++)
		{
		FileInputStream fis = new FileInputStream(".//TestData//approve vendor.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		String mail=sheet.getRow(i).getCell(2).getStringCellValue();
		search.sendKeys(mail);
		fis.close();
		workbook.close();
	//	search();
		action();
		actionList();
		edit();
		editOption();
		shopName();
		submit();
		update();
		back();
		}
		
	}
}
