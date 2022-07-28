package javaclass;

import java.util.ArrayList;
import java.util.Iterator;

public class smpleprogrmme {

	public static void main(String[] args) {
		ArrayList<String>list=new ArrayList<>();
		list.add("selva");//Adding object in arraylist  
		list.add("prakash");  
		list.add("dinesh");  
		list.add("anbarasu");  
		//Traversing list through Iterator  
		Iterator<String> itr=list.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());   
		
	}
}
}