package com.demo.mam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class FibRecursion {
	public void iter() {
		HashMap<Integer,String> hm=new HashMap<Integer,String>();

		hm.put(5, "a");
		hm.put(4,"b" );
		Iterator<Map.Entry<Integer, String>> i=hm.entrySet().iterator();
		while(i.hasNext()) {
			Map.Entry<Integer, String> c=i.next();
			System.out.println(c.getValue()+" "+c.getKey());
		}
	}

	public static void main(String[] args) {
		FibRecursion f=new FibRecursion();
		f.iter();
		Scanner s=new Scanner(System.in);
		System.out.println("enter sentence");
		String name=s.nextLine();
		char[] c=name.toCharArray();
		HashMap<Integer, Character> hm=new HashMap<Integer,Character>();
		for(int i=0;i<name.length();i++) {
			hm.put(i,c[i]);
		}
		System.out.println(hm);
		System.out.println(hm.size());
	}

}

