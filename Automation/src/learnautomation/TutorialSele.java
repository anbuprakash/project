package learnautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TutorialSele {

	public static void main(String[] args) throws InterruptedException {

		String s="Hi Prakash";
		Integer a=10;
		Integer b=20;
		Integer c=a+b;
		//		String l=String.valueOf(c); // integer to string change


		System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")).click(); //pop up window close
		driver.findElement(By.id("user-message")).sendKeys(s);  //find & message pass
		driver.findElement(By.xpath("//*[@id=\"get-input\"]/button")).click();  //find & click show message
//		driver.findElement(By.xpath("//button[@class='navbar-toggle']")).click();
		String v=driver.findElement(By.id("display")).getText(); //get output value

		if(s.equalsIgnoreCase(v)) {    //compare given & out 
			System.out.println("The typed message matched with displayed message");
		}
		else {
			System.out.println("The typed message not matched with displayed message");
		}

		driver.findElement(By.id("sum1")).sendKeys(String.valueOf(a)); //find & value pass
		driver.findElement(By.id("sum2")).sendKeys(String.valueOf(b)); //find & value pass
		driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();   //find & click get total
		String x=driver.findElement(By.id("displayvalue")).getText();  //get output value

		int i=Integer.parseInt(x); //string to integer change

		if(c == i) { //compare given & out 
			System.out.println("The addition of " + a +" and "+ b + " is " +x);
		}
		else {
			System.out.println("The addition of " + a +" and "+ b + "is" +60);

		}


	}

}
