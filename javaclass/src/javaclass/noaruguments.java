package javaclass;

public class noaruguments {
	
	int lectureid;
	String lecturename;

	noaruguments(){//no arguments constructor
		lectureid=23;
		lecturename="anbu";
		System.out.println("lecture id is cretated");
		
		
		
	}
	public static void main(String[] args) {
		 noaruguments c=new  noaruguments();
		 System.out.println(c.lecturename);
		
		

	}

}
