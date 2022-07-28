package alertdragconc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoSelenium {
	WebDriver driver;

	public void moveElement(){

		driver=new ChromeDriver(); //chrome driver

		driver.get(" http://www.leafground.com/pages/drop.html"); //get url
		
		driver.manage().window().maximize(); //window maximize

		WebElement drag=driver.findElement(By.id("draggable")); //find & drag
		WebElement drop=driver.findElement(By.id("droppable")); //find & drop


		Actions action=new Actions(driver); //actions
		action.dragAndDrop(drag, drop).perform(); //to perform
		WebElement w=driver.findElement(By.id("droppable"));
		String web=w.getText();

		String text=drop.getText();

		//compare correct or not
		if(text.equals(web)) {
			System.out.println(" File is dropped correctly");
		}else {
			System.out.println(" File couldn't be dropped correctly");
		}
		driver.quit(); //method close

	}
	public void button() throws InterruptedException {
		driver=new ChromeDriver();

		driver.get(" http://www.leafground.com/pages/Alert.html"); //get url
		driver.manage().window().maximize(); //window maximize

		//alert box
		driver.findElement(By.xpath("//button[contains(text(),'Alert Box')]")).click();
		driver.switchTo().alert().accept(); // accept the alert

		//confirm box
		driver.findElement(By.xpath(" //button[contains(text(),'Confirm Box')]")).click();
		driver.switchTo().alert().dismiss(); //cancel the alert
		String out=	 driver.findElement(By.id("result")).getText(); //get the msg
		System.out.println(out);


		//promt box
		WebElement ptbox=driver.findElement(By.xpath("//button[contains(text(),'Prompt Box')]"));
		ptbox.click();
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

		driver.quit(); //method close
	}
	public void getNames()   {
		driver=new ChromeDriver();

		driver.get(" https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html"); //get url
		driver.manage().window().maximize(); //maximize window



		//find get user
		WebElement web=driver.findElement(By.id("save"));

		//get first & last names


		WebElement getfnames =driver.findElement(By.id("loading"));

		//iterative 5 times
		for(int i=0;i<5;i++) {
			web.click();
			//		Thread.sleep(3000);
			WebDriverWait wait=new WebDriverWait(driver,30); //explisit wait
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'loading...')]")));
			String s=getfnames.getText();
			System.out.println(s +"\n");
		}
		driver.quit(); //method close

	}
	public void increAndDecre() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
		driver.manage().window().maximize();

		//1st point
		WebElement web=driver.findElement(By.name("range"));
		WebElement w=driver.findElement(By.id("range"));
		Actions action=new Actions(driver);
		action.clickAndHold(web).dragAndDrop(web, w).release().build().perform();
		action.clickAndHold(web).dragAndDrop(w, web).release().build().perform();
		//2nd  point
		WebElement web1=driver.findElement(By.xpath("//*[@id=\"slider2\"]/div/input"));
		WebElement w1=driver.findElement(By.id("rangePrimary"));
		Actions action1=new Actions(driver);
		action.clickAndHold(web1).dragAndDrop(web1, w1).release().build().perform();
		action.clickAndHold(web1).dragAndDrop(w1, web1).release().build().perform();
		//3rd  point
		WebElement web2=driver.findElement(By.xpath("//*[@id=\"slider3\"]/div/input"));
		WebElement w2=driver.findElement(By.id("rangeSuccess"));
		Actions action2=new Actions(driver);
		action2.clickAndHold(web2).dragAndDrop(web2, w2).release().build().perform();
		action2.clickAndHold(web2).dragAndDrop(w2, web2).release().build().perform();
		//4th  point
		WebElement web3=driver.findElement(By.xpath("//*[@id=\"slider4\"]/div/input"));
		WebElement w3=driver.findElement(By.id("rangeInfo"));
		Actions action3=new Actions(driver);
		action3.clickAndHold(web3).dragAndDrop(web3, w3).release().build().perform();
		action3.clickAndHold(web3).dragAndDrop(w3, web3).release().build().perform();
		//5th  point
		WebElement web5=driver.findElement(By.xpath("//*[@id=\"slider5\"]/div/input"));
		WebElement w5=driver.findElement(By.id("rangeWarning"));
		Actions action5=new Actions(driver);
		action.clickAndHold(web5).dragAndDrop(web5, w5).release().build().perform();
		action.clickAndHold(web5).dragAndDrop(w5, web5).release().build().perform();
		//6th  point
		WebElement web4=driver.findElement(By.xpath("//*[@id=\"slider6\"]/div/input"));
		WebElement w4=driver.findElement(By.id("rangeDanger"));
		Actions action4=new Actions(driver);
		action.clickAndHold(web4).dragAndDrop(web4, w4).release().build().perform();
		action.clickAndHold(web4).dragAndDrop(w4, web4).release().build().perform();

		driver.quit(); //close method

	}
	public void getFrame(){
		driver=new ChromeDriver();

		driver.get(" http://www.leafground.com/pages/frame.html");
		driver.manage().window().maximize();

		//find frame & click
		driver.switchTo().frame(0);
		WebElement button1=driver.findElement(By.id("Click"));
		button1.click();

		//go to start html 
		driver.switchTo().defaultContent();

		//find 2nd frame & click
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		WebElement button2=driver.findElement(By.id("Click1"));
		button2.click();

		//find total no of frames
		driver.switchTo().defaultContent();
		List<WebElement> totalframe=driver.findElements(By.tagName("iframe"));
		int size=totalframe.size();
		System.out.println("Total no of frames : "+size);


		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("//html//body")).getText());


		driver.close(); //close the window

	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\browser\\driver.exe");
		DemoSelenium demo=new DemoSelenium();  //object create
		demo.moveElement(); //call drag & drop method
		demo.button();   //call alert method
		demo.getNames(); // call get first & last names method
		demo.increAndDecre(); //6 point increase & decrease method
		demo.getFrame(); //both frame click find no frame
	}

}
