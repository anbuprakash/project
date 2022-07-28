package rwconcept;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class Readexcel {

	public static void main(String[] args) throws Exception  {
		
		
		
		File file=new File("D:\\prakash\\excelldata\\Test.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		String s=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(s);
		
workbook.close();
fis.close();
	}

}


