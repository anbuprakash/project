package string;

public class Stringbuffer {

	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("Tamil");
		System.out.println("Appending a name to original :"+ " "+(sb.append("arasu")));
		
		System.out.println("original name :" + sb);
		
		System.out.println("reverse name :"+ sb.reverse());
	
		StringBuffer replacethis=new StringBuffer("arasu");
		
		System.out.println(sb.replace(5, 10, "arasan"));
		
		System.out.println(sb.delete(5, 11));
		
		System.out.println(sb.capacity());
		
		System.out.println(sb.insert(4, "san"));
		
		System.out.println(sb.length());
		
		System.out.println(sb.charAt(2));

	}

}
