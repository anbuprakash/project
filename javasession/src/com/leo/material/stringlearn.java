package com.leo.material;

public class stringlearn {

	public static void main(String[] args) {
		String name="anbu";
		System.out.println(name);
		
		System.out.println(name.length());
		System.out.println(name.equals("anbarasu"));
		System.out.println(name.endsWith("anbu"));
		System.out.println(name.compareToIgnoreCase("anbu"));
		System.out.println(name.contains("a"));
        System.out.println(name.codePointAt(2));
	}

}
