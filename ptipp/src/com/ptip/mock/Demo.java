package com.ptip.mock;

public class Demo {
	public void reverse() {
		String name="anbarasu";
		char[] rev=name.toCharArray();
		for(int i=rev.length-1;i>=0;i--)
		{
			System.out.print(rev[i]);
		}
	
	}

	public static void main(String[] args) {
		
		Demo d=new Demo();
		d.reverse();
	}

}
