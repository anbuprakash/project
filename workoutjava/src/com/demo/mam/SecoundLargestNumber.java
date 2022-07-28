package com.demo.mam;

import java.util.Arrays;

public class SecoundLargestNumber {
	
	public int secoundNum(int []a,int total) {
		Arrays.sort(a);
		return a[total-1];
	}
	public void rev() {
		String name="prakash";
		char []arr=name.toCharArray();
		for(int i=name.length()-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
	}
	public void sv() {
		String name="anbarasu";
		String rev="";
		for(int i=name.length()-1;i>=0;i--) {
			rev=rev+name.charAt(i);
		}
		System.out.print("\n"+rev);
	}
	public void svv() {
		StringBuffer buff=new StringBuffer("super");
		System.out.println("\n"+buff.reverse());
		StringBuilder build=new StringBuilder("bad");
		System.out.println("\n"+build.reverse());
	}
	public void prime() {
		int i,m=0,n=5,flag = 0;
		m=n/2;
		if(n==0||n==1) {
			System.out.println("is not prime");
		}
		else {
			for(i=2;i<=m;i++) {
				if(n%i==0) {
					System.out.println("is not prime");
					flag=1;
					break;
					
				}
			}
			if(flag==0) {
				System.out.println(n+" : is prime");
			}
		}
	}
	public void palin() {
	int fact=1,i,n=5;
	for(i=1;i<=n;i++) {
		fact=fact*i;
	}
	System.out.println(fact);
	}
	public static void main(String[] args) {
		SecoundLargestNumber s=new SecoundLargestNumber();
		int a[]= {4,6,8,10};
		System.out.println(s.secoundNum(a, 4));
		s.rev();
		s.sv();
		s.svv();
		s.prime();
		s.palin();
	}
	

}
