package stefdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sample.cucumbersample.MobileDetails;

public class SathyaMobileDefinition 
{
	public  static Logger logger=null;
	public static WebDriver driver;
	public Properties prop;
	public ExtentReports extent;
	ExtentTest test;
	public ExtentHtmlReporter htmlReporter;



	public SathyaMobileDefinition()
	{

		prop =  new Properties(); //get properties
		try 
		{
			InputStream input = new	 FileInputStream(".//properties//confi.properties");
			prop.load(input);

		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
	}


	@Given("user navigates to the website sathya.in")
	public void user_navigates_to_the_website_sathya_in() 
	{

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + ".//extentconfig.html");

		// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);



		logger=Logger.getLogger(SathyaMobileDefinition.class);
		PropertyConfigurator.configure(".//properties//log4j.properties");
		System.setProperty("webdriver.chrome.driver", ".//chrome//chromedriver.exe");  //set property

		logger.info("Launch the ChromeBrowser");  //chromeBrowser initialize
		driver=new ChromeDriver();
		logger.info("Launch the url");
		driver.get(prop.getProperty("url"));  //get url
		driver.manage().window().maximize();  //maximize window

		test = extent.createTest("To verify Sathya Mobile");  //extent report
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url"));

		extent.flush();


	}
	ArrayList<MobileDetails> details=new ArrayList<MobileDetails>(); 

	String brand,regularPrice,currentPrice,amountSaved,rearCamera = null,frontCamera = null,ram,rom,operatingSystem,processor;
	int j=0;

	//PageFactory

	@FindBy(xpath="//a[@href='/electronics' and @aria-expanded='false']") 
	public static WebElement electronics;
	@FindBy(xpath="//aside[@id='content-left']/div[1]/nav/a[2]") 
	private WebElement Mobile;
	@FindBy(xpath="//select[@id='artlist-action-pagesize']")
	private WebElement Page;
	@FindBy(xpath="//select[@id='artlist-action-pagesize']//option[4]")
	private WebElement Page1;
	@FindBy(xpath="//a[contains(text(),'Features')]") 
	private WebElement Features;
	@FindBy(xpath="//td[normalize-space()='Brand']//following::td[1]") 
	private WebElement Brand;
	@FindBy(xpath="//td[normalize-space()='RAM Capacity']//following::td[1]")
	private WebElement RamCapacity;
	@FindBy(xpath="//td[normalize-space()='ROM Capacity']//following::td[1]")
	private WebElement RomCapacity;
	@FindBy(xpath="//table//td[contains(text(),'Primary Camera')]//following-sibling::td") 
	private WebElement PrimaryCamara;
	@FindBy(xpath="//td[normalize-space()='Secondary Camera']//following::td[1]")
	private WebElement SecondaryCamara;
	@FindBy(xpath="//td[normalize-space()='Operating System']//following::td[1]")
	private WebElement OperatingSystem;
	@FindBy(xpath="//div[@class='pd-price-block']/div") 
	private WebElement CurrentPrice;
	@FindBy(xpath="//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")
	private WebElement RegularPrice;
	@FindBy(xpath="//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")
	private WebElement YouSave;
	@FindBy(xpath="//td[normalize-space()='Processor']//following::td[1]")
	private WebElement Processor;
	@FindBy(xpath="//div[@id='pd-tabs-2']")
	private WebElement Text;







