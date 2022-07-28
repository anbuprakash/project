package learn;

public class Rework {
	int a[]= {1,2,4,3,6};
	public void odd() {
		for(int i=0;i<a.length;i++) {
			if(a[i]%2!=0) {
			System.out.println(a[i]);
			}
			
		}
	}
	public void even() {
		for(int i=0;i<a.length;i++) {
			if(a[i]%2==0) {
				System.out.println(a[i]);
			}
		}
	}
	
	

	public static void main(String[] args) {
		Rework c=new Rework();
		c.odd();
		c.even();

}
}
