package sathyaweb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sm {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\browser\\ChromeDriver.exe");
		MobilesF search=new MobilesF();
		search.mobileFeatures();
		search.bestOfBest();

	}

}
class MobilesF {

	WebDriver driver;
	ArrayList<MobileDetails> details=new ArrayList<MobileDetails>();

	public void mobileFeatures() throws IOException   {
		//get excell file

		//		ArrayList<MobileDetails> details=new ArrayList<MobileDetails>();	


		driver=new ChromeDriver();

		driver.get("https://www.sathya.in"); //url
		driver.manage().window().maximize(); //maximize window

		//		WebElement input=	driver.findElement(By.xpath("//input[@id='instasearch']"));
		//		input.sendKeys("mobiles"+Keys.ENTER);
	//	driver.findElement(By.xpath("//li[@id='main-nav-item-85']/a")).click();  //electronics
		driver.findElement(By.xpath("//a[contains(text(),'Electronics')]")).click();
		driver.findElement(By.xpath("//aside[@id='content-left']/div[1]/nav/a[2]")).click();  //mobile
		driver.findElement(By.xpath("//select[@id='artlist-action-pagesize'and@data-qname=\'s']")).click(); //24 page
		driver.findElement(By.xpath("//select[@id='artlist-action-pagesize']/option[4]")).click(); //48 page



		String brand,regularPrice,currentPrice,amountSaved,rearCamera = null,frontCamera = null,ram,rom,operatingSystem,processor;
		int j=0;
		for(int i=1;i<=5;i++) { //iterate 48 mobiles


			driver.findElement(By.xpath("//article["+i+"]//a[@class='art-picture img-center-container']")).click(); 
			driver.findElement(By.xpath("//a[contains(text(),'Features')]")).click(); //features

			WebElement getBrand=driver.findElement(By.xpath("//td[normalize-space()='Brand']//following::td[1]"));
			brand=getBrand.getText(); 
			System.out.println("Brand :"+  brand);
			if(driver.findElements(By.xpath("//table//following-sibling::td[contains(text(),'RAM Capacity')]/following-sibling::td")).size()>0)
			{
				WebElement getRam=driver.findElement(By.xpath("//td[normalize-space()='RAM Capacity']//following::td[1]")); 
				String r=getRam.getText(); 
				ram=r.replace(" GB", "");
				System.out.println("Ram :"+  ram);
			}
			else
			{
				ram="Nil";
				System.out.println( ram);
			}
			if(driver.findElements(By.xpath("//table//following-sibling::td[contains(text(),'ROM Capacity')]/following-sibling::td")).size()>0)
			{	
				WebElement getRom=driver.findElement(By.xpath("//td[normalize-space()='ROM Capacity']//following::td[1]")); 
				String  rom1=getRom.getText();
				rom= rom1.substring(0, 3);
				System.out.println("Rom :"+ rom.substring(0, 3));
			}
			else
			{
				rom="Nil";
				System.out.println( rom);
			}	 


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
			if(driver.findElements(By.xpath("//table//td[contains(text(),'Secondary Camera')]//following-sibling::td")).size()>0)
			{	
				WebElement seCamara=driver.findElement(By.xpath("//td[normalize-space()='Secondary Camera']//following::td[1]"));
				String frontCamara=seCamara.getText(); 
				frontCamera=frontCamara.substring(0,2);
				System.out.println("Secondary camara :"+ frontCamara);
			}else
			{
				frontCamera="Nil";
				System.out.println( frontCamera);
			}

			if(driver.findElements(By.xpath("//table//following-sibling::td[contains(text(),'Operating System')]/following-sibling::td")).size()>0)
			{
				WebElement opeSystem=driver.findElement(By. xpath("//td[normalize-space()='Operating System']//following::td[1]"));
				operatingSystem=opeSystem.getText();
				System.out.println("Operating system :"+ operatingSystem);
			}
			else
			{
				operatingSystem="Nil";
				System.out.println( operatingSystem);
			}	

			currentPrice=driver.findElement(By.xpath("//div[@class='pd-price-block']/div")).getText();
			currentPrice=currentPrice.substring(2);
			currentPrice=currentPrice.replace(",","");
			String currprice[]=currentPrice.split("\\.");
			currentPrice=currprice[0];

			System.out.println("Current price :"+ currentPrice);

			if(driver.findElements(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")).size()>0)
			{
				WebElement regular=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")); 
				String regularPric=regular.getText();
				regularPrice=regularPric.substring(1);

				System.out.println("Regular price :"+ regularPrice);
			}
			else
			{
				regularPrice="Nil";
				System.out.println( regularPrice);
			}

			if(driver.findElements(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")).size()>0)
			{
				WebElement you=driver.findElement(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")); 
				String amountSave=you.getText();
				amountSaved=amountSave.substring(1);
				System.out.println("Save :"+ amountSaved);
			}
			else
			{
				amountSaved="Nil";
				System.out.println( amountSaved);
			}
			if(driver.findElements(By.xpath("//table//td[contains(text(),'Processor')]//following-sibling::td")).size()>0)
			{
				WebElement process=driver.findElement(By. xpath("//td[normalize-space()='Processor']//following::td[1]"));
				processor=process.getText();
				System.out.println("process :"+ processor);
			}
			else
			{
				processor="Nil";
				System.out.println( processor);
			}
			details.add(new MobileDetails( brand,regularPrice,currentPrice,amountSaved,rearCamera,frontCamera,ram,rom,operatingSystem,processor));

			File file=new File("D:\\prakash\\excelldata\\MobileDetails.xlsx");
			FileInputStream fis=new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("ProductDetails");
			sheet.createRow(i);	
			sheet.getRow(i).createCell(0).setCellValue(i);
			sheet.getRow(i).createCell(1).setCellValue(details.get(j).getBrand());
			sheet.getRow(i).createCell(2).setCellValue(details.get(j).getRegularPrice());
			sheet.getRow(i).createCell(3).setCellValue(details.get(j).getCurrentPrice());
			sheet.getRow(i).createCell(4).setCellValue(details.get(j).getAmountSaved());	
			sheet.getRow(i).createCell(6).setCellValue(details.get(j).getRearCamera());	//set the value to the particular cell of particular row 
			sheet.getRow(i).createCell(5).setCellValue(details.get(j).getFrontCamera());	
			sheet.getRow(i).createCell(7).setCellValue(details.get(j).getRam());		
			sheet.getRow(i).createCell(8).setCellValue(details.get(j).getRom());	
			sheet.getRow(i).createCell(9).setCellValue(details.get(j).getOperatingSystem());
			sheet.getRow(i).createCell(10).setCellValue(details.get(j).getProcessor());	
			fis.close();
			FileOutputStream fos=new FileOutputStream(file);
			wb.write(fos);
			fos.close();
			wb.close();
			j++;

			driver.navigate().back();
		}
		

	}

	void bestOfBest() throws IOException
	{
		int firstRam = 0,firstRom=0,frontCam=0,rearCam=0,comparePrice=0,price=Integer.parseInt(details.get(0).getCurrentPrice());
		int compareRam = 0,compareRom=0,compareFrontCam=0,compareRearCam=0;
		String mobileName0=null, mobileName = null, mobileName1=null, mobileName2=null, mobileName3=null;
		FileInputStream fis= new FileInputStream("D:\\prakash\\excelldata\\MobileDetails.xlsx");
		XSSFWorkbook xl= new XSSFWorkbook(fis);
		XSSFSheet sheet=xl.getSheetAt(1);
		int j=1;
		for(int i=0;i<details.size();i++)
		{
			comparePrice=Integer.parseInt(details.get(i).getCurrentPrice());
			if(comparePrice <= price)
			{
				price=comparePrice;
			}
			mobileName0=details.get(i).getBrand();
			compareRam =Integer.parseInt(details.get(i).getRam());
			if(firstRam <= compareRam)
			{
				firstRam=compareRam;					
			}
			mobileName=details.get(i).getBrand();
			compareRom =Integer.parseInt(details.get(i).getRom());
			if(firstRom<=compareRom)
			{
				firstRom=compareRom;
			}
			mobileName1=details.get(i).getBrand();
			compareFrontCam=Integer.parseInt(details.get(i).getFrontCamera());
			if(frontCam<=compareFrontCam)
			{
				frontCam=compareFrontCam;
			}
			mobileName2=details.get(i).getBrand();

			compareRearCam=Integer.parseInt(details.get(i).getRearCamera());
			if(rearCam<=compareRearCam)
			{
				rearCam=compareRearCam;
			}
			mobileName3=details.get(i).getBrand();
			sheet.getRow(1);
			j++;
		}

     	sheet.getRow(1).createCell(0).setCellValue("Best in Price");
		sheet.getRow(1).createCell(1).setCellValue(mobileName0);
		sheet.getRow(1).createCell(2).setCellValue(price);

		sheet.getRow(2).createCell(0).setCellValue("Best in RAM");
		sheet.getRow(2).createCell(1).setCellValue(mobileName);
		sheet.getRow(2).createCell(2).setCellValue(firstRam);

		sheet.getRow(3).createCell(0).setCellValue("Best in ROM");
		sheet.getRow(3).createCell(1).setCellValue(mobileName1);
		sheet.getRow(3).createCell(2).setCellValue(firstRom);

		sheet.getRow(4).createCell(0).setCellValue("Best in Front Camera");
		sheet.getRow(4).createCell(1).setCellValue(mobileName2);
		sheet.getRow(4).createCell(2).setCellValue(frontCam);

		sheet.getRow(5).createCell(0).setCellValue("Best in rear Camera");
		sheet.getRow(5).createCell(1).setCellValue(mobileName3);
		sheet.getRow(5).createCell(2).setCellValue(rearCam);
		fis.close();
		FileOutputStream fos= new FileOutputStream("D:\\prakash\\excelldata\\MobileDetails.xlsx");
		xl.write(fos);
		fos.close();
		
		driver.quit();
	}
	


}	





class MobileDetails
{
	String brand,regularPrice,currentPrice,amountSaved,rearCamera,frontCamera,ram,rom,operatingSystem,processor;

	MobileDetails(String  brand,String  regularPrice,String  currentPrice,String  amountSaved,String  rearCamera,String  frontCamera, String  ram, String  rom, String  operatingSystem,String  processor)
	{
		this.brand= brand;
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
	public MobileDetails(String brand2, String currentPrice2, String rearCamara) {
		// TODO Auto-generated constructor stub
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




