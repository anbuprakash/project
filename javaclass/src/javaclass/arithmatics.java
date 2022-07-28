package javaclass;

public class arithmatics 
{
	int a=5;
	int b=5;
	 int r1=a+b;
	int r2=a-b;
	int r3=a*b;
	
	public void values()
	{
		System.out.println("the value is"+r1);
		System.out.println("the value is"+r2);
		System.out.println("the value is"+r3);
	
	}

	public static void main(String[] args)
	{
		 arithmatics arithmatics=new arithmatics();
		 arithmatics.values();
	}

}
