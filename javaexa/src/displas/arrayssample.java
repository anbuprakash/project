package displas;

public class arrayssample {

	public static void main(String[] args) {
		int[][]arr= {{23,43,76,65},{22,34,45,67}};
		
		for(int a = arr.length-1;a>=0;a--) 
		{
			for(int b=arr.length-1;b>=0;b--) {
			System.out.println(arr[a][b]);
		}
		System.out.println();
	
	}

}
}
