package learnautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumDemo{
	ChromeDriver driver=new ChromeDriver();
	

	//find text box,type & click show message button
	public void showmessage() {
		//find & msg throw
		String s="WELCOME TO SELENIUMEASY.COM";
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		WebElement w=driver.findElement(By.id("at-cv-lightbox-close"));
		w.click();
		
		WebElement web=driver.findElement(By.id("user-message"));
		web.sendKeys(s);

		// click show message
		WebElement button=driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
		button.click();
	
		
	}

	//find text box a,b give the value & click get total button 
	public void gettotal() {
		// input a value
				WebElement a=driver.findElement(By.id("sum1"));
				a.sendKeys("10");

				//input b value
				WebElement b=driver.findElement(By.id("sum2"));
				b.sendKeys("20");
				
				//click get total
				WebElement add=driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
				add.click();

	}
}

public class Seleniumex {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\browser\\ChromeDriver.exe");

		SeleniumDemo sel=new SeleniumDemo();
		sel.showmessage();
		sel.gettotal();

	}

}
