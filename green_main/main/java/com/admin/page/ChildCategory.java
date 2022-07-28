package com.admin.page;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChildCategory extends AdminBase {
	@FindBy (xpath="//a[@href='#menu5']")
	private WebElement managecategory;
	@FindBy (xpath="//span[contains(text(),'Child Category')]")
	private WebElement childCategory;
	@FindBy (id="add-data")
	private WebElement Addproduct;
	@FindBy (id="cat")
	private WebElement mainCategory;
	@FindBy (id="subcat")
	private WebElement subCategory;
	@FindBy (name="name")
	private WebElement name;
	@FindBy (name="slug")
	private WebElement slug;
	@FindBy (id="image-upload")
	private WebElement uploadfile;
	@FindBy (xpath="//input[@class='ui-widget-content ui-autocomplete-input']")
	private WebElement tag;
	@FindBy (xpath="//button[contains(text(),'Create')]")
	private WebElement create;
	@FindBy (xpath="//*[@id=\"modal1\"]/div/div/div[4]/button")
	private WebElement close;
	
	public ChildCategory() {
		
		PageFactory.initElements(driver, this);
	}
public void addChildCategory() throws IOException {
		
		logger.info("Get data from excel");
		
		FileInputStream fis = new FileInputStream(".//TestData.xlsx//Categories.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		String current=driver.getCurrentUrl();
		
		logger.info("Click ManageCategory");
		managecategory.click();
		
		logger.info("Click childCategory");
		childCategory.click();

		for(int i=2;i<=12;i++) {
			Row row = sheet.getRow(i);
			
			

            logger.info("Click add category");
			Addproduct.click();
            
			mainCategory.click();
			Select select=new Select(mainCategory);
			select.selectByVisibleText("Building and construction machines");
for(int j=1;j<=12;j++)
{			subCategory.click();
			Select select1=new Select(subCategory);
			select1.selectByVisibleText("Concrete Mixers");

			Cell cell = row.getCell(4);
			String data=cell.getStringCellValue();
			name.sendKeys(data);

			Cell cell1 = row.getCell(5);
			String data1=cell1.getStringCellValue();
			slug.sendKeys(data1);
            
			logger.info("File uploaded sucessfully");
			WebElement ele=uploadfile;
			ele.sendKeys("D:\\tradeviv images\\download1.jpg");

			tag.sendKeys("mixer");


            logger.info("Click create button");
			create.click();



			driver.get(current);}
		}
}


		
	

}

