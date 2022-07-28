package samo;

import java.util.ArrayList;
import java.util.Iterator;

public class Listcolsam {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("anbu");
		list.add("dinesh");
		list.add("selva");
		
        Iterator<String> itr=list.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }

	}

}
