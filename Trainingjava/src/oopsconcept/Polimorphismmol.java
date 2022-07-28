package oopsconcept;

public class Polimorphismmol {
	String add() {
		System.out.println("no arg method");
		return "good";
	}

	void add(int a) {
		System.out.println("parameterised method");
	}
	void add(int a,String name) {
		System.out.println("String method");
	}
	public static void main(String[] args) {
		Polimorphismmol obj=new  Polimorphismmol();
		 String c=obj.add();
		 System.out.println(c);
		 obj.add(10);
		 obj.add(25, "prakash");

	}


}
