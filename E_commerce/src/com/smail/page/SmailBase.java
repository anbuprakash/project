package com.smail.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

import com.ecommerce.pro.ConsoleColours.ConsoleColors;

public class SmailBase 
{
	public static final String ANSI_RESET = "\u001B[0m";
	Scanner scan=new Scanner(System.in);
	String name;long number;int num;
	String fname,lname,smail,spass,scpass,smob,sremail,to,cc,bcc,sub,text,file;


	public void s_Base()
	{
		System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT+"\n"+"\t\tWELCOME SMAIL.COM"+ANSI_RESET);
		System.out.println(ConsoleColors.ROSY_PINK+"\n"+"\t1.Sign in"+"\t\t2.Sign up");
		num=scan.nextInt();
		switch (num) 
		{
		case 1:login();
		break;
		case 2:create();
		break;
		case 3:close();
		break;

		}

	}
	public void create()
	{
		System.out.println("\n"+"\tEnter First name");
		name=scan.next();
		System.out.println("\n"+"\tEnter last name");
		name=scan.next();
		System.out.println("\n"+"\tEnter User mail name");
		fname=scan.next();
		System.out.println("\n"+"\tEnter password");
		name=scan.next();
		System.out.println("\n"+"\tEnter confirm password");
		name=scan.next();
		System.out.println("\n"+"\tEnter phone number");
		number=scan.nextLong();
		System.out.println("\n"+"\tEnter Recovery email address");
		name=scan.next();
		System.out.println("\n"+"\tEnter DOB");
		name=scan.next();
		System.out.println("\n"+"\tEnter Gender");
		name=scan.next();
		System.out.println("\n"+"\tEnter OTP");
		number=scan.nextLong();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"\n"+fname+"\tCreate Account sucessfull"+ANSI_RESET);
		System.out.println("\n"+"\tDo you want to ?  'login' or 'main'");
		re_log();

	}
	public void re_log()
	{
		name=scan.next();
		if(name.equals("login"))
		{
			login();
		}
		else
		{
			s_Base();
		}
	}
	public void login()
	{
		System.out.println("\n"+"\tEnter your mail id");
		fname=scan.next();
		System.out.println("\n"+"\tEnter your password");
		name=scan.next();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"\n"+fname+"\t:Login sucessfull"+ANSI_RESET);
		System.out.println("\n"+"\tMenu");
		num=scan.nextInt();
		icons();
	}
	public void close()
	{
		System.exit(0);
	}
	public void main()
	{
		ArrayList<String> array=new ArrayList<String>();
		array.add("\n"+"\t1.search");
		array.add("\n"+"\t2.compose");
		array.add("\n"+"\t3.All mail");
		array.add("\n"+"\t4.Inbox");
		array.add("\n"+"\t5.Sent");
		array.add("\n"+"\t6.Draft");
		array.add("\n"+"\t7.Starred");
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}

	}
	public void icons()

	{
		main();
		System.out.println("\n"+"\tChoose option");
		num=scan.nextInt();
		switch (num) 
		{
		case 1:search();
		break;
		case 2:compose();
		break;
		case 3:allMail();
		break;
		case 4:inbox();
		break;
		case 5: sent();
		break;
		case 6:draft();
		break;
		case 7:starred();
		break;
		}

	}
	public void search()

	{
		System.out.println("Search in mail");
		//		name=scan.next();

		HashMap<String,String> l=new HashMap<String,String>();
		l.put("prakash","prakash@smail.com");
		l.put("prasanth","prasanth@smail.com");
		l.put("prabhu","prabhu@smail.com");
		name=scan.next();
		System.out.println("\n"+l.get(name));
		System.out.println("\n"+"\tDo you want see mail click ,sign out or back" );
		back_b();
	}
	public void back_b() {
		name=scan.next();
		if(name.equals("click")) {
			System.out.println("\n"+"\tTo : prakash@smail.com");
			System.out.println("\n"+"\tText : hi,prakash");
			System.out.println("\n"+"\tDo you want to go ? 'back'or sign out");
			name=scan.next();
			if (name.equals("back")) {icons();

			} else {close();

			}
		}
		else if(name.equals("back")){
			icons();
		}
		else {
			close();
		}
	}





	public void compose()

	{

		System.out.println("\n"+"\tTo :");
		to=scan.next();
		System.out.println("\n"+"\tCc :");
		cc=scan.next();
		System.out.println("\n"+"\tSubject :");
		sub=scan.next();
		System.out.println("\n"+"\tText :");
		text=scan.next();
	//	LinkedList<String> array=new LinkedList<String>();
//		array.add(to);
//		array.add(text);
		  TreeMap<String,String> map=new TreeMap<String,String>();
		  map.put("TO :",to);
		  map.put("Text :",text);
		 for(Map.Entry m:map.entrySet())  
	      {  
	          System.out.println(m.getKey()+" "+m.getValue());      
	      }  
		
//		for (int i = 0; i < array.size(); i++) {
//			System.out.println(array.get(i));
//		}
		System.out.println("\n"+"\tMail sent sucessfull");
		icons();




	}
	public void allMail()

	{
		HashSet<String> set = new HashSet<String>();
		set.add("\n"+"\tprakash@smail.com");
		set.add("\n"+"\tmselva@gmail.com");
		set.add("\n"+"\tmdinesh@gmail.com");
		set.add("\n"+"\tmanbu@gmail.com");
		System.out.println(set);
		System.out.println("\n"+"\tDo u vant to choose main or delete");
		name=scan.next();
		if (name.equals("delete")) 
		{
			System.out.println( set.remove("prakash@smail.com"));
			System.out.println(set);
			icons();


		} else 
		{
			main_m();
		}

	}

	public void inbox()

	{
		TreeSet<String> tree=new TreeSet<String>();
		tree.add("\n"+"\tprabhu@smail.com");
		tree.add("\n"+"\tprasanth@gmail.com");
		tree.add("\n"+"\tprakash@smail.com");
		//System.out.println(tree);
		  Iterator<String> itr=tree.iterator();  
		  while(itr.hasNext())
		  {  
		   System.out.println(itr.next()); 
		  }
		  System.out.println("move to archive");
		search();


	}
	public void sent()

	{
		LinkedList<String> array=new LinkedList<String>();
		array.add("\n"+"\tprabhu@smail.com");
		array.add("\n"+"\tprakash@smail.com");
		System.out.println(array);
//		System.out.println("\n"+"\tprakash@smail.com");
//		System.out.println("\n"+"\tdo you want see mail click ,sign out or back" );
//		back_b();
		search();
	}
	public void draft()

	{
		LinkedHashMap<String, String> lhm=new LinkedHashMap<String, String>();
		lhm.put("prakash","prakash@smail.com");
		lhm.put("prabhu","prabhu@smail.com");
		System.out.println(lhm);
		search();
		System.out.println("do you want see mail click ,sign out or back" );
		back_b();
	}
	public void starred()

	{
		LinkedHashSet<String> ls=new LinkedHashSet<String>();
		ls.add("\n"+"\tprabhu@smail.com");
		ls.add("\n"+"\tprasanth@gmail.com");
		ls.add("\n"+"\tprakash@smail.com");
		System.out.println(ls);
		System.out.println("add mail id");
		name=scan.next();
		System.out.println(ls.add(name));
		System.out.println(ls);
		search();
		System.out.println("do you want see mail 'click' ,sign out or back" );
		back_b();
	}

	public void main_m()

	{
		icons();
	}



}