	@When("user is get the {int} mobile features")
	public void user_is_get_the_mobile_features(Integer int1) throws IOException {
		PageFactory.initElements(driver,this);
		//logger=Logger.getLogger(SathyaHomePage.class);

		logger=Logger.getLogger(SathyaMobileDefinition.class);


		logger.info("Sathya Home page Open");
		electronics.click();

		logger.info("Enter Mobile Page");
		Mobile.click();

		Page.click();

		logger.info("Change 48 Mobile Per page");
		Page1.click();
		logger.info("Get Features in all mobile ");

		for(int times=1;times<=5;times++)   //iterate 48 mobile
		{


			driver.findElement(By.xpath("//article["+times+"]//a[@class='art-picture img-center-container']")).click();
			Features.click();

			TakesScreenshot scrShot =((TakesScreenshot) driver);  //screenshot
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File(".//Screenshot"+".//Screenshot.png");
			FileHandler.copy(SrcFile, DestFile);


			brand=Brand.getText();   //get brand

			String b="RAM Capacity";    //get ram
			String value=Text.getText();
			if(value.contains(b)) 
			{
				ram=RamCapacity.getText();
				ram=ram.replace(" GB", "");
			}
			else
			{
				ram="Nil";

			}

			String b1="ROM Capacity";   //get rom
			String value1=Text.getText();

			if(value1.contains(b1)) 
			{
				rom=RomCapacity.getText();
				rom= rom.replace(" GB", "");
			}
			else
			{
				rom="Nil";

			}

			String b2="Primary Camera";   //get primaryCamera
			String value2=Text.getText();

			if(value2.contains(b2)) 
			{
				rearCamera=PrimaryCamara.getText();
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
			rearCamera=Integer.toString(camera);      //get rearCamera
			rearCamera=rearCamera.replaceAll(" MP","");

			String b3="Secondary Camera";
			String value3=Text.getText();

			if(value3.contains(b3)) 
			{
				frontCamera=SecondaryCamara.getText();
				frontCamera=frontCamera.substring(0,2);
			}
			else
			{
				frontCamera="Nil";

			}

			String b4="Operating System";  //get operatingSystem
			String value4=Text.getText();

			if(value4.contains(b4)) 
			{
				operatingSystem=OperatingSystem.getText();
			}
			else
			{
				operatingSystem="Nil";

			}

			currentPrice=CurrentPrice.getText();   //get currentPrice
			currentPrice=currentPrice.substring(2);
			currentPrice=currentPrice.replace(",","");
			String currprice[]=currentPrice.split("\\.");
			currentPrice=currprice[0];

			//get regular price
			if(driver.findElements(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'Regular:')]/following-sibling::span")).size()>0)
			{
				regularPrice=RegularPrice.getText();
				regularPrice=regularPrice.substring(1);

			}
			else
			{
				regularPrice="Nil";

			}

			//get amountSaved

			if(driver.findElements(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")).size()>0)
			{
				amountSaved=YouSave.getText();
				amountSaved=amountSaved.substring(1);
			}
			else
			{
				amountSaved="Nil";
			}

			String b7="Processor";     //get processor
			String value7=Text.getText();

			if(value7.contains(b7)) 
			{
				processor=Processor.getText();
			}
			else
			{
				processor="Nil";
			}

			details.add(new MobileDetails( brand,regularPrice,currentPrice,amountSaved,rearCamera,frontCamera,ram,rom,operatingSystem,processor));


			driver.navigate().back();    //back to mobile page
		}


		//	throw new io.cucumber.java.PendingException();
	}

	@Then("write features in excel sheet")
	public void write_features_in_excel_sheet() throws IOException 
	{
		logger.info(" Best Features Write In Excel");

		for(int i=1;i<=5;i++)  //write data excel
		{
			File file=new File(".//Data//MobileDetails.xlsx");  //get file
			FileInputStream fis=new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("ProductDetails");  //get sheet
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

		}
		int firstRam = 0,firstRom=0,frontCam=0,rearCam=0,comparePrice=0,price=Integer.parseInt(details.get(0).getCurrentPrice());
		int compareRam = 0,compareRom=0,compareFrontCam=0,compareRearCam=0;
		String mobileName0=null, mobileName = null, mobileName1=null, mobileName2=null, mobileName3=null;

		for(int i=0;i<details.size();i++)   //compare & get best price
		{
			if(details.get(i).getCurrentPrice().contains("Nil"))
			{
				price=0;
			}
			else
			{
				comparePrice=Integer.parseInt(details.get(i).getCurrentPrice());

				if(comparePrice <= price)
				{
					price=comparePrice;
					mobileName0=details.get(i).getBrand();
				}
			}
			if(details.get(i).getRam().contains("Nil"))  //compare & get best ram
			{
				firstRam=0;
			}
			else
			{
				compareRam =Integer.parseInt(details.get(i).getRam());
				if(firstRam <= compareRam)
				{
					firstRam=compareRam;	
					mobileName=details.get(i).getBrand();
				}

			}
			if(details.get(i).getRom().contains("Nil"))  // compare & get best rom
			{
				firstRom=0;
			}
			else
			{
				compareRom =Integer.parseInt(details.get(i).getRom());
				if(firstRom<=compareRom)
				{
					firstRom=compareRom;
					mobileName1=details.get(i).getBrand();
				}
			}
			if(details.get(i).getFrontCamera().contains("Nil"))  //compare & get best FrontCamera
			{
				frontCam=0;
			}
			else
			{
				compareFrontCam=Integer.parseInt(details.get(i).getFrontCamera());
				if(frontCam<=compareFrontCam)
				{
					frontCam=compareFrontCam;
					mobileName2=details.get(i).getBrand();
				}
			}

			if(details.get(i).getRearCamera().contains("Nil"))     //compare & get best RearCamera
			{
				rearCam=0;
			}
			else
			{
				compareRearCam=Integer.parseInt(details.get(i).getRearCamera());
				if(rearCam<=compareRearCam)
				{
					rearCam=compareRearCam;
					mobileName3=details.get(i).getBrand();
				}
			}
		}
		System.out.println(price+"\t"+mobileName0+"\n"+firstRam+"\t"+mobileName+"\n"+firstRom+"\t"+mobileName1+"\n"+frontCam+"\t"+mobileName2+"\n"+rearCam+"\t"+mobileName3);
		FileInputStream fis = new FileInputStream(".//Data//MobileDetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);      // best mobile write excel
		sheet.getRow(1).createCell(1).setCellValue(mobileName0);
		sheet.getRow(1).createCell(2).setCellValue(price);
		sheet.getRow(2).createCell(1).setCellValue(mobileName);
		sheet.getRow(2).createCell(2).setCellValue(firstRam);
		sheet.getRow(3).createCell(1).setCellValue(mobileName1);
		sheet.getRow(3).createCell(2).setCellValue(firstRom);
		sheet.getRow(4).createCell(1).setCellValue(mobileName2);
		sheet.getRow(4).createCell(2).setCellValue(frontCam);
		sheet.getRow(5).createCell(1).setCellValue(mobileName3);
		sheet.getRow(5).createCell(2).setCellValue(rearCam);
		fis.close();
		FileOutputStream fos = new FileOutputStream(".//Data//MobileDetails.xlsx");
		workbook.write(fos);
		fos.close();
		System.out.print("xl written");
		workbook.close();

	}
}


