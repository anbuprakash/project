package oopsconcept;

abstract class maths{
	 abstract void add();
}

class x extends maths{

	@Override
	void add() {
		System.out.println("adding elements");
		
	}
}
	class y extends maths{

		@Override
		void add() {
			System.out.println("adding two elements");
			
		}
		
	}
	


public class Abstraction {

	public static void main(String[] args) {
		maths m=new y();
		m.add();
		
	

	}

}
