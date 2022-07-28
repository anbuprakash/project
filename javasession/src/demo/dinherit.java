package demo;

class a{
	int a=243;
	int b=543;
	int c=a+b;
	public void add() {
		System.out.println("the value is"+c);
	}
}

class b extends a{
	public void add1() {
		System.out.println("total value is"+a);
	}
}

class c extends b{
	public void add2() {
		System.out.println("the add value is"+b);
	}	
}
public class dinherit {
	public static void main(String[] args) {
		c d=new c();
		d.add();
		d.add1();
		d.add2();


}
}