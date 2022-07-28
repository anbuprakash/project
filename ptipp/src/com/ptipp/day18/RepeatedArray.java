package com.ptipp.day18;

import java.util.ArrayList;
import java.util.Scanner;


public class RepeatedArray {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter number of value add");
		int n=s.nextInt();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=1;i<=n;i++) {
			arr.add(i);
		}
		System.out.println(arr);
		System.out.println(arr.remove(4));
		System.out.println(arr);
		s.close();
	}
}



