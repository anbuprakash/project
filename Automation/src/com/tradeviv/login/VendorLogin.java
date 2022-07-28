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
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VendorLogin {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", ".//ChromeDriver//chromedriver.exe");
		LoginCredentials login=new LoginCredentials();
		login.UserDetails();

	}

}

 class LoginCredentials{
		public WebDriver driver;
        ArrayList<LoginData> details=new ArrayList<LoginData>();
	 
	 public void UserDetails() throws InterruptedException, IOException {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(4000,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
			driver.get("http://tradeviv.com/");
			FileInputStream fis = new FileInputStream("D:\\prakash\\excelldata\\logindata.xlsx");
    		XSSFWorkbook workbook = new XSSFWorkbook(fis);
    		XSSFSheet sheet = workbook.getSheetAt(0);
            for(int i=1;i<=4;i++) {
            	
        	//	Row row = sheet.getRow(i);
			driver.findElement(By.xpath("//span[contains(text(),'Accounts & Lists')]")).click();
			driver.findElement(By.className("sign-in-btn")).click();
			
			driver.findElement(By.id("nav-log-tab11")).click();
			String vendormail=sheet.getRow(i).getCell(1).getStringCellValue();
			String password=sheet.getRow(i).getCell(2).getStringCellValue();
			details.add(new LoginData(vendormail, password));
		//	Cell cell = row.getCell(1);
		//	String data=cell.getStringCellValue();
			driver.findElement(By.xpath("//div[@id='nav-log11']//input[@name='email']")).sendKeys(vendormail);
//			Cell cell1 = row.getCell(2);
//			String data1=cell1.getStringCellValue();
			driver.findElement(By.xpath("//div[@id='nav-log11']//input[@type='password']")).sendKeys(password);
			
			driver.findElement(By.xpath("//div[@id='nav-log11']//button[@type='submit']")).click();
			
//		Point location=	driver.findElement(By.xpath("//div[@id='vendor-login']//button[@class='close']")).getLocation();
//		String[] s = location.toString().replace("(", "").replace(")", "").replace(" ", "").split(",");
//		System.out.println(location.toString());
//		Thread.sleep(3000);
//		Actions action = new Actions(driver);
//		int xaxis = Integer.parseInt(s[0]);
//		System.out.println(xaxis);
//		int yaxis = Integer.parseInt(s[1]);
//		System.out.println(yaxis);
//		action.moveByOffset(xaxis+5, yaxis-4).click().build().perform();
			
	//		driver.navigate().back();
	//		driver.findElement(By.xpath("//div[@id='subscriptionForm']//span")).click();
		 
	 }
	 }
	
}
  class LoginData {
	 private String vendormail,password;
	 	
	   public  LoginData(String vendormail,String password) {
	 	this.vendormail=vendormail;
	 	this.password=password;
	 	
	 	}
	 	
	 	public String getvendormail() {
	 		return vendormail;
	 	}
	 	public String getpassword() {
	 		return password;
	 	}
	 	
	 }

