package demo;

 abstract class  car{
	  abstract void driven(); 
		  }
 class honda extends car{
	public  void driven() {
		 System.out.println("working good");
	 }
	 
 }

public class exabstract {

	public static void main(String[] args) {
		honda c=new honda();
		c.driven();
		

	}

}
