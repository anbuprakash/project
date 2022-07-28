package samo;

import java.util.ArrayList;
import java.util.Iterator;

class Student{
	int rollno;
	int age;
	String name;
	Student(String st_name,int st_age,int st_rollno){
		name=st_name;
		age=st_age;
		rollno=st_rollno;;
	}
}

public class UserDefinemtod {

	public static void main(String[] args) {
	  Student s1=new Student("prakash",25,101);
	  Student s2=new Student("Anbarasu",21,102);
	  Student s3=new Student("selva",29,103);
	  ArrayList<Student> arr=new ArrayList<Student>();
	  arr.add(s1);
	  arr.add(s2);
	  arr.add(s3);
	  Iterator<Student> itr=arr.iterator();
	  while(itr.hasNext()) {
		  Student st=(Student)itr.next();
		  System.out.println(st.name+" "+st.age+" "+st.rollno);
	  }
		

	}

}
