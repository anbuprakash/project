package displas;

public class Demostring3 {

	public static void main(String[] args) {
		 String str = "ADM";
	       
	       int pos = 0;
	       String replace = "welcome to accelerated development machines";
	       String res = str.substring(0,pos) + replace+ str.substring(pos+3);
	       System.out.println(" after replacing a word: "+res);
	       
	       String str3=new String("Welcome to Accelerated Development Machines");
			
			System.out.println(str3.toLowerCase());
			
			System.out.println(res.equalsIgnoreCase(str3));
			

	}

}
