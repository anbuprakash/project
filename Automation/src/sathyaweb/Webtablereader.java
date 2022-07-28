package sathyaweb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtablereader {

	public static void main(String[] args) throws IOException {
		File file=new File("D:\\prakash\\excelldata\\WTest.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("gold rate");
		
		System.setProperty("webdriver.chrome.driver", "D:\\browser\\ChromeDriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.livechennai.com/gold_silverrate.asp");
		
		driver.manage().window().maximize();
		WebElement table=driver.findElement(By.xpath("(//table[@class='table-price'])[2]"));
		List<WebElement> totalrows=table.findElements(By.tagName("tr"));
		for(int row=0;row<totalrows.size();row++) {
			XSSFRow rowvalue=sh.createRow(row);
			List<WebElement> totalcol=totalrows.get(row).findElements(By.tagName("td"));
			for(int col=0;col<totalcol.size();col++) {
				String cellvalue=totalcol.get(col).getText();
				System.out.print(cellvalue+"\t");
				rowvalue.createCell(col).setCellValue(cellvalue);
			}
			System.out.println();
		}
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);

	}

}
