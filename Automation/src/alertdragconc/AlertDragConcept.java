package alertdragconc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class Demo{

	WebDriver driver;

	public void moveelement(){

		driver=new ChromeDriver();

		driver.get(" http://www.leafground.com/pages/drop.html"); //get url
		driver.manage().window().maximize(); //window maximize

		WebElement drag=driver.findElement(By.id("draggable")); //find & drag
		WebElement drop=driver.findElement(By.id("droppable")); //find & drop


		Actions action=new Actions(driver); //actions
		action.dragAndDrop(drag, drop).perform(); //to perform
		WebElement w=driver.findElement(By.id("droppable"));
		String web=w.getText();

		String text=drop.getText();
		
		if(text.equals(web)) {
			System.out.println(" File is dropped correctly");
		}else {
			System.out.println(" File couldn't be dropped correctly");
		}
		driver.close();

	}




}



public class AlertDragConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");
		Demo m=new Demo();
		m.moveelement();



	}

}
