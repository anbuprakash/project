package displas;

import java.util.Scanner;

public class Digitcount {
	

	public static void main(String[] args) {
		Scanner  obj = new Scanner(System.in);
	      int count = 0;
	      System.out.println("Enter a number :");
	      int num = obj.nextInt(); 
	 
	      while(num!=0){
	         num = num/10;
	         count++;
	      }
	      System.out.println("the number of digit is : "+count);
	   }

}
