package com.leo.material;
class x{
	int a=10;
	int b=10;
	int c=a+b;	
	public void box() {
		System.out.println("my name is prakash"+a);
	}
}
class y extends x {
	public String box1() {
		System.out.println("mi brother is selva");
		return "hi";
	}
}
class j extends y{
	public void box3(){
		System.out.println("my brother name is anbu");
	}
}

public class inheritance {

	public static void main(String[] args) {
	j v=new j();
	v.box();
	String g=v.box1();
	System.out.println(g);
	v.box3();
	

	}

}
