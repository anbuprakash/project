package samo;

import java.util.HashSet;
import java.util.Iterator;

public class HassSetEx {

	public static void main(String[] args) {
           HashSet<String> ex=new HashSet<String>();
           ex.add("prakash");
           ex.add("anbarasu");
           ex.add("prakash");
           ex.add("selva");
           ex.add("dinesh");
           Iterator<String> itr=ex.iterator();
           while(itr.hasNext()) {
        	   System.out.println(itr.next());
           }

	}

}
