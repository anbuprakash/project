package javaclass;

public class parameter {
	String friendname1;
	String friendname2;
	String friendname3;
	parameter(String name1,String name2,String name3){
		//Parameterized constructor
		friendname1=name1;
		friendname2=name2;
		friendname3=name3;
	}
		public void myfriends() {
			System.out.println("my friends are"+friendname1+friendname2+friendname3);
			
		}
		
	

	public static void main(String[] args) {
		parameter parameter=new parameter("selvapathy","dinesh","anbarasu");
		parameter.myfriends();
		
		parameter parameter1=new parameter("anbu","selva","dinesh");
		parameter1.myfriends();

	}

}
