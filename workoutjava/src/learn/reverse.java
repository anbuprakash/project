package learn;

import java.util.Scanner;

public class reverse {
	
	
	 static Scanner sc;
	
	public void reversename() {
		sc=new Scanner(System.in);
	      System.out.println("Enter a name :");
	      String num = sc.next();
		char[] a=num.toCharArray();
		for(int i=a.length-1;i>=0;i--) {
			System.out.print(a[i]);
		}
		
	}


	public static void main(String[] args) {
		reverse r=new reverse();
		r.reversename();
	}

}
