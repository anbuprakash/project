package constructor;

public class Noargument {  //constructor name should be same method name
	int lectureid;
	String lecturename;

	Noargument(){  //no arguments constructor
		lectureid=23;
		lecturename="anbu";
		System.out.println("lecture id is cretated");
	}
		
	public static void main(String[] args) {
		Noargument c=new  Noargument();
		 System.out.println(c.lecturename);
		

	}

}
