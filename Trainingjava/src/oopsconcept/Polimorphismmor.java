package oopsconcept;


	class dell{
		public void display() {
			System.out.println("doing good");
		}
	}
	class sony {
		public void display() {
			System.out.println("doing bad");
		}
	}
	class wipro {
		public void display() {
			System.out.println("not bad");
		}
	}


	public class Polimorphismmor {

		public static void main(String[] args) {
			sony b=new sony();
			wipro c=new wipro();
			c.display();
			b.display();

}
	}
