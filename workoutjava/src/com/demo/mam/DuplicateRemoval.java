package com.demo.mam;

import java.util.Scanner;


public class DuplicateRemoval {
	public static void  duplicate(String givenstring) {
		String[] words=givenstring.split(" ");
		for(int i=0;i<words.length;i++)
		{
			if(words[i]!=null)
			{
				for(int j =i+1;j<words.length;j++)
				{
					if(words[i].equals(words[j]))
					{
						words[j]=null;
					}
				}
			}
		}
		for(int k=0;k<words.length;k++)
		{
			if(words[k]!=null)
			{
				System.out.print(words[k]+" ");
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		System.out.println("Enter the String which contains dupliacte:");
		String givenstring= sc.nextLine();
		duplicate(givenstring);
	}
}


