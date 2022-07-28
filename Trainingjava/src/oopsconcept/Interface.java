package oopsconcept;

interface a{
	void show();
}
class b implements a{

	@Override
	public void show() {
		System.out.println("given value");
		
	}
	class c implements a{

		@Override
		public void show() {
System.out.println("given two value");			
		}
		
	}
	
}

public class Interface {
	

	public static void main(String[] args) {
		 a d=new b();
          d.show();
	}

}
