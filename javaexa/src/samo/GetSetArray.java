package samo;

import java.util.ArrayList;

public class GetSetArray {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("apple");
		list.add("mango");
	    list.add("orange");
	    list.add("graphs");
	    System.out.println(list.get(1));
        list.set(1,"dates");
        for(String fruits:list) {
        	System.out.println(fruits);
        }
	}

}
