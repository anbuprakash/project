package javaclass;

public class samplepara {
	int a;
	int b;
	samplepara(int num1,int num2){//parameterized constructor
		a=num1;
		b=num2;
	}
	public void calculate() {
		System.out.println("the numbers are"+a+b);
	}

	public static void main(String[] args) {
		
		samplepara samplepara=new samplepara(65,78);
		samplepara.calculate();
		
		samplepara samplepara1=new samplepara(43,54);
		samplepara1.calculate();
		

	}

}
