package com.tradeviv.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectUtility {

	static WebElement getShadowDOM(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement shadowDOM1=(WebElement) js.executeScript("return arguments[0].shadowRoot", element);
		return shadowDOM1;
	}
}
