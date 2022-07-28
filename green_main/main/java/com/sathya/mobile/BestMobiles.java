package com.sathya.mobile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BestMobiles extends HomePage {
	
	public void bestOfBest() throws IOException
	{
		int firstRam = 0,firstRom=0,frontCam=0,rearCam=0,comparePrice=0,price=Integer.parseInt(details.get(0).getCurrentPrice());
		int compareRam = 0,compareRom=0,compareFrontCam=0,compareRearCam=0;
		String mobileName0=null, mobileName = null, mobileName1=null, mobileName2=null, mobileName3=null;
		FileInputStream fis= new FileInputStream(".//TestData.xlsx//MobileDetails.xlsx");
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
		FileOutputStream fos= new FileOutputStream(".//TestData.xlsx//MobileDetails.xlsx");
		xl.write(fos);
		fos.close();
	}
}


