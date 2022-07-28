package fileHandling;

public class FindChar {

	public static void main(String[] args) {
		
		String s1="abc";
		String s2="abcabc";
		String s3="abcabcabc";
		int count=0;
		
		for(int i=1;i<s1.length()-1;i++)
		{
			char[] c=s1.toCharArray();
				if(c[i]=='a' || c[i]=='b' || c[i]=='c') 
				{
					count++;
				}
		}
		System.out.println(count);
		for(int i=1;i<=s2.length()-1;i++)
		{
			char c=s2.charAt(i);
				if(c=='a' ||c=='b' || c=='c') 
				{
					count++;
				}
		}
		System.out.println(count);
		for(int i=1;i<=s3.length()-1;i++)
		{
			char c=s3.charAt(i);
				if(c=='a' ||c=='b' || c=='c') 
				{
					count++;
				}
		}
		System.out.println(count);

	}

}
