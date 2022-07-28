package com.sathya.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GetFeatures {
	
	@FindBy(xpath="//td[normalize-space()='Brand']//following::td[1]") private WebElement Brand;

}
