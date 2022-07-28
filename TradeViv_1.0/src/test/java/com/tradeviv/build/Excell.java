package com.tradeviv.build;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class Excell extends TradevivBase {

	public Excell() 
	{
		PageFactory.initElements(driver, this);
		logger=Logger.getLogger(Excell.class);
	}
	public void table() throws Exception  //data write in  excel
	{

		File file=new File(".//TestData//approve vendor.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(1);

		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=4;j++)
			{
				String data=driver.findElement(By.xpath("//table[@id='geniustable']//tr["+i+"]//td["+j+"]")).getText();
				sheet.getRow(i).createCell(j).setCellValue(data);	
			}
		}
		fis.close();
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
		wb.close();
	}
	public void m_Body() throws Exception //vendors list write excell
	{

		File file=new File(".//TestData//approve vendor.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(2);

		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=4;j++)
			{
				String data=driver.findElement(By.xpath("//table[@id='geniustable']//tr["+i+"]//td["+j+"]")).getText();
				sheet.getRow(i).createCell(j).setCellValue(data);	
			}
		}
		fis.close();
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
		wb.close();
	}
}
