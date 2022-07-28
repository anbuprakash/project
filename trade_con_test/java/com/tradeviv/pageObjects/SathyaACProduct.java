package com.tradeviv.pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tradeviv.testCases.BaseClass;

public class SathyaACProduct {
	
	WebDriver ldriver;
	BaseClass bc=new BaseClass();
		
		public SathyaACProduct(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="((//div[contains(@id,'artlist-')])[1]//article//h3)")
		@CacheLookup
		List<WebElement> airCond;
		
		@FindBy(xpath="(//a[contains(@href,'/air-conditioner-2')])[3]")
		@CacheLookup
		WebElement ac;
		
		public void acClick()
		{
			ac.click();
		}
		
		public void clickProduct()
		{
			for(WebElement t:airCond)
			{	
				t.click();
				System.out.println("ABC:"+t);
			}
//			WebDriver driver;
//			int count=driver.findElements(airCond);
			System.out.println("SIZE IS:"+airCond.size());
		}


}
