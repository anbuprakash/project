package com.leo.material;

class parant{
	int a=10;
	 parant() {
		System.out.println("parant class created"+a);
	}
}
class child extends parant {
	child() {
		System.out.println("child class creted");
	}
	}



public class sub {

	public static void main(String[] args) {
		child g=new child();
		
		

	}

}
