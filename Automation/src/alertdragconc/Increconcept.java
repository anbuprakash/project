package alertdragconc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Increconcept {
	
	WebDriver driver;
	
	public void increanddecre() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
		driver.manage().window().maximize();
		
		
		WebElement web=driver.findElement(By.name("range"));
		WebElement w=driver.findElement(By.id("range"));

		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.clickAndHold(web).dragAndDrop(web, w).release().build().perform();
		Thread.sleep(2000);
		action.clickAndHold(web).dragAndDrop(w, web).release().build().perform();
		
		WebElement web1=driver.findElement(By.xpath("//*[@id=\"slider2\"]/div/input"));
		WebElement w1=driver.findElement(By.id("rangePrimary"));

		Actions action1=new Actions(driver);
		Thread.sleep(2000);
		action.clickAndHold(web1).dragAndDrop(web1, w1).release().build().perform();
		Thread.sleep(2000);
		action.clickAndHold(web1).dragAndDrop(w1, web1).release().build().perform();
		
		WebElement web2=driver.findElement(By.xpath("//*[@id=\"slider3\"]/div/input"));
		WebElement w2=driver.findElement(By.id("rangeSuccess"));

		Actions action2=new Actions(driver);
		Thread.sleep(2000);
		action.clickAndHold(web2).dragAndDrop(web2, w2).release().build().perform();
		Thread.sleep(2000);
		action.clickAndHold(web2).dragAndDrop(w2, web2).release().build().perform();
		
		WebElement web3=driver.findElement(By.xpath("//*[@id=\"slider4\"]/div/input"));
		WebElement w3=driver.findElement(By.id("rangeInfo"));

		Actions action3=new Actions(driver);
		Thread.sleep(2000);
		action.clickAndHold(web3).dragAndDrop(web3, w3).release().build().perform();
		Thread.sleep(2000);
		action.clickAndHold(web3).dragAndDrop(w3, web3).release().build().perform();
		
		WebElement web5=driver.findElement(By.xpath("//*[@id=\"slider5\"]/div/input"));
		WebElement w5=driver.findElement(By.id("rangeWarning"));

		Actions action5=new Actions(driver);
		Thread.sleep(2000);
		action.clickAndHold(web5).dragAndDrop(web5, w5).release().build().perform();
		Thread.sleep(2000);
		action.clickAndHold(web5).dragAndDrop(w5, web5).release().build().perform();
		
		WebElement web4=driver.findElement(By.xpath("//*[@id=\"slider6\"]/div/input"));
		WebElement w4=driver.findElement(By.id("rangeDanger"));

		Actions action4=new Actions(driver);
		Thread.sleep(2000);
		action.clickAndHold(web4).dragAndDrop(web4, w4).release().build().perform();
		Thread.sleep(2000);
		action.clickAndHold(web4).dragAndDrop(w4, web4).release().build().perform();
		
		driver.close();

	}


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");
		Increconcept m=new Increconcept();
		m.increanddecre();
		
		

	}

}
