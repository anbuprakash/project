package samo;

class TestArray{
	double []a= {4,6,8,10};
	double total=0;
	int []x= {2,3,7,5,6,7,8,9,7,11};
	
	public void evenAverage() {
		  for(int i=0; i<a.length; i++){
	        	total = total + a[i];
	        }

	        double average = total / a.length;
	   
	        System.out.format("The average is: %.3f", average);
	}
	public void findAndReplace() {
		
		x[2]=0;
		
		System.out.println(x[2]);
		x[5]=0;
		System.out.println(x[5]);
		x[8]=0;
		System.out.println(x[8]);
		
		
		
	}
}

public class ArrayExcercise {

	public static void main(String[] args) {
		TestArray arr=new TestArray();
		arr.evenAverage();
		arr.findAndReplace();
		

	}

}
