package screenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Google {

	static WebDriver driver;
	public void amazon() throws IOException {
		driver=new ChromeDriver();
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
	}
	public void s(String name) throws IOException {
	TakesScreenshot scrshot=((TakesScreenshot)driver);
	File source=scrshot.getScreenshotAs(OutputType.FILE);
	File target=new File(".//Screenshot"+".//"+name+".png");
	FileHandler.copy(source, target);
	
//	FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("C:/selenium/error.png"));
		
	}
	public void write() throws IOException {
	String name="selvapathy";
	File file=new File("D:\\prakash\\Book1.xlsx");
	FileInputStream fis=new FileInputStream(file);
	XSSFWorkbook w=new XSSFWorkbook(fis);
	XSSFSheet sheet=w.getSheetAt(0);
	sheet.createRow(0).createCell(0).setCellValue(name);
	FileOutputStream fos=new FileOutputStream("D:\\prakash\\Book1.xlsx");
	w.write(fos);
	w.close();
	fos.close();
	fis.close();
	}
	public void read() throws IOException {
		File file=new File("D:\\prakash\\Book1.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
	XSSFRichTextString value=sheet.getRow(0).getCell(0).getRichStringCellValue();
		System.out.println(value);
	}
	


	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\selvapathy\\Desktop\\javaclass\\Automation\\ChromeDriver\\chromedriver.exe");
		Google g=new Google();
		g.amazon();
		g.s("go");
		g.write();
		g.read();
		

	}

}
