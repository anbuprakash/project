package learn;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		Even e=new Even();
//		  e.checkPrime();
		  Add x=new Add();
//		  x.cv();
		  x.cc();
		  
		  
		

	}

}
class Even
{
	Scanner scan=new Scanner(System.in);
    
		 void checkPrime(){
			 System.out.println("enter no");
			 int n=scan.nextInt();
			int i,m=0,flag=0;
			m=n/2;
			if(n==0||n==1)
			{
				System.out.println("is not prime");
			}
			else {
				for(i=2;i<=m;i++)
				{
					if(n%i==0) {
						System.out.println("is not prime");
						flag=1;
						break;
						
					}
				}
				if(flag==0) {
					System.out.println("is prime");
				}
			}
			}
			
}
class Add
{
	Scanner scan=new Scanner(System.in);
	public void cv()
	{
		System.out.println("enter num");
		long n=scan.nextLong();
		int count=0;
		while(n!=0)
		{
			n=n/10;
			count++;
		}
		System.out.println(count);
	}
	
	void cc()
	{
		int num=1234567;
		int fd=0;
		int ld=0;
		ld=num%10;
		System.out.println(ld);
		while(num!=0) {
			fd=num%10;
			num/=10;
		}
		System.out.println(fd);
		}
	    }

	


