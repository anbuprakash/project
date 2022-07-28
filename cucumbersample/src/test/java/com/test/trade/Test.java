package com.test.trade;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pages.trade.TradePages;

public class Test 
{
	WebDriver driver = null;
	TradePages teade;
  public void tst() {
	  TradePages trade = new TradePages();
	  
	PageFactory.initElements(driver,TradePages.class);
	
	  
  }
  
}
