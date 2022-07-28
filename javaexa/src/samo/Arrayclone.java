package samo;

public class Arrayclone {

	public static void main(String[] args) {
       int []a= {33,65,98,7};
       
       for(int i=0;i<4;i++) {
    	   System.out.println(a[i]);
       }
        int[] b=a.clone();
        for(int i=0;i<4;i++) {
        	System.out.println(b[i]);
        }
  System.out.println(a==b);
}
}