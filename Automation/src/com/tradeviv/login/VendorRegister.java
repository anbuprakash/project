package com.tradeviv.login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VendorRegister {

	public static void main(String[] args) throws IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".//ChromeDriver//chromedriver.exe");
		Base base=new Base();
		base.homePage();

	}

}

class Base{
	public WebDriver driver;


	public void homePage() throws IOException, InterruptedException   {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get("http://tradeviv.com/");

		driver.findElement(By.xpath("//span[contains(text(),'Accounts & Lists')]")).click();
		driver.findElement(By.className("sign-in-btn")).click();
		driver.findElement(By.id("nav-reg-tab11")).click();
//		for(int i=1;i<3;i++) {

		FileInputStream fis = new FileInputStream("D:\\prakash\\excelldata\\Vendor Registration.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);

		Cell cell = row.getCell(1);
		String data=cell.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='name'and@placeholder='Vendor Name']")).sendKeys(data);

		Cell cell1 = row.getCell(4);
		String data1=cell1.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='email'and@placeholder='Company E-mail']")).sendKeys(data1);

		Cell cell2 = row.getCell(3);
		String data2=cell2.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='phone'and@placeholder='Vendor Phone number']")).sendKeys(data2);

		Cell cell3 = row.getCell(2);
		String data3=cell3.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='shop_name'and@placeholder='Company Name']")).sendKeys(data3);
		fis.close();
		driver.findElement(By.xpath("//div[@id='nav-reg11']//button[@type='submit']")).click();
		
		
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='vendor-login']//button[@class='close']")));
		Point location = driver.findElement(By.xpath("//div[@id='vendor-login']//button[@class='close']")).getLocation();
		String[] s = location.toString().replace("(", "").replace(")", "").replace(" ", "").split(",");
		System.out.println(location.toString());
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		int xaxis = Integer.parseInt(s[0]);
		System.out.println(xaxis);
		int yaxis = Integer.parseInt(s[1]);
		System.out.println(yaxis);
		action.moveByOffset(xaxis+3, yaxis-3).click().build().perform();

		fis.close();
		
		driver.findElement(By.xpath("//*[@id='subscriptionForm']/div/span/i")).click();
	//	driver.close();
	//	}

	}
	
	



}
