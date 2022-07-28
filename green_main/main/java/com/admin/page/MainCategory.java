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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainCategory extends AdminPage{

	ArrayList<Materials> details=new ArrayList<Materials>();

	String  maincategory,subcategory,childcategory,Slug,tags;

	@FindBy (xpath="//a[@href='#menu5']")
	private WebElement managecategory;
	@FindBy (xpath="//span[contains(text(),'Main Category')]")
	private WebElement Maincategory;
	@FindBy (id="add-data")
	private WebElement Adddata;
	@FindBy (name="name")
	private WebElement name;
	@FindBy (name="slug")
	private WebElement slug;
	@FindBy (id="image-upload")
	private WebElement uploadfile;
	@FindBy (xpath="//button[@class='addProductSubmit-btn']")
	private WebElement create;
	@FindBy (xpath="//div[@class='modal fade show']//div[@class='modal-header']//button[1]")
	private WebElement close;
	@FindBy (xpath="/html/body/div/div/div[2]/div[1]/div[2]/div/div/div/div")
	private WebElement close1;





	public MainCategory() {
		PageFactory.initElements(driver,this);
		logger=Logger.getLogger(MainCategory.class);
	}

	public void mainCategory() throws IOException {

		FileInputStream fis=new FileInputStream(".//TestData.xlsx//Categories (1).xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		for(int j=1;j<2;j++) {
			String maincategory=sheet.getRow(j).getCell(1).getStringCellValue();
			String Slug=sheet.getRow(j).getCell(2).getStringCellValue();
			details.add(new Materials(maincategory,subcategory, childcategory, Slug,tags));
		}
		workbook.close();
		fis.close();

		String current=driver.getCurrentUrl();

		for(int i=1;i<2;i++) {

			managecategory.click();


			Maincategory.click();

			Adddata.click();


			name.sendKeys(details.get(i-1).getmainCategory());
//			Cell cell1 = row.getCell(1);
//			String data1=cell1.getStringCellValue();
//			slug.sendKeys(data1);
			slug.sendKeys(details.get(i-1).getSlug());


			WebElement ele=uploadfile;
			ele.sendKeys("D:\\tradeviv images\\child.jpg");


			create.click();

			driver.get(current);

		}

	}
}
