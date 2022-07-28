package learnautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTutorial {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
	   WebElement web= driver.findElement(By.id("user-message"));
	   web.sendKeys("how are you");


	}

}
