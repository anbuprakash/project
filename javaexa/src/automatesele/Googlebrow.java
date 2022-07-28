package automatesele;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googlebrow 
{
	public static WebDriver driver;
	public void sea()
	{
		driver=new ChromeDriver();
		driver.get("www.google.com");
		driver.manage().window().maximize();
		
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\browser\\chromedriver.exe");
		Googlebrow g=new Googlebrow();
		g.sea();

	}
}
