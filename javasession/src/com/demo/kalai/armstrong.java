package com.demo.kalai;

import java.util.Scanner;

public class armstrong {

		public static void main(String[] args) 
		{
			Pgm p=new Pgm();
		//	p.factorial();
		//	p.fibonaci();
		//	p.numberCount();
		//	p.primeNumber();
		//	p.armStrong();
		//	p.al();
			p.wordCount();
		}
}
		class Pgm{
//			int i=1,a,arm,n,temp;
//			System.out.println("Armstrong numbers between 1 to 500 are");
//			while(i<1000)
//			{
//			n=i;
//			arm=0;
//			while(n>0)
//			{
//				a=n%10;
//				arm=arm+(a*a*a);
//				n=n/10;
//			}
//			if(arm==i)
//				System.out.println(i);
//			i++;
//			}
			//fiobonaci
			public void fibonaci()
			{
				int n1=0,n2=1,i,n3,count= 10;
				System.out.print(n1+" "+n2);
			
				for(i=2;i<count;i++)
				{
					n3=n1+n2;
					System.out.print(" "+n3);
					n1=n2;
					n2=n3;
				}
			}

			public void factorial()
			{
				int i,fact=1;
				Scanner s=new Scanner(System.in);
				System.out.println("enter number");
			int n=s.nextInt();
				for(i=1;i<=n;i++)
				{
					fact=fact*i;						
				}
				System.out.println(fact);
				
			}
			public void numberCount()
			{
				Scanner s=new Scanner(System.in);
				System.out.println("enter number");
			int number=s.nextInt();
				int count=0;
			//	int number=123456345;
				while(number!=0)
				{
					number=number/10;
					count++;
				}
				System.out.println(count);
			}
			public void primeNumber()
			{
				int i,m=0,flag=0;
				int n=4;
				m=n/2;
				if(n==1||n==0)
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
					if(flag==0)
					{
						System.out.println("is prime");
					}
				}
			}
			public void armStrong()
			{
				int a,arm=0,n,temp;
				n=5;
				temp=n;
				for( ;n!=0;n/=10 )
				{
					a=n%10;
					arm=arm+(a*a*a);
				}
				if(arm==temp)
				System.out.println(temp+" is a armstrong number ");
				else
				System.out.println(temp+" is not a armstrong number ");
			        
			}
		
			
			public void palinDrome()
			{
				Scanner sc = new Scanner(System.in);  
			       System.out.println("Enter the number: ");  
			       int num=sc.nextInt();
			       int r,sum=0;
			       int temp=num;    
			       while(num>0)
			       {    
			       r=num%10;    
			       sum=(sum*10)+r;    
			       num=num/10;    
			       }    
			        if(temp==sum)    
			        System.out.println("The entered number "+temp+" is a palindrome number ");    
			        else    
			        System.out.println("The entered number "+temp+" is not a palindrome");    
			  
			}
			public void al()
			{
				char c;
				for(c='A';c<='Z';c++)
				System.out.print(c+" ");
					
				}
			public void wordCount()
			{
				   String sentence = "hi prakash";  
			        int wordCount = 0;  
			          
			        for(int i = 0; i < sentence.length()-1; i++) {  
			            if(sentence.charAt(i) == ' ' && Character.isLetter(sentence.charAt(i+1)) && (i > 0)) {  
			                wordCount++;  
			            }  
			        }  
			        
			        wordCount++;  
			        System.out.println("Total number of words in the given string: " + wordCount);  
			     
			}
			
		
		
			}

	



