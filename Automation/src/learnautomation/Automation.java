package learnautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Automation {

	public static void main(String[] args) throws InterruptedException {

		String s="WELCOME TO SELENIUMEASY.COM";
		System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

		driver.manage().window().maximize();

		//time taken
		Thread.sleep(4000);

		//pop-up-window close
		driver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")).click();

		//Text box find & message pass
		driver.findElement(By.id("user-message")).sendKeys(s);

		// click show message
		driver.findElement(By.xpath("//*[@id=\"get-input\"]/button")).click();
		String w=driver.findElement(By.id("display")).getText();
		System.out.println(driver.findElement(By.id("display")).getText());
		//		if(s==w) {
		//			System.out.println("The typed message matched with displayed message");
		//			
		//		}
		//		else {
		//			System.out.println("The typed message not matched with displayed message");
		//		}


		// input a value
		driver.findElement(By.id("sum1")).sendKeys("10");

		//input b value
		driver.findElement(By.id("sum2")).sendKeys("20");

		//click get total
		driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
		System.out.println(driver.findElement(By.id("displayvalue")).getText());






	}

}
