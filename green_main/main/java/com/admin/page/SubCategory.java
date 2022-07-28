package com.admin.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubCategory extends AdminBase {

	ArrayList<Materials> details=new ArrayList<Materials>();

	String  maincategory,subcategory,childcategory,Slug,tags;


	@FindBy (xpath="//a[@href='#menu5']")
	private WebElement managecategory;
	@FindBy (xpath="//span[contains(text(),'Sub Category')]")
	private WebElement subCategory;
	@FindBy (id="add-data")
	private WebElement addCategory;
	@FindBy (name="category_id")
	private WebElement main;
	@FindBy (name="name")
	private WebElement Sub_name;
	@FindBy (name="slug")
	private WebElement sub_slug;
	@FindBy (id="image-upload")
	private WebElement sub_uploadFile;
	@FindBy (xpath="//button[@class='addProductSubmit-btn']")
	private WebElement sub_create;
	@FindBy (xpath="//*[@id=\"modal1\"]/div/div/div[4]/button")
	private WebElement sub_close;


	public SubCategory() {
		PageFactory.initElements(driver, this);
	}
	public void subCategory() throws IOException {

		FileInputStream fis=new FileInputStream(".//TestData.xlsx//Categories (2).xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);

//		for(int j=1;j<139;j++) {
//
//			String subcategory=sheet.getRow(j).getCell(1).getStringCellValue();
//			String Slug=sheet.getRow(j).getCell(2).getStringCellValue();
//			details.add(new Materials(maincategory,subcategory, childcategory, Slug,tags));
//
//		}
//		fis.close();
//		workbook.close();

		String current=driver.getCurrentUrl();

		for(int i=5;i<139;i++) {
			Row row = sheet.getRow(i);

			managecategory.click();


			subCategory.click();


			addCategory.click();


			main.click();
			Select select=new Select(main);
			select.selectByVisibleText("Construction");

			Cell cell = row.getCell(1);
			String data=cell.getStringCellValue();
			Sub_name.sendKeys(data);
//			Sub_name.sendKeys(details.get(i-1).getsubCategory());
		

			Cell cell1 = row.getCell(2);
			String data1=cell1.getStringCellValue();
			sub_slug.sendKeys(data1);
//			sub_slug.sendKeys(details.get(i-1).getSlug());


			WebElement ele=	sub_uploadFile;
			ele.sendKeys("D:\\tradeviv images\\sub1.jpg");


			sub_create.click();
			


			driver.get(current);


		}
	}


}
