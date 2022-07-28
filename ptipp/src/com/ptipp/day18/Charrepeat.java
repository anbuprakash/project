package com.ptipp.day18;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Charrepeat {

	public static void main(String[] args) {
		ArrayList<String> a=new ArrayList<String>();
		a.add("anbu");
		a.add("selva");
		a.add("anbu");
		System.out.println(a);
		LinkedHashSet<String> s=new LinkedHashSet<>(a);
		System.out.println(s);
	

	}

}
