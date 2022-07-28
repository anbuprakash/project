package alertdragconc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonConcept {

	WebDriver driver;

	public void button() throws InterruptedException {
		driver=new ChromeDriver();
//		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.get(" http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();

		//alert box
		driver.findElement(By.xpath("//button[contains(text(),'Alert Box')]")).click();
		driver.switchTo().alert().accept();

		//confirm box
		driver.findElement(By.xpath(" //button[contains(text(),'Confirm Box')]")).click();
		driver.switchTo().alert().dismiss();
		String out=	 driver.findElement(By.id("result")).getText();
		System.out.println(out);

		
		//promt box
		driver.findElement(By.xpath("//button[contains(text(),'Prompt Box')]")).click();
		driver.switchTo().alert().sendKeys("Welcome to testleaf");
		driver.switchTo().alert().accept();
		String typeletter=driver.findElement(By.id("result1")).getText();
		System.out.println(typeletter);

		//link breaks
		driver.findElement(By.xpath("//button[@onclick='lineBreaks()']")).click();
		String text=driver.switchTo().alert().getText();
		int indexCount =text.length();			//no. of index in text
		int j=0;
		for(int i=0;i<indexCount-1;i++)			
		{
			if(text.charAt(i)=='\n')			//find new line in the text
			{
				
				j++;
			}
			
		}
		System.out.println("Number of Line breaks in : "+text+" is :\t"+j);
		driver.switchTo().alert().accept();
		
	
        //sweet alert
		driver.findElement(By.id("btn")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		
		driver.quit();
	}
		
	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");
		ButtonConcept m=new ButtonConcept();
		m.button();
		


	}

}
