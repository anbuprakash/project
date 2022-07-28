package learn;

public class tryreversr {

	public static void main(String[] args) {
	       String name="prakash";
	       char[] reverse=name.toCharArray();
	       for(int split=reverse.length-1;split>=0;split--) {
	    	   System.out.print(reverse[split]);
	       }

	}

}
