package screenshot;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTube{

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", ".//ChromeDriver//chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.youtube.com/");
	driver.manage().window().maximize();
	driver.findElement(By.id("search")).sendKeys("pattu onna illukutha");
	driver.findElement(By.id("search-icon-legacy")).click();
	driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer'][1]")).click();
	
	

	}

}
