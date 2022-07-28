package learn;

public class MaxValue {
	
	static int arr[]= {12,34,65};
	
	public int max(int arr[])
	{
		int max=0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		return max;
		
	}

	public static void main(String[] args) {
		
		MaxValue m=new MaxValue();
		int max=m.max(arr);
		System.out.println(max+" is the Maximimum value in the array");

	}
	

	

}
