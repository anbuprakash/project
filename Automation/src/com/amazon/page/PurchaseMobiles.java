package com.amazon.page;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PurchaseMobiles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",".//ChromeDriver//chromedriver.exe");
		Search s=new Search();
		s.Mobile();
	}

}
class Search{
	WebDriver driver;
	
	public void Mobile() {
		driver=new ChromeDriver();
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung"+Keys.ENTER);
		driver.findElement(By.xpath("//li[@id='p_89/Samsung']")).click();
		
	String main=driver.getWindowHandle();
		driver.findElement(By.xpath("//span[contains(text(),"
				+ "'OnePlus 9 Pro 5G (Stellar Black, 8GB RAM, 128GB Storage')]")).click();
		
	Set<String> new1=driver.getWindowHandles();
	for (String string : new1) {
		driver.switchTo().window(string);
		
	}
	int total=driver.getWindowHandles().size();
	System.out.println(total);
	driver.close();
	}
}
