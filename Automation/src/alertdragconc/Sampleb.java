package alertdragconc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sampleb {
	

WebDriver driver;

public void getnames() throws InterruptedException  {
	driver=new ChromeDriver();

	driver.get(" https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //dynamic wait
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	WebElement web=driver.findElement(By.id("save"));

	WebElement getfnames =driver.findElement(By.id("loading"));
	
	
//	System.out.println("1st : \n "+s+"\n");
	
	for(int i=0;i<5;i++) {
		web.click();
		Thread.sleep(2000);
		String s=getfnames.getText();
	System.out.println(s);
	}

	
	
	
	
	/*
	 * driver.findElement(By.id("save")).click(); Thread.sleep(4000); String
	 * getnames=driver.findElement(By.id("loading")).getText();
	 * System.out.println("2nd: \n "+getnames+"\n");
	 * 
	 * driver.findElement(By.id("save")).click(); Thread.sleep(4000); String
	 * getname=driver.findElement(By.id("loading")).getText();
	 * System.out.println("3rd :\n"+getname+"\n");
	 * 
	 * driver.findElement(By.id("save")).click(); Thread.sleep(4000); String
	 * get=driver.findElement(By.id("loading")).getText();
	 * System.out.println("4th :\n"+get+"\n");
	 * 
	 * 
	 * driver.findElement(By.id("save")).click(); Thread.sleep(4000); String
	 * get5=driver.findElement(By.id("loading")).getText();
	 * System.out.println("5th :\n"+get5+"\n");
	 */

}

public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");
	GetFirsLast names=new GetFirsLast();
	names.getnames();



}


	
	

}
