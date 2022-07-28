package learn;

class A{
	
	private  String name;
	private int num;
	
	public String getname() {
	return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getnum() {
	return num;
	}
	public void setNum(int num) {
		this.num=num;
	}
}


public class Encaps {

	public static void main(String[] args) {
		A a= new A();
		a.setName("prakash");
		a.setNum(25);
		System.out.println(a.getname()+a.getnum());
	

	}

}
