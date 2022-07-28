package demo;


	public class Teacher{

		String name="anbu";
		int age=12;

		public void getdetails(){

		System.out.println("student details are"+name+age);
		}


		public void assignment(){

		System.out.println("to give home work");
		}


		 public class students extends Teacher{

		public void details(){

		System.out.println("complete home work");
		}
		 }


		public static void main(String[] args){

		Teacher tec=new Teacher();
		tec.getdetails();
		
		}
		}
	


