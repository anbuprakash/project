package learnautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSelenium {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\browser\\ChromeDriver.exe");

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		
		driver.manage().window().maximize();
		
		//time taken
		Thread.sleep(4000);
		
		//pop-up-window close
		WebElement w=driver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]"));
		w.click();

		//Text box find & message pass
		WebElement web=driver.findElement(By.id("user-message"));
		web.sendKeys("WELCOME TO SELENIUMEASY.COM");
			
		// click show message
		WebElement button=driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
		button.click();
		System.out.println(driver.findElement(By.id("display")).getText());

		// input a value
		WebElement a=driver.findElement(By.id("sum1"));
		a.sendKeys("10");

		//input b value
		WebElement b=driver.findElement(By.id("sum2"));
		b.sendKeys("20");

		//click get total
		WebElement add=driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
		add.click();
		System.out.println(driver.findElement(By.id("displayvalue")).getText());
		
		
		
		
		
		



	}

}
