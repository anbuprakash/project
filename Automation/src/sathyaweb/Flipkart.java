package sathyaweb;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Flipkart {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\browser\\ChromeDriver.exe");
		SearchFlipkart sf=new SearchFlipkart();
		sf.searchlaptop();

	}

}
class SearchFlipkart {
	WebDriver d;
	public void searchlaptop() throws Exception {
		d=new ChromeDriver();
		d.get("https://www.flipkart.com");
	//	WebDriverWait wait=new WebDriverWait(d, 20);
		//	    	  d.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		//	    	  d.findElement(By.name("q")).sendKeys("laptop");
		//	    	  d.findElement(By.className("L0Z3Pu")).click();
		//	    	  d.findElement(By.xpath("//div[@title='Core i5']//child::div//div[1]")).click();
		d.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//	WebElement web=d.findElement(By.xpath("//img[@src='https://rukminim1.flixcart.com/flap/50/50/image/f63e5a10399becf5.jpg?q=50']"));
		//	WebElement web=d.findElement(By.xpath("//img[@src='https://rukminim1.flixcart.com/flap/844/140/image/2f091f046f2c3d61.jpg?q=50']"));
		//	WebElement web=d.findElement(By.xpath("//img[@src='https://rukminim1.flixcart.com/flap/50/50/image/f571000b9409f048.jpg?q=50']"));
		
		WebElement web=	d.findElement(By.xpath("//img[@src='https://rukminim1.flixcart.com/flap/50/50/image/f63e5a10399becf5.jpg?q=50']"));
	//	WebElement web=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://rukminim1.flixcart.com/flap/50/50/image/f63e5a10399becf5.jpg?q=50']")));
		Actions action = new Actions(d);
		action.moveToElement(web,3, 1).click().build().perform();
	}
}
