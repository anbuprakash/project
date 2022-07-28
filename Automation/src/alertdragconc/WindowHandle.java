package alertdragconc;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//ChromeDriver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();

		String oldWindow=driver.getWindowHandle();
		driver.findElement(By.id("home")).click();
		Set<String> handle=driver.getWindowHandles();
		for (String string : handle) {
			//	if(string.equals(oldWindow)) {
			driver.switchTo().window(string);

			//	}

		}
		driver.findElement(By.xpath("//img[@alt='Edit / Text Fields']")).click();
		driver.close();
		driver.switchTo().window(oldWindow);
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
//		int total=driver.getWindowHandles().size();
//		System.out.println(total);
		Set<String> newWindow=driver.getWindowHandles();
		for (String string1 : newWindow) {
			if(!string1.equals(oldWindow)) {
				driver.switchTo().window(string1);
				driver.close();
			}
			
		}
		

	}

}
