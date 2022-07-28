package string;

public class Examplestring {
public static void main(String[] args) {
  String name="Anbarasan";    //start with 0 index
	  
	  System.out.println(name.charAt(3)); // find 3rd index letter
	  
	  System.out.println(name.length());  //total length
	  
	  System.out.println(name.equals("anbu"));  //given & already given same aa check
	  
	  System.out.println(name.equalsIgnoreCase("Anbarasan"));  //given & already given same aa check
	  
	  System.out.println(name.isEmpty());  //check whether the string or not
	  
	  System.out.println(name.isBlank());    //check whether the string or not
	  
	  System.out.println(name.substring(3));  //3rd index la irunthu kudukkum
	  
	  System.out.println(name.substring(2, 7));  //2 to 7 kulla irukkuratha tharum
	  
	  System.out.println(name.contains("a")); 
	  
	  System.out.println(name.concat("mani")); // last aa add pannum
	  
	  System.out.println(name.repeat(2));  // times repeat pannum 
	  
	  System.out.println(name.replace("a", "A"));   //given letter replace pannum
	  
	  System.out.println(name.replace("arasan", "arasu")); // given name change 
  
	  System.out.println(name.indexOf("arasan", 1)); //arasan 1 index la irunthu kattum
	  
	  System.out.println(name.indexOf("r", 0));
	  
	  System.out.println(name.trim());  // start & end white spaces remove
	  
	  System.out.println(name.valueOf(4)); //int to string   
	  
	  System.out.println(name.isBlank());
	  
	  
	  String uppercase="ANBU"; // change to lowercase
	  System.out.println(uppercase.toLowerCase());
	  
	  String lowercase="arasu"; //change to uppercase
	  System.out.println(lowercase.toUpperCase());
	  
	  System.out.println(String.join("-","learn","java","online"));
	  
	  System.out.println(String.join("/", "30","05","2021"));
	  
	  String splitthis="i,am,learn,java";
	  String[]splittedwords=splitthis.split(",");
	  for(String string:splittedwords) {
		  System.out.println(string);
	  
	  
		  
		
	  }
}
}
