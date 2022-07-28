package screenshot;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	public void amazon() throws IOException, Exception {
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
	public void scr() throws AWTException, IOException {
		Robot robot=new Robot();
	Dimension size=	Toolkit.getDefaultToolkit().getScreenSize();
	Rectangle rect=new Rectangle(size);
	BufferedImage img=	robot.createScreenCapture(rect);
	File file=new File(".//Screenshot//robo.png");
	ImageIO.write(img, "png", file);
	}
	
	


	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",".//driver//chromedriver.exe");
		Google g=new Google();
		g.amazon();
		g.s("go");
		g.scr();
//		g.write();
//		g.read();
		

	}

}
