package string;

import java.util.Random;

public class RandomNumber 
{
	public static void main(String[] args) 
	{
		Random rand = new Random();

		int num1, num2, num3,num4;
		for(int i=0;i<=10;i++) 
		{
			num1 = rand.nextInt (900) + 100;
			num2 = rand.nextInt (643) + 100;
			num3 = rand.nextInt (9000) + 1000;
            num4=rand.nextInt(30)+10;
			System.out.println(num1+"-"+num2+"-"+num3+"-"+num4);
		}

	}
}
