package displas;

public class Numberspattern {

	public static void main(String[] args)   {  
		int a, b, c, rows=5;  
		for(a=1;a< rows+1 ;a++) 
		{  

			for(b=a; b < rows+1 ;b++) 
			{  

				System.out.print(b + " ");  
			}  

			for(c=1; c < a; c++)  
			{  

				System.out.print(c + " ");  
			}  

			System.out.println();  
		}  

	}  
}


