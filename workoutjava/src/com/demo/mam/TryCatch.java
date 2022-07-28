package com.demo.mam;



public class TryCatch {

	public static void main(String[] args) {
		v d=new v();
		d.add();

	}

}
interface A{
	void add();
}
class v implements A{

	@Override
	public void add() {
		System.out.println("good");
	}

}



