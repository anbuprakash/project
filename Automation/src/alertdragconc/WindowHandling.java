package alertdragconc;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//ChromeDriver//chromedriver.exe");
		Windows w=new Windows();
		w.windowHandling();


	}

}

class Windows{
	WebDriver driver;

	public void windowHandling() {
		driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();

		String oldWindow=driver.getWindowHandle();
		driver.findElement(By.id("home")).click();
		
	Set<String> handles=	driver.getWindowHandles();
	for (String string : handles) {
		driver.switchTo().window(string);
		
	}


		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a/img")).click();
		driver.close();
		
		driver.switchTo().window(oldWindow);
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button")).click();
		
	int totalNumberOfWindows=driver.getWindowHandles().size();
	System.out.println(totalNumberOfWindows);
	
	driver.findElement(By.id("color")).click();
	
	Set<String> newWindowHandles= driver.getWindowHandles();
	for (String string1 : newWindowHandles) {
	
		if(!string1.equals(oldWindow)) {
			driver.switchTo().window(string1);
			driver.close();
			break;
			
		}
		
	}
	}


}
