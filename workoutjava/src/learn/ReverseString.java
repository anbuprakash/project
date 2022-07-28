package learn;

public class ReverseString {

	public static void main(String[] args) {
		 String input = "GeeksForGeeks";
		 
	        // convert String to character array
	        // by using toCharArray
	        char[] try1 = input.toCharArray();
	 
	        for (int i = try1.length - 1; i >= 0; i--)
	            System.out.print(try1[i]);
	        
	        int i,fact=1,n=7;
	        for(i=1;i<=n;i++) {
	        	fact=fact*i;
	        }
	        System.out.println(fact);
	        
	    }
	

	}


