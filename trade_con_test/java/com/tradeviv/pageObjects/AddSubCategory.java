
package com.tradeviv.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tradeviv.testCases.BaseClass;

public class AddSubCategory {

WebDriver ldriver;
BaseClass bc=new BaseClass();
	
	public AddSubCategory(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href=\"#menu5\"]")
	@CacheLookup
	WebElement manageCategory;
	
	@FindBy(xpath="//a[contains(@href,'subcategory')]")
	@CacheLookup
	WebElement subcategory;
	
	@FindBy(xpath="//a[contains(@data-href,'subcategory/create')]")
	@CacheLookup
	WebElement create_subcategory;
	
	@FindBy(name="category_id")
	@CacheLookup
	WebElement select_maincategory;
	
	@FindBy(xpath="//*[@id=\"geniusformdata_subcategory\"]/div[2]/div[2]/input")
	@CacheLookup
	WebElement subName;
	
	@FindBy(xpath="//*[@id=\"geniusformdata_subcategory\"]/div[3]/div[2]/input")
	@CacheLookup
	WebElement subslug;
	
	@FindBy(xpath="//input[@type=\"file\"]")
	@CacheLookup
	WebElement subimage;
	
	@FindBy(xpath="//*[@id=\"geniusformdata_subcategory\"]/div[5]/div[2]/button")
	@CacheLookup
	WebElement createSubcategory;
	
	public void manageCategoryClick()
	{
		manageCategory.click();
	}
	
	public void subCategoryClick()
	{
		subcategory.click();
	}
	
	public void createSubCategory()
	{
		bc.explicitWait(create_subcategory, ldriver);
		create_subcategory.click();
	}
	
	public void mainCategoryDropDown(String value)
	{
		bc.explicitWait(select_maincategory, ldriver);
		Select drop=new Select(select_maincategory);
//		drop.selectByIndex(maincategory);
		drop.selectByVisibleText(value);
		
	}
	
	public void subCategoryField(String subname)
	{
		subName.sendKeys(String.valueOf(subname));
	}
	
	public void subSlugField(String slug)
	{
		subslug.sendKeys(slug);
	}
	
	public void subImageUpload(String path)
	{
		subimage.sendKeys(path);
	}
	
	public void submitSubCategory()
	{
		createSubcategory.click();
	}
}
