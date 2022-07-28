package javaclass;

public class calculate
{
	int a=12;
	int b=16;
     int result1;
	int result2;
	int result3;
    public void evaluate()
    {
	result1=a+b;//sop("value is"+result1);
	 result2=a-b;
	 result3=a*b;
    }
	public static void main(String[] args)
	{
		calculate obj=new calculate();
		obj.evaluate();
		System.out.println("value is"+obj.result1+obj.result2+obj.result3);
				// TODO Auto-generated method stub

	}

}
