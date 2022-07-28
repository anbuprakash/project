package com.tradeviv.build;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryBox extends TradevivBase 
{

	@FindBy(xpath="//a[@href='#homepage']")
	WebElement home;

	@FindBy(xpath="//span[contains(text(),'Category Boxes')]")
	WebElement category;

	@FindBy(xpath="//table[@id='geniustable']//thead")
	WebElement head;

	@FindBy(xpath="//table[@id='geniustable']//tbody")
	WebElement body;

	@FindBy(id="add-data")
	WebElement add;

	@FindBy(name="title")
	WebElement name;

	@FindBy(id="catbax_cat")
	WebElement main;

	@FindBy(id="//select[@id='subcat']")
	WebElement subcate;

	@FindBy(id="//button[@type='submit']")
	WebElement create;

	@FindBy(id="//p[@class='text-left']")
	WebElement alert;

	WebDriverWait wait=new WebDriverWait(driver,30);

	public CategoryBox()
	{
		PageFactory.initElements(driver, this);
		logger=Logger.getLogger(CategoryBox.class);
	}
	public void homePage()
	{
		home.click();
	}
	public void homeDd()
	{
		for(int i=1;i<=11;i++)
		{
			String DD=driver.findElement(By.xpath("//ul[@id='homepage']//li["+i+"]")).getText();
			System.out.println(DD);
		}
	}
	public void category()
	{
		category.click();
	}
	public void head()
	{
		System.out.println("\n"+head.getText());
	}
	public void body()
	{
		String body=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='geniustable']//tbody"))).getText();
		System.out.println("\n"+body);
	}
	public void add()
	{
	WebElement web=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-data")));
		Actions action = new Actions(driver);
		action.moveToElement(web,3, 1).click().build().perform();
	}
	public void data() throws Exception
	{
		FileInputStream fis = new FileInputStream(".//TestData//catebox.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		for(int i=1;i<=2;i++)
		{
			add();
			String pname=sheet.getRow(i).getCell(1).getStringCellValue();
			name.sendKeys(pname);
			String mail=sheet.getRow(i).getCell(2).getStringCellValue();
			main.click();
			Select select=new Select(main);
			select.selectByVisibleText(mail);
			subCate();
			create();
			alert();
		}
		fis.close();
		workbook.close();
	}
	public void name()
	{
		name.sendKeys("Natuarel food");
	}
	public void main()
	{
		main.click();
		Select select=new Select(main);
		select.selectByIndex(4);
	}
	public void mainDd()
	{
		for(int i=1;i<=12;i++)
		{
			String dd=driver.findElement(By.xpath("//select[@id='catbax_cat']//option["+i+"]")).getText();
			System.out.println("\n"+dd);
		}
	}
	public void subCate()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='subcat']//option[1]"))).click();
	}
	public void create()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
	}
	public void alert()
	{
		String body=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-left']"))).getText();
		System.out.println(body);
	}
	public void cate_base() throws Exception
	{
		homePage();
		homeDd();
		category();
		head();
		body();
		data();

	}
}
