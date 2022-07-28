package rwconcept;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellReadWrite {

	public static void main(String[] args) throws IOException {
		ReadWrite rw=new ReadWrite();
		rw.write("anbu");
		rw.read();
		

	}

}

class ReadWrite{
	public void write(String data) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\prakash\\excelldata\\SampleTest.xlsx");
	
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(data);
		fis.close();
		FileOutputStream fos = new FileOutputStream("D:\\prakash\\excelldata\\SampleTest.xlsx");
		workbook.write(fos);
		System.out.println("Written Data: "+ data);
		fos.close();
		workbook.close();
	}
	public void read() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\prakash\\excelldata\\SampleTest.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println("Read data: "+cell.getStringCellValue());
		fis.close();
		workbook.close();
		
	}
	
}