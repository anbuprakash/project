package com.ptipp.day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.ListIterator;

//Author PRAKASH M

public class Ptip 
{

	public static void main(String[] args) 
	{
		Demo d=new Demo();
		d.pyramid();
		d.arraylist();
		d.duplicate();
		d.hashmap();
		d.vowels();
	}

}
class Demo
{
	public void pyramid()
	{
		int row =5;
		for(int i=1;i<=row;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void arraylist()
	{
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(5);
		arr.add(10);
		arr.add(2);
		ListIterator<Integer> li = arr.listIterator(arr.size());
		//	      while (li.hasNext())
		//	      {
		//	         li.next();
		//	      }
		while (li.hasPrevious()) 
		{
			System.out.println(li.previous());
		}
		Collections.reverse(arr);
		System.out.println(arr);
	}
	public void duplicate()
	{
		String string = "hi hi do do";  
		int count;  

		String words[] = string.split(" ");  

		System.out.println("Duplicate words : ");   
		for(int i = 0; i < words.length; i++) {  
			count = 1;  
			for(int j = i+1; j < words.length; j++)
			{  
				if(words[i].equals(words[j]))
				{  
					count++; 
					words[j] = "0";  
				}  
			}  

			if(count > 1 && words[i] != "0")  
				System.out.println(words[i]);  
		}  
	}  
	public void hashmap()
	{
		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		System.out.println("is empty " + hm.isEmpty() );

		hm.put(5, "Five");
		hm.put(4, "Four");
		hm.put(2, "Three");
		
		System.out.println("is empty " + hm.isEmpty() );
	}
	public void vowels()
	{
		int upper=0;
		int lower=0;
		String word="Today Independence Day";
		int count=0;
		for (int i=0 ; i<word.length(); i++)
		{
			char ch = word.charAt(i);
			if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'){
				count ++;
			}
		}
		System.out.println("Number of vowels "+count);
		for(int i = 0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				upper++;
			else if (ch >= 'a' && ch <= 'z')
				lower++;

		}

		System.out.println("Lower case  : " + lower);
		System.out.println("Upper case  : " + upper);
	}
}