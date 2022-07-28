package com.tradeviv.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserCredentials {

	public static void main(String[] args) throws IOException {

		Name name=new Name();
		name.write();
		name.excel();


	}

}
class User{

	String vendor,company;
	String phoneNumber;

	public User(String vendor,String company,String phoneNumber) {
		this.vendor=vendor;
		this.company=company;
		this.phoneNumber=phoneNumber;

	}

	public String getvendor() {
		return vendor;
	}
	public String getcompany() {
		return company;
	}
	public String getphoneNumber() {
		return phoneNumber;
	}


}

class Name {

	ArrayList<User> array=new ArrayList<User>();

	String vendor;
	String company;
	String phoneNumber;

	
	    

public void write() {
	for(int i=401;i<=450;i++) {
		vendor="vendor";
		System.out.println("vendor");
		company="company"+i;
		System.out.println("company"+i);

		phoneNumber="8777623"+i;
		System.out.println("8777623"+i);


		array.add(new User(vendor,company,phoneNumber));
	}
}
int j=0;
public void excel() throws IOException {
	for(int i=1;i<=50;i++) {
		File file=new File("D:\\prakash\\excelldata\\user.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		sheet.createRow(i);	
		sheet.getRow(i).createCell(0).setCellValue(i);
		sheet.getRow(i).createCell(1).setCellValue(array.get(j).getvendor());
		sheet.getRow(i).createCell(2).setCellValue(array.get(j).getcompany());
		sheet.getRow(i).createCell(3).setCellValue(array.get(j).getphoneNumber());
		fis.close();
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		fos.close();
		wb.close();
		j++;
	}
}



}
