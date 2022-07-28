package sathyaweb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SathyaMobile {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\browser\\ChromeDriver.exe");
		Mobile search=new Mobile();
		search.mobileFeatures();

	}

}

class Mobile {
	
	WebDriver driver;

	public void mobileFeatures() throws IOException   {
		//get excell file
		File file=new File("D:\\prakash\\excelldata\\MobileDetails.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("ProductDetails");
		
		driver=new ChromeDriver();
		
		driver.get("https://www.sathya.in"); //url
		driver.manage().window().maximize(); //maximize window

//		WebElement input=	driver.findElement(By.xpath("//input[@id='instasearch']"));
//		input.sendKeys("mobiles"+Keys.ENTER);
		driver.findElement(By.xpath("//li[@id='main-nav-item-85']/a")).click();  //electronics
		driver.findElement(By.xpath("//aside[@id='content-left']/div[1]/nav/a[2]")).click();  //mobile
		driver.findElement(By.xpath("//select[@id='artlist-action-pagesize'and@data-qname=\'s']")).click(); //24 page
		driver.findElement(By.xpath("//select[@id='artlist-action-pagesize']/option[4]")).click(); //48 page
	    
		for(int i=1;i<=48;i++) { //iterate 48 mobiles
	    
			driver.findElement(By.xpath("//article["+i+"]//a[@class='art-picture img-center-container']")).click(); 
	         driver.findElement(By.xpath("//a[contains(text(),'Features')]")).click(); //features
	         	
	              Row rowvalue=sh.getRow(i); //get row
	    		  WebElement getBrand=driver.findElement(By.xpath("//td[normalize-space()='Brand']//following::td[1]"));
	    		  String brand=getBrand.getText(); 
	    		  System.out.println("Brand :"+ brand);
	    		  rowvalue.getCell(1).setCellValue(brand); //set cell value
	    		 
	    		  String ex1="RAM Capacity";
	    	      String act1=driver.findElement(By.xpath("//div[@id='pd-tabs-2']")).getText();
	    		  if(act1.contains(ex1)){
	    		  WebElement getRam=driver.findElement(By.xpath("//td[normalize-space()='RAM Capacity']//following::td[1]")); 
	    		  String ram=getRam.getText(); 
	    		  String r=ram.substring(0, 1);
	    		  System.out.println("Ram :"+ r);
	    		  rowvalue.getCell(7).setCellValue(r);
	  	    		  }else {
	    				  System.out.println("Nil");
	    				  rowvalue.getCell(7).setCellValue("Nil");
	    			  }
	    		  
	    		  String ex2="ROM Capacity";
	    	      String act2=driver.findElement(By.xpath("//div[@id='pd-tabs-2']")).getText();
	    		  if(act2.contains(ex2)){
	    		  WebElement getRom=driver.findElement(By.xpath("//td[normalize-space()='ROM Capacity']//following::td[1]")); 
	    		  String rom=getRom.getText();
	    		  String s=rom.substring(0, 3);
	    		  System.out.println("Rom :"+rom.substring(0, 3));
	    		  rowvalue.getCell(8).setCellValue(s);
	  	    		  }else {
	    				  System.out.println("Nil");
	    				  rowvalue.getCell(8).setCellValue("Nil");
	    			  }
	    		 
	    		  
	    		  String ex3="Primary Camera";
	    	      String act3=driver.findElement(By.xpath("//div[@id='pd-tabs-2']")).getText();
	    		  if(act3.contains(ex3)){
	    		  WebElement prCamara=driver.findElement(By.xpath("//td[normalize-space()='Primary Camera']//following::td[1]")); String
	    		  priCamara=prCamara.getText();
	    		  System.out.println("Primary camara :"+priCamara);
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
		  	    		 }else {
		    				  System.out.println("Nil");
		    				  rowvalue.getCell(5).setCellValue("Nil");
		    			  }
	    

	    		  
	    		  WebElement seCamara=driver.findElement(By.xpath("//td[normalize-space()='Secondary Camera']//following::td[1]"));
	    		  String secCamara=seCamara.getText(); 
	    		  String sec=secCamara.substring(0,2);
	    		  System.out.println("Secondary camara :"+secCamara);
	    		  rowvalue.getCell(6).setCellValue(sec);
	    		 
	    		  if(driver.findElements(By.xpath("//table//following-sibling::td[contains(text(),'Operating System')]/following-sibling::td")).size()>0)
	  			{
	    		  WebElement opeSystem=driver.findElement(By. xpath("//td[normalize-space()='Operating System']//following::td[1]"));
	    		  String operSystem=opeSystem.getText();
	    		  System.out.println("Operating system :"+operSystem);
	    		  rowvalue.getCell(9).setCellValue(operSystem);
	  			 }else {
   				  System.out.println("Nil");
   				  rowvalue.getCell(9).setCellValue("Nil");
   			  }

	    			    		  

	    		  WebElement price=driver.findElement(By.xpath("//*[@id=\"pd-form\"]/section/aside/div[4]/div[1]/div/div[1]/div")); 
	    		  String currentPrice=price.getText();
	    	//	  String regular=regularPrice.substring(1,15);
	    		  System.out.println("Current price :"+currentPrice);
	    		  rowvalue.getCell(3).setCellValue(currentPrice);
	    		  
	    		  if(driver.findElements(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")).size()>0)
	  			{
	    			 WebElement regular=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")); 
	    			  String regularPrice=regular.getText();
	    			  System.out.println("Regular price :"+regularPrice);
	    			  rowvalue.getCell(2).setCellValue(regularPrice);
	    			}else {
	    				System.out.println("Nil");
	    				rowvalue.getCell(2).setCellValue("Nil");
	    			}
	    		  if(driver.findElements(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")).size()>0)
	  			{
	    			  WebElement you=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")); 
	    			  String yous=you.getText();
	    			  System.out.println("Save :"+yous);
	    			  rowvalue.getCell(4).setCellValue(yous);
	    			}else {
	    				System.out.println("Nil");
	    				rowvalue.getCell(4).setCellValue("Nil");
	    			}
	    		  
	    
	    	      String ex="Processor";
	    	      String act=driver.findElement(By.xpath("//div[@id='pd-tabs-2']")).getText();
	    		  if(act.contains(ex)){
	    			  WebElement process=driver.findElement(By. xpath("//td[normalize-space()='Processor']//following::td[1]"));
	    			  String proces=process.getText();
	    			  System.out.println("process :"+proces);
	    			  rowvalue.getCell(10).setCellValue(proces);
	    			  }else {
	    				  System.out.println("Nil");
	    				  rowvalue.getCell(10).setCellValue("Nil");
	    			  }

	    		  
	    		 

	    	     FileOutputStream fos=new FileOutputStream(file);
	    	     wb.write(fos);
	         	 
	         	 
	         	 driver.navigate().back();
	         	 
	          }
		
}

	
	}
//class BestMobiles{
//	public void bestMobiles() throws IOException {
//		FileInputStream fis = new FileInputStream("D:\\prakash\\excelldata\\MobileDetails.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(1);
//		Row row = sheet.getRow(1);
//		Cell cell = row.getCell(1).setCellValue("samsung");
//		
//		fis.close();
//		
//
//		
//	}
//	
//}

