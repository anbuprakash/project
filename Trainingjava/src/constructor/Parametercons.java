package constructor;

public class Parametercons {
	String friendname1;
	String friendname2;
	String friendname3;
	Parametercons(String name1,String name2,String name3){
		//Parameterized constructor
		friendname1=name1;
		friendname2=name2;
		friendname3=name3;
	}
		public void myfriends() {
			System.out.println("my friends are"+friendname1+friendname2+friendname3);
			
		}


	public static void main(String[] args) {
		Parametercons parameter=new Parametercons("selvapathy","dinesh","anbarasu");
		parameter.myfriends();
		
		Parametercons parameter1=new Parametercons("anbu","selva","dinesh");
		parameter1.myfriends();


	}

}
