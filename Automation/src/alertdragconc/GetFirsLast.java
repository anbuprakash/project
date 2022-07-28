package alertdragconc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetFirsLast {

	WebDriver driver;

	public void getnames() throws InterruptedException  {
		driver=new ChromeDriver();

		driver.get(" https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html"); //get url
		driver.manage().window().maximize(); //maximize window
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
		//find get user
		WebElement web=driver.findElement(By.id("save"));
	    
		//get first & last names
		WebElement getfnames =driver.findElement(By.id("loading"));
		
		//iterative 5 times
		for(int i=0;i<5;i++) {
			web.click();
			Thread.sleep(3000);
			String s=getfnames.getText();
		System.out.println(s +"\n");
		}
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");
		GetFirsLast names=new GetFirsLast(); //object creation
		names.getnames(); //call method



	}

}
