package com.demo.mam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemDateTime {

	public static void main(String[] args) {
		  LocalDate myObj = LocalDate.now();
		    System.out.println(myObj);
		    LocalDateTime myDateObj = LocalDateTime.now();
		    System.out.println("Before formatting: " + myDateObj);

		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		    String formattedDate = myDateObj.format(myFormatObj);
		    System.out.println("After formatting: " + formattedDate);


	}

}
