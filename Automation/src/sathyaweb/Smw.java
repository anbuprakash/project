package sathyaweb;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Smw {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");
		OpeningWebsiteAndGettingWrittingValues owagwv =new OpeningWebsiteAndGettingWrittingValues();	//obj creation for the class to access the following method
		owagwv.goToParticularPage();		
		owagwv.gettingAndWrittingValues();
//		BestInProducts bip= new BestInProducts();
//		bip.bestInProducts();
	}

}
class OpeningWebsiteAndGettingWrittingValues 
{	
	public WebDriver driver=new ChromeDriver();		
	ArrayList<ProductDetails> details=new ArrayList<ProductDetails>();
	void goToParticularPage()					//website opened and redirected to mobiles and set the list product in the page to 48
	{
		driver.get("https://www.sathya.in");
		driver.manage().window().maximize();
		System.out.println("www.Sathya.in Website opened");			
		driver.findElement(By.xpath("//div[@class='nav-slider']//li[@id='main-nav-item-85']")).click();		
		driver.findElement(By.xpath("//nav[@class='list-group catmenu']//a[2]")).click();		
		Select Dropdown = new Select(driver.findElement(By.id("artlist-action-pagesize")));
		Dropdown.selectByVisibleText("48");
	}

	void gettingAndWrittingValues() throws IOException	
	{
		String brand,regularPrice,currentPrice,amountSaved,rearCamera,frontCamera,ram,rom,operatingSystem,processor;
			
		for(int i=1;i<5;i++)
		{				
			driver.findElement(By.xpath("//article["+i+"]//a[@class='art-picture img-center-container']")).click();
			driver.findElement(By.xpath("//following::a[contains(text(),'Features')]")).click();
							
			brand =driver.findElement(By.xpath("//table//following-sibling::td[contains(text(),'Brand')]/following-sibling::td")).getText();
			if(driver.findElements(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")).size()>0)
			{
				regularPrice=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")).getText();
			}
			else
			{
				regularPrice="Nil";
			}		
			currentPrice=driver.findElement(By.xpath("//div[@class='pd-price-block']/div")).getText();
			currentPrice=currentPrice.substring(2);

			if(driver.findElements(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")).size()>0)
			{
				amountSaved=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")).getText();	
				amountSaved=amountSaved.substring(2);
				amountSaved=amountSaved.replaceAll("10", "");
				amountSaved=amountSaved.replaceAll("%", "");
				amountSaved=amountSaved.replaceAll(" ", "");
				amountSaved=amountSaved.replaceAll("()", "");
			}
			else
			{
				amountSaved="Nil";
			}			
			if(driver.findElements(By.xpath("//table//td[contains(text(),'Secondary Camera')]//following-sibling::td")).size()>0)
			{
				frontCamera=driver.findElement(By.xpath("//table//td[contains(text(),'Secondary Camera')]//following-sibling::td")).getText();	
			}
			else
			{
				frontCamera="Nil";
			}	
			frontCamera=frontCamera.replaceAll(" MP","");
			regularPrice=regularPrice.substring(2);
			
			if(driver.findElements(By.xpath("//table//td[contains(text(),'Primary Camera')]//following-sibling::td")).size()>0)
			{
				rearCamera=driver.findElement(By.xpath("//table//td[contains(text(),'Primary Camera')]//following-sibling::td")).getText();
			}
			else
			{
				rearCamera="Nil";
			}				

			Pattern p=Pattern.compile("\\d+");	//Contains only alphabets and symbols	
			Matcher m=p.matcher(rearCamera);	//m have only number group 
			int camera=0;
			int cam=0;
			while(m.find())
			{

				cam=Integer.parseInt(m.group());
				camera=camera+cam;
			}
			rearCamera=Integer.toString(camera);
			rearCamera=rearCamera.replaceAll(" MP","");
			if(driver.findElements(By.xpath("//table//following-sibling::td[contains(text(),'RAM Capacity')]/following-sibling::td")).size()>0)
			{
				ram=driver.findElement(By.xpath("//table//following-sibling::td[contains(text(),'RAM Capacity')]/following-sibling::td")).getText();	
			}
			else
			{
				ram="Nil";
			}	
			ram=ram.replaceAll(" GB","");
			if(driver.findElements(By.xpath("//table//following-sibling::td[contains(text(),'RAM Capacity')]/following-sibling::td")).size()>0)
			{
				rom =driver.findElement(By.xpath("//table//td[contains(text(),'ROM Capacity')]//following-sibling::td")).getText();	
			}
			else
			{
				rom="Nil";
			}	
			rom=rom.replaceAll(" GB", "");
			if(driver.findElements(By.xpath("//table//following-sibling::td[contains(text(),'Operating System')]/following-sibling::td")).size()>0)
			{
				operatingSystem=driver.findElement(By.xpath("//table//following-sibling::td[contains(text(),'Operating System')]/following-sibling::td")).getText();
			}
			else
			{
				operatingSystem="Nil";
			}	
			if(driver.findElements(By.xpath("//table//td[contains(text(),'Processor')]//following-sibling::td")).size()>0)
			{
				processor=driver.findElement(By.xpath("//table//td[contains(text(),'Processor')]//following-sibling::td")).getText();	
			}
			else
			{
				processor="Nil";
			}
			
			details.add(new ProductDetails(brand,regularPrice,currentPrice,amountSaved,rearCamera,frontCamera,ram,rom,operatingSystem,processor));
			FileInputStream fis= new FileInputStream("D:\\prakash\\excelldata\\MobileDetails.xlsx");	
			XSSFWorkbook xl=new XSSFWorkbook(fis);		
			XSSFSheet sheet=xl.getSheetAt(0);
			sheet.createRow(i);	
			sheet.getRow(i).createCell(i-1).setCellValue(i+1);
			sheet.getRow(i).createCell(i).setCellValue(details.get(i).getBrand());
			sheet.getRow(i).createCell(i+1).setCellValue(details.get(i).getCurrentPrice());
			sheet.getRow(i).createCell(i+2).setCellValue(details.get(i).getAmountSaved());	
 			sheet.getRow(i).createCell(i+3).setCellValue(details.get(i).getRearCamera());	//set the value to the particular cell of particular row 
			sheet.getRow(i).createCell(i+4).setCellValue(details.get(i).getFrontCamera());	
			sheet.getRow(i).createCell(i+5).setCellValue(details.get(i).getRam());		
			sheet.getRow(i).createCell(i+6).setCellValue(details.get(i).getRom());	
			sheet.getRow(i).createCell(i+7).setCellValue(details.get(i).getOperatingSystem());
			sheet.getRow(i).createCell(i+8).setCellValue(details.get(i).getProcessor());	
			fis.close();
			FileOutputStream fos = new FileOutputStream("D:\\prakash\\excelldata\\MobileDetails.xlsx");	//data's are written in this specified directory file
			xl.write(fos);
			fos.close();						//after writting data output stream should be closed.
			xl.close();							//workbook should be closed.
			driver.navigate().back();			//go back to the previous page , where it came from.
		}
			
	}
}
class ProductDetails
{
	private	String brand,regularPrice,currentPrice,amountSaved,rearCamera,frontCamera,ram,rom,operatingSystem,processor;

	ProductDetails(String brand,String regularPrice,String currentPrice,String amountSaved,String rearCamera,String frontCamera, String ram, String rom, String operatingSystem,String processor)
	{
		this.brand=brand;
		this.frontCamera=frontCamera;
		this.rearCamera=rearCamera;
		this.rom=rom;
		this.ram=ram;
		this.operatingSystem=operatingSystem;
		this.processor=processor;
		this.amountSaved=amountSaved;
		this.regularPrice=regularPrice;
		this.currentPrice=currentPrice;
	}
	public String getRegularPrice() {
		return regularPrice;
	}
	public String getCurrentPrice() {
		return currentPrice;
	}
	public String getAmountSaved() {
		return amountSaved;
	}
	public String getBrand() {
		return brand;
	}
	public String getFrontCamera() {
		return frontCamera;
	}
	public String getRearCamera() {
		return rearCamera;
	}
	public String getRam() {
		return ram;
	}
	public String getRom() {
		return rom;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public String getProcessor() {
		return processor;
	}
}