package sathyaweb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SathyaWebsite {

	public static void main(String[] args) throws ElementNotInteractableException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\browser\\ChromeDriver.exe");
		SearchMobiles search=new SearchMobiles();
		search.mobileFeatures();

	}

}

class SearchMobiles{
	WebDriver driver;

	public void mobileFeatures() throws IOException   {
		File file=new File("D:\\prakash\\excelldata\\MobileDetails.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("ProductDetails");

		driver=new ChromeDriver();

		driver.get("https://www.sathya.in");
		driver.manage().window().maximize();
		WebElement input=	driver.findElement(By.xpath("//input[@id='instasearch']"));
		driver.findElement(By.xpath("//li[@id='main-nav-item-85']/a")).click();
		driver.findElement(By.xpath("//aside[@id='content-left']/div[1]/nav/a[2]")).click();
		driver.findElement(By.xpath("//select[@id='artlist-action-pagesize'and@data-qname=\'s']")).click();
		driver.findElement(By.xpath("//select[@id='artlist-action-pagesize']/option[4]")).click();





		driver.findElement(By.xpath("//div[@class='artlist artlist-grid artlist-4-cols']//article[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Features')]")).click();
		//driver.findElement(By.xpath("//div[@class='artlist artlist-grid artlist-4-cols']//article[5]")).click();

		Row rowvalue=sh.getRow(1);
		WebElement getBrand=driver.findElement(By.xpath("//td[normalize-space()='Brand']//following::td[1]"));
		String brand=getBrand.getText();
		System.out.println("Brand :"+ brand);
		rowvalue.getCell(1).setCellValue(brand);


		WebElement getRam=driver.findElement(By.xpath("//td[normalize-space()='RAM Capacity']//following::td[1]"));
		String ram=getRam.getText();
		String r=ram.substring(0, 1);
		System.out.println("Ram :"+ ram.substring(0, 1));
		rowvalue.getCell(7).setCellValue(r);

		WebElement getRom=driver.findElement(By.xpath("//td[normalize-space()='ROM Capacity']//following::td[1]"));
		String rom=getRom.getText();
		String s=rom.substring(0, 3);
		System.out.println("Rom :"+rom.substring(0, 3));
		rowvalue.getCell(8).setCellValue(s);

		WebElement prCamara=driver.findElement(By.xpath("//td[normalize-space()='Primary Camera']//following::td[1]"));
		String priCamara=prCamara.getText();
		System.out.println("Primary camara :"+priCamara);
		rowvalue.getCell(5).setCellValue(priCamara);
		 String temp = "0";
		 
	        int sum = 0;
	 
	        for (int k = 0; k < priCamara.length(); k++) {
	            char ch = priCamara.charAt(k);
	 
	            if (Character.isDigit(ch))
	                temp += ch;
	 
	            else {
	                sum += Integer.parseInt(temp);
	 
	                temp = "0";
	
	rowvalue.getCell(5).setCellValue(sum += Integer.parseInt(temp));
	            
	        }
	        }

		WebElement seCamara=driver.findElement(By.xpath("//td[normalize-space()='Secondary Camera']//following::td[1]"));
		String secCamara=seCamara.getText();
		String sec=secCamara.substring(0, 2);
		System.out.println("Secondary camara :"+secCamara);
		rowvalue.getCell(6).setCellValue(sec);

		WebElement opeSystem=driver.findElement(By.xpath("//td[normalize-space()='Operating System']//following::td[1]"));
		String operSystem=opeSystem.getText();
		System.out.println("Operating system :"+operSystem);
		rowvalue.getCell(9).setCellValue(operSystem);

         
		WebElement price=driver.findElement(By.xpath("//*[@id=\"pd-form\"]/section/aside/div[4]/div[1]/div/div[1]/div"));
		String regularPrice=price.getText();
		String regular=regularPrice.substring(1, 11);
		System.out.println("Regular price :"+regularPrice);
		rowvalue.getCell(3).setCellValue(regular);
		
		String b="Regular:";
		String c=driver.findElement(By.xpath("//form[@id=\"pd-form\"]/section/aside/div[4]/div[1]/div/div[1]")).getText();
		if(b.contains(c)) {
		 WebElement regul=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")); 
		  String regula=regul.getText();
		  System.out.println("Regular price :"+regula);
		  rowvalue.getCell(2).setCellValue(regula);
		}else {
			System.out.println("Nil");
			rowvalue.getCell(2).setCellValue("Nil");
		}
		String a="You save:";
		String d=driver.findElement(By.xpath("//form[@id='pd-form']/section/aside/div[4]/div[1]/div/div[1]")).getText();
		if(a.contains(d)) {
		  WebElement you=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")); 
		  String yous=you.getText();
		  System.out.println("Save :"+yous);
		  rowvalue.getCell(4).setCellValue(yous);
		}else {
			System.out.println("Nil");
			rowvalue.getCell(4).setCellValue("Nil");
		}
		if(driver.findElements(By.xpath("//td[normalize-space()='Processor']")).size()>0)
		{

		 WebElement process=driver.findElement(By. xpath("//td[normalize-space()='Processor']//following::td[1]"));
		  String proces=process.getText();
		  System.out.println("process :"+proces);
		  rowvalue.getCell(10).setCellValue(proces);
		}else {
			System.out.println("Nil");
		}
		

		
		driver.navigate().back();




		//	//input.sendKeys("mobiles"+Keys.LEFT);

		//driver.navigate().back();
		//		File file1=new File("D:\\prakash\\excelldata\\MobileDetails.xlsx");
		//		FileInputStream fis=new FileInputStream(file1);
		//		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		//		XSSFSheet sh1 = wb1.getSheet("ProductDetails");
		//		
		
		  driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/article[2]" )).click();
		  driver.findElement(By.xpath("//a[contains(text(),'Features')]")).click();
		  
		  Row rowvalue1=sh.getRow(2); WebElement getBrand1=driver.findElement(By.xpath("//td[normalize-space()='Brand']//following::td[1]"));
		  String brand1=getBrand1.getText(); System.out.println("Brand :"+ brand1);
		  rowvalue1.getCell(1).setCellValue(brand1);
		  
		  WebElement getRam1=driver.findElement(By.xpath("//td[normalize-space()='RAM Capacity']//following::td[1]")); 
				  String ram1=getRam1.getText(); 
				  String r1=ram1.substring(0, 1);
				  System.out.println("Ram :"+ r1);
				  rowvalue1.getCell(7).setCellValue(r1);
		 
		  
		  WebElement getRom1=driver.findElement(By.
		  xpath("//td[normalize-space()='ROM Capacity']//following::td[1]")); 
		  String rom1=getRom1.getText();
		  String s1=rom.substring(0, 3);
		  System.out.println("Rom :"+rom1.substring(0, 3));
		  rowvalue1.getCell(8).setCellValue(s1);
		  
		  WebElement prCamara1=driver.findElement(By.xpath("//td[normalize-space()='Primary Camera']//following::td[1]")); String
		  priCamara1=prCamara1.getText();
		  System.out.println("Primary camara :"+priCamara1);
		   rowvalue1.getCell(5).setCellValue(priCamara1); 

		  
		  WebElement seCamara1=driver.findElement(By.
		  xpath("//td[normalize-space()='Secondary Camera']//following::td[1]"));
		  String secCamara1=seCamara1.getText(); String sec1=secCamara1.substring(0,2);
		  System.out.println("Secondary camara :"+secCamara1);
		  rowvalue1.getCell(6).setCellValue(sec1);
		  
		  WebElement opeSystem1=driver.findElement(By. xpath("//td[normalize-space()='Operating System']//following::td[1]"));
		  String operSystem1=opeSystem1.getText();
		  System.out.println("Operating system :"+operSystem1);
		  rowvalue1.getCell(9).setCellValue(operSystem1);
		  
		  WebElement process1=driver.findElement(By. xpath("//td[normalize-space()='Processor']//following::td[1]"));
		  String proces1=process1.getText();
		  System.out.println("process :"+proces1);
		  rowvalue1.getCell(10).setCellValue(proces1);

		  
		  
		  WebElement price1=driver.findElement(By.xpath("//*[@id=\"pd-form\"]/section/aside/div[4]/div[1]/div/div[1]/div")); 
		  String regularPrice1=price1.getText();
		  String regular1=regularPrice1.substring(1,11);
		  System.out.println("Current price :"+regularPrice1);
		  rowvalue1.getCell(3).setCellValue(regular1);
		  String b1="Regular:";
			String c1=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")).getText();
			if(b1==c1) {
//		  if(driver.findElements(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")).size()>0)
//			{
		  WebElement regul=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")); 
		  String regula=regul.getText();
		  System.out.println("Regular price :"+regula);
		  rowvalue1.getCell(2).setCellValue(regula);
			}else {
				System.out.println("Nil");
				rowvalue.getCell(2).setCellValue("Nil");
		  
		  WebElement you=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")); 
		  String yous=you.getText();
		  System.out.println("Save :"+yous);
		  rowvalue1.getCell(4).setCellValue(yous);
		  

		  

		  
		 driver.navigate().back();
		 
		 driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/article[3]" )).click();
		  driver.findElement(By.xpath("//a[contains(text(),'Features')]")).click();
		  
		  Row rowvalue2=sh.getRow(3);
		  WebElement getBrand2=driver.findElement(By.xpath("//td[normalize-space()='Brand']//following::td[1]"));
		  String brand2=getBrand2.getText(); 
		  System.out.println("Brand :"+ brand2);
		  rowvalue2.getCell(1).setCellValue(brand2);
		  
		  WebElement getRam2=driver.findElement(By.xpath("//td[normalize-space()='RAM Capacity']//following::td[1]")); 
				  String ram2=getRam2.getText(); 
				  String r2=ram2.substring(0, 1);
				  System.out.println("Ram :"+ r2);
				  rowvalue2.getCell(7).setCellValue(r2);
		 
		  
		  WebElement getRom2=driver.findElement(By.
		  xpath("//td[normalize-space()='ROM Capacity']//following::td[1]")); 
		  String rom2=getRom2.getText();
		  String s2=rom.substring(0, 3);
		  System.out.println("Rom :"+rom2.substring(0, 3));
		  rowvalue2.getCell(8).setCellValue(s2);
		  
		  WebElement prCamara2=driver.findElement(By.xpath("//td[normalize-space()='Primary Camera']//following::td[1]")); String
		  priCamara2=prCamara2.getText();
		  System.out.println("Primary camara :"+priCamara2);
		   rowvalue2.getCell(5).setCellValue(priCamara2); 

		  
		  WebElement seCamara2=driver.findElement(By.
		  xpath("//td[normalize-space()='Secondary Camera']//following::td[1]"));
		  String secCamara2=seCamara2.getText(); String sec2=secCamara2.substring(0,2);
		  System.out.println("Secondary camara :"+secCamara2);
		  rowvalue2.getCell(6).setCellValue(sec2);
		  
		  WebElement opeSystem2=driver.findElement(By. xpath("//td[normalize-space()='Operating System']//following::td[1]"));
		  String operSystem2=opeSystem2.getText();
		  System.out.println("Operating system :"+operSystem2);
		  rowvalue2.getCell(9).setCellValue(operSystem2);
		  
		  if("//td[normalize-space()='Processor']//following::td[1]".isBlank()) {
		  WebElement process2=driver.findElement(By. xpath("//td[normalize-space()='Processor']//following::td[1]"));
		  String proces2=process2.getText();
		  System.out.println("process :"+proces2);
		  rowvalue2.getCell(10).setCellValue(proces2);
		  }else {
			  System.out.println("Nil");
		  }

		  
		  
		  WebElement price2=driver.findElement(By.xpath("//*[@id=\"pd-form\"]/section/aside/div[4]/div[1]/div/div[1]/div")); 
		  String regularPrice2=price2.getText();
		  String regular2=regularPrice2.substring(1,11);
		  System.out.println("Regular price :"+regularPrice2);
		  rowvalue2.getCell(2).setCellValue(regular2);
		  
		 

	     FileOutputStream fos1=new FileOutputStream(file);
	     wb.write(fos1);
	}
	


	}
}








