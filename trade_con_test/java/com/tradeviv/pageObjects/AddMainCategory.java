package com.tradeviv.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tradeviv.testCases.BaseClass;

public class AddMainCategory {

WebDriver ldriver;
BaseClass bc=new BaseClass();
WebDriver driver;
	
	public AddMainCategory(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href=\"#menu5\"]")
	@CacheLookup
	WebElement manageCategory;
	
	@FindBy(xpath="(//a[contains(@href,'category')])[1]")
	@CacheLookup
	WebElement maincategory;
	
	@FindBy(xpath="//a[contains(@data-href,'create')]")
	@CacheLookup
	WebElement create_maincategory;
	
	@FindBy(xpath="//*[@id=\"geniusformdata_category\"]/div[1]/div[2]/input")
	@CacheLookup
	WebElement maincategoryfield;
	
	@FindBy(xpath="//*[@id=\"geniusformdata_category\"]/div[2]/div[2]/input")
	@CacheLookup
	WebElement slugfield;
	
	@FindBy(xpath="(//input[contains(@type,'file')])[1]")
	@CacheLookup
	WebElement main_img;
	
	@FindBy(xpath="//button[contains(@class,'addProductSubmit')]")
	@CacheLookup
	WebElement create_main;
	
	public void manageCategoryClick()
	{
		manageCategory.click();
	}
	
	public void mainCategoryClick()
	{
		maincategory.click();
	}
	
	public void createMainCategory()
	{
		create_maincategory.click();
	}
	
	public void mainCategoryField(String mainname)
	{
		maincategoryfield.sendKeys(mainname);
	}
	
	public void slugField(String slug)
	{
		slugfield.sendKeys(slug);
	}
	
	public void mainImgUpload(String path)
	{
		main_img.sendKeys(path);
	}
	
	public void submitMainCategory()
	{
		create_main.click();
	}

}
