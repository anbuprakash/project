package learn;

import java.util.Scanner;

public class Chumma {
	
	static Scanner sc=new Scanner(System.in);
	int arr[]= {1,2,3,4,4};
	public void vetti() {
	
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
	}

	public static void main(String[] args) {
		Chumma c=new Chumma();
		c.vetti();

	}

}
