package demo;

class dell{
	public void display() {
		System.out.println("doing good");
	}
}
class sony extends dell{
	public void display() {
		System.out.println("doing bad");
	}
}
class wipro extends sony{
	public void display() {
		System.out.println("not bad");
	}
}


public class polimorphismmor {

	public static void main(String[] args) {
		sony b=new sony();
		wipro c=new wipro();
		c.display();
		b.display();
		

	}

}
