package javaclass;

import java.util.Iterator;
import java.util.LinkedList;

public class sampleprograme {

	public static void main(String[] args) {
	      LinkedList<String>list=new LinkedList<String>();
	      list.add("anbu");
	      list.add("selva");
	      Iterator<String>itr=list.iterator();
	      while (itr.hasNext()){
	    	  System.out.println(itr.next());
	      }

	}

}
