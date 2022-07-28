package com.admin.page;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChildCate extends AdminBase {
	
	ArrayList<Materials> details=new ArrayList<Materials>();

	String  maincategory,subcategory,childcategory,Slug,tags;


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


	public ChildCate() {

		PageFactory.initElements(driver, this);
		logger=Logger.getLogger(ChildCate.class);
	}
	public void addChildCategory() throws IOException {
		
		logger.info("Get data from excel");
		
		FileInputStream fis = new FileInputStream(".//TestData.xlsx//Categories.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
//		for(int j=22;j<=34;j++) {
//
//			String childcategory=sheet.getRow(j).getCell(4).getStringCellValue();
//			String Slug=sheet.getRow(j).getCell(5).getStringCellValue();
//	//		String tags=sheet.getRow(j).getCell(6).getStringCellValue();
//			details.add(new Materials(maincategory,subcategory, childcategory, Slug,tags));
//
//		}
//		fis.close();
//		workbook.close();


		String current=driver.getCurrentUrl();

		for(int i=22;i<=34;i++) {
			Row row = sheet.getRow(i);
			
			logger.info("Click ManageCategory");
			managecategory.click();
			
			logger.info("Click childCategory");
			childCategory.click();

            logger.info("Click add category");
			Addproduct.click();
            
			mainCategory.click();
			Select select=new Select(mainCategory);
			select.selectByVisibleText("Construction");
			
			if(i<=1 && i<=11) {

			subCategory.click();
			Select select1=new Select(subCategory);
			select1.selectByVisibleText("Concrete Mixers");
			}
			else if(i>=12 && i<=22) {
				subCategory.click();
				Select select1=new Select(subCategory);
				select1.selectByVisibleText("Concrete Mixers");
				
			}
			else if(i>=23 && i<=33) {
				subCategory.click();
				Select select1=new Select(subCategory);
				select1.selectByVisibleText("Bending Machine");
				
			}
			else if(i>=34 && i<=38) {
				subCategory.click();
				Select select1=new Select(subCategory);
				select1.selectByVisibleText("Block making machine");
				
			}
			
			else if(i>=39 && i<=43) {
				subCategory.click();
				Select select1=new Select(subCategory);
				select1.selectByVisibleText("Vibratory compactors");
				
			}

			Cell cell = row.getCell(4);
			String data=cell.getStringCellValue();
			name.sendKeys(data);
//			name.sendKeys(details.get(i-1).getchildCategory());

			Cell cell1 = row.getCell(5);
			String data1=cell1.getStringCellValue();
			slug.sendKeys(data1);
	//		slug.sendKeys(details.get(i-1).getSlug());
            
			logger.info("File uploaded sucessfully");
			WebElement ele=uploadfile;
			ele.sendKeys("D:\\tradeviv images\\download1.jpg");

			tag.sendKeys("mixer");


            logger.info("Click create button");
			create.click();



			driver.get(current);
		}



}
}
