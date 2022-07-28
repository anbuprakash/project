package com.leo.material;
 class s{
	 int j=123445;
void add() {
	System.out.println("this is default"+j);
	
}
void add(int a) {
	System.out.println("this is int constructor"+j);
}
void add(String name) {
	System.out.println("this is string "+j);
}
 
 }

public class wait {

	public static void main(String[] args) {
		s n=new s();
		n.add();
		n.add(123);
		n.add("prakash");
		

	}

}
