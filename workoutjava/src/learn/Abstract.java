package learn;


 abstract class domain{
	 
	 public abstract void add();
	 public abstract void sub();
	
}
 class damin extends domain{

	@Override
	public void add() {
		System.out.println("v good");
		
		
	}

	@Override
	public void sub() {
		
		System.out.println("x good");
	}
	 
 }




public class Abstract {

	public static void main(String[] args) {
	damin d=new damin();
	d.add();
	d.sub();

	}

}

