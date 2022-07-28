package alertdragconc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	WebDriver driver;

	public void getframe(){
		driver=new ChromeDriver();

		driver.get(" http://www.leafground.com/pages/frame.html");
		driver.manage().window().maximize();

		WebElement iframe=driver.findElement(By.xpath("//*[@id=\"wrapframe\"]/iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().parentFrame();

		WebElement ifra1=driver.findElement(By.id("frame2"));
		driver.switchTo().frame(ifra1);
		driver.findElement(By.id("Click1")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame(0);

		//		driver.findElement(By.xpath("//html//body"))
		System.out.println(driver.findElement(By.xpath("//html//body")).getTagName());







		driver.findElement(By.id("Click1")).click();
		List<WebElement> framelist=driver.findElements(By.xpath("//*[@id=\"wrapframe\"]/iframe"));
		System.out.println(framelist);

	}



	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");
		Frame names=new Frame();
		names.getframe();


	}

}
