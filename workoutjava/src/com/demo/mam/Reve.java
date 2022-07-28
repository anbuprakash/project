package com.demo.mam;


public class Reve {

	public static void main(String[] args) {
		String name="prakash";
		String reverse="";
		for(int i=name.length()-1;i>=0;i--) {
			reverse=reverse+name.charAt(i);
		}
		System.out.println(reverse);
		
		StringBuffer b=new StringBuffer(name);
		System.out.println(b.reverse());
		
	}

}
