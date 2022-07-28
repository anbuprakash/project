package displas;

public class numpatsam {

	public static void main(String[] args) {
		int[][]z= {{1,2,3},{4,5,6},{7,8,9}};
		int[][]y= {{9,8,7},{6,5,4},{3,2,1}};
		
		for(int i=0;i<z.length;i++) {
			for(int j=0;j<z.length;j++) {
				
					System.out.print(z[i][j]);
			
			}
			System.out.println();
		}
		for(int k=0;k<=y.length;k++) {
		System.out.print(y[k]);
		}
         
	}

}
