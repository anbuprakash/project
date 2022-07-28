package com.leo.material;

public class Animal {
	String animalname;
	String animalnam;
	
	Animal(String name,String nam){
		animalname=name;
		animalnam=nam;
	}
	public void proceed() {
		System.out.println(animalname+animalnam);
	}

	public static void main(String[] args) {
		Animal animal=new Animal("dog","duck");
	animal.proceed();
	
	Animal animal1=new Animal("pig","cow");
	animal1.proceed();
	

				
		// TODO Auto-generated method stub

	}

}
