package collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Collection_Explanation 
{
	Scanner scan=new Scanner(System.in);
	int number;String name;

	public void collection()
	{
		System.out.println("CHOOSE COLLECTION");
		list();
		number=scan.nextInt();
		switch (number) 
		{
		case 1:whatColl();
		break;
		case 2:types();
		break;
		case 3:array();
		break;
		case 4:linkedList();
		break;
		case 5:vector();
		break;
		case 6:stack();
		break;
		case 7:priorityDeque();
		break;
		case 8:arrayDeque();
		break;
		case 9:hashSet();
		break;
		case 10:linkedHashSet();
		break;
		case 11:treeSet();
		break;
		case 12:hashMap();
		break;
		case 13:linkedHashMap();
		break;
		case 14:treeMap();
		break;



		}
	}
	public void whatColl()
	{
		System.out.println( "The Collection in Java is a framework that provides "
				+ "an architecture to store and manipulate the group of objects");

		System.out.println("do you go main or close");
		name=scan.next();
		collection();
	}
	public void types()
	{
		System.out.println("\t1.LIST"+"\t\t2.QUEUE"+"\t\t\t3.SET"+"\t\t4.MAP");
		System.out.println("\n"+"\t*ArrayList"+"\t*PriorityQueue"+"\t\t*HashSet"+"\t*HashMap");
		System.out.println("\t*LinkedList"+"\t*ArrayDeque"+"\t\t*LinkedHashSet"+"\t*LinkedHashMap");
		System.out.println("\t*Vector"+"\t                   "+"\t\t*TreeSet"+"\t*TreeMap");
		System.out.println("\t*Stack");
		System.out.println("do you go main or close");
		name=scan.next();
		collection();


	}
	public void array()
	{

		System.out.println("List of cars");

		ArrayList<String> array=new ArrayList<String>();
		array.add("HYUNDAI");
		array.add("HONDA");
		array.add("AUDI");
		array.add(null);
		array.add("RENAULT NISSAN");

		System.out.println(array);
		System.out.println("Add car list");
		name=scan.next();
		array.add(name);
		System.out.println(array);

		System.out.println("Remove car list");
		number=scan.nextInt();
		System.out.println(array.remove(number));
		System.out.println(array);

		System.out.println("Get total car list");
		name=scan.next();
		System.out.println(array.size());

		System.out.println("list is empty or not");
		System.out.println(array.isEmpty());

		System.out.println("search product");
		name=scan.next();
		System.out.println(array.contains(name));

		System.out.println("Get product position");
		number=scan.nextInt();
		System.out.println(array.get(number));

		System.out.println("find product position");
		name=scan.next();
		System.out.println(array.indexOf(array.indexOf(name)));

		System.out.println("Last index position");
		name=scan.next();
		System.out.println(array.lastIndexOf(name));

		System.out.println("do you go main or close");
		name=scan.next();
		collection();



	}
	public void linkedList()
	{
		LinkedList< Integer> linkedList= new LinkedList<Integer>();
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);

		System.out.println("Linked List :"+ linkedList);
		
	

		System.out.println("add first");
		number=scan.nextInt();
		linkedList.addFirst(number);
		System.out.println("Linked List after adding first:"+ linkedList);

		System.out.println("add last");
		number=scan.nextInt();
		linkedList.addLast(number);
		System.out.println("Linked List after adding last:"+ linkedList);

		System.out.println("get first value");
		name=scan.next();
		System.out.println("First Value :" +linkedList.getFirst());

		//Get the first value using index position
		System.out.println("get index position");
		number=scan.nextInt();
		System.out.println("First Value using index :"+linkedList.get(number));


		//		System.out.println("Third value of the list : "+ linkedList.get(3));


		System.out.println("remove first & last");
		name=scan.next();
		System.out.println("Remove first :"+linkedList.removeFirst());
		System.out.println("Remove last :"+linkedList.removeLast());


		//		System.out.println(linkedList.poll());
		//		System.out.println(linkedList);
		//
		//
		//		linkedList.pollLast();
		//		System.out.println(linkedList);
		//
		//
		//		linkedList.remove();
		//		System.out.println(linkedList);

		//		linkedList.addFirst(1);
		//		linkedList.add(2);
		//		linkedList.add(3);
		//		linkedList.add(4);
		//		linkedList.add(5);
		//		linkedList.add(6);
		//
		//
		//		linkedList.removeFirstOccurrence(2);
		//		System.out.println("After removing the first occurence of 2 "+ linkedList );
		//
		//		linkedList.removeLastOccurrence(6);
		//		System.out.println("After removing the last occurence of 6 "+ linkedList );

		System.out.println("do you go main or close");
		name=scan.next();
		collection();
	}

	public void vector()
	{
		Vector<String> vector= new Vector<String>();
		vector.addElement("Steve");
		vector.addElement("Bill");
		vector.addElement(null);
		vector.addElement("Sundar");
		vector.addElement("Satya");
		vector.addElement("Sergey");
		System.out.println("Vector "+ vector);

		//Retrieve element -> elementAt()
		System.out.println("get element");
		number=scan.nextInt();
		System.out.println("Element At 0th pos is "+ vector.elementAt(number));

		// remove element ->removeElement()
		System.out.println("remove element");
		name=scan.next();
		vector.removeElement(null);
		System.out.println(vector);

		//sublist
		System.out.println(vector.subList(1, 3));

		//sorting the elements
		System.out.println("sorting order");
		name=scan.next();
		Collections.sort(vector);
		System.out.println("After sorting :"+ vector);

		System.out.println("do you go main or close");
		name=scan.next();
		collection();
	}

	public void stack()
	{
		Stack<Integer> stack= new Stack<Integer>();

		//To insert an element -> push()
		stack.push(800000);
		stack.push(685000);
		stack.push(780000);

		//print and see the stack
		System.out.println("Stack elements :"+ stack);

		//delete an element-> pop()
		System.out.println("delete element");
		name=scan.next();
		stack.pop();// LIFO, so the last inserted element will be deleted
		System.out.println("After popping an element : "+stack);

		//to get the top element -> peek()
		System.out.println("get peek element");
		name=scan.next();
		System.out.println("Top Element :" +stack.peek());

		//search returns the offset value. Offset is the position counted from top
		System.out.println("Get offset value");
		number=scan.nextInt();
		System.out.println("Searching the element Honda :"+stack.search(number));

		//if the element is not present then the value is -1
		System.out.println("element present or not");
		number=scan.nextInt();
		System.out.println("Searching an element which is not present :"+ stack.search(number));


		System.out.println("do you go main or close");
		name=scan.next();
		collection();
	}

	public void priorityDeque()
	{
		PriorityQueue<String> queue=new PriorityQueue<String>();  
		queue.add("DOOR");  
		queue.add("SIDE MIRROR");  
		queue.add("HEAD LAMP");  
		queue.add("REAR LAMP");  
		queue.add("ENGINE");  
		System.out.println("head:"+queue.element());  
		System.out.println("head:"+queue.peek());  
		System.out.println("iterating the queue elements:");  
		Iterator itr=queue.iterator();  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		}  
		queue.remove();  
		queue.poll();  
		System.out.println("after removing two elements:");  
		Iterator<String> itr2=queue.iterator();  
		while(itr2.hasNext()){  
			System.out.println(itr2.next());  

			System.out.println("do you go main or close");
			name=scan.next();
			collection();
		}  
	} 
	public void arrayDeque()
	{
		Deque<String> deque=new ArrayDeque<String>();  
		deque.offer("arvind");  
		deque.offer("vimal");  
		deque.add("mukul");  
		deque.offerFirst("jai");  
		System.out.println("After offerFirst Traversal...");  
		for(String s:deque){  
			System.out.println(s);  
		}  
		//	deque.poll();  
		//	deque.pollFirst();//it is same as poll()  
		deque.pollLast();  
		System.out.println("After pollLast() Traversal...");  
		for(String s:deque){  
			System.out.println(s);  
		}  
		System.out.println( deque.getFirst());

		System.out.println("do you go main or close");
		name=scan.next();
		collection();
	}
	public void hashSet()
	{
		HashSet<String> set=new HashSet<String>();  
		set.add("Ravi");  
		set.add("Vijay");  
		set.add("Arun");  
		set.add("Sumit");  
		System.out.println("An initial list of elements: "+set);  
		//Removing specific element from HashSet

		System.out.println("remove element");
		name=scan.next();
		set.remove(name);  
		System.out.println("After invoking remove(object) method: "+set);  
		//		HashSet<String> set1=new HashSet<String>();  
		//		set1.add("Ajay");  
		//		set1.add("Gaurav");  
		//		set.addAll(set1);  
		//		System.out.println("Updated List: "+set);  
		//		//Removing all the new elements from HashSet  
		//		set.removeAll(set1);  
		//		System.out.println("After invoking removeAll() method: "+set);  
		//Removing elements on the basis of specified condition  
		//		set.removeIf(str->str.contains("Vijay"));    
		//		System.out.println("After invoking removeIf() method: "+set);  
		//Removing all the elements available in the set 
		System.out.println("clear all");
		name=scan.next();
		set.clear();  
		System.out.println("After invoking clear() method: "+set); 

		System.out.println("do you go main or close");
		name=scan.next();
		collection();

	}
	public void linkedHashSet()
	{
		System.out.println("labours");
		LinkedHashSet<String> al=new LinkedHashSet<String>();  
		al.add("Ravi");  
		al.add("Vijay");  
		al.add("Ravi");  
		al.add("Ajay");  
		Iterator<String> itr=al.iterator();  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		}  

		System.out.println("do you go main or close");
		name=scan.next();
		collection();

	}
	public void treeSet()
	{
		System.out.println("counter");
		TreeSet<Integer> treeSet= new TreeSet<Integer>() ;
		treeSet.add(10);
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(9);
		treeSet.add(7);
		treeSet.add(3);

		System.out.println("Elements are sorted on ascending order :"+ treeSet);

		//first() 
		System.out.println("token no first");
		name=scan.next();
		System.out.println("First element :"+treeSet.first());
		//last()
		System.out.println("token no last");
		name=scan.next();
		System.out.println("Last element :"+treeSet.last());
		//headSet()
		System.out.println("available counter head");
		number=scan.nextInt();
		System.out.println("Values lesser than given value"+treeSet.headSet(3));
		//tailSet()
		System.out.println("available counter tail");
		number=scan.nextInt();
		System.out.println("Values equal to and higher than given value"+treeSet.tailSet(9));
		//subSet()

		System.out.println("Subset values :"+treeSet.subSet(2, 9));
		//comparator()
		System.out.println("Comparator returns null if the sorting is default natural order :"+ treeSet.comparator());

		System.out.println("Reverse Set: "+treeSet.descendingSet());  


		System.out.println("do you go main or close");
		name=scan.next();
		collection();
	}
	public void hashMap()
	{
		System.out.println("On working");

		System.out.println("list & search cars");
		HashMap<String,String> hm=new HashMap<String,String>();  
		hm.put("h", "HYUNDAI");
		hm.put("b", "BMW");
		hm.put("a", "AUDI");
		System.out.println(hm);

		System.out.println("add key & value");
		name=scan.next();

		String name1=scan.next();

		hm.put(name, name1);

		System.out.println(hm);


		System.out.println("Get car using key");
		name=scan.next();
		System.out.println(hm.get(name));

		System.out.println("cars are available or not");
		name=scan.next();
		System.out.println(hm.containsValue(name));

		System.out.println("Remove car using key");
		name=scan.next();
		System.out.println(hm.remove(name));
		System.out.println(hm);



		System.out.println("do you go main or close");
		name=scan.next();
		collection();
	}
	public void linkedHashMap()
	{

		System.out.println("Worker details");
		LinkedHashMap<Integer,String> hm=new LinkedHashMap<Integer,String>();  

		hm.put(100,"Amit");  
		hm.put(101,"Vijay");  
		hm.put(102,"Rahul");  

		System.out.println(hm);

		System.out.println("worker present or not");
		name=scan.next();
		System.out.println(hm.containsValue(name));

		System.out.println("worker name get from id");
		number=scan.nextInt();
		System.out.println(hm.get(number));

		System.out.println("do you go main or close");
		name=scan.next();
		collection();
	}  
	public void treeMap()
	{
		System.out.println("Delivered Cars");
		TreeMap<String, String> tm=new TreeMap<String, String>();
		tm.put("h","Hyundai");
		tm.put("a", "AUDI");
		tm.put("b", "BMW");

		System.out.println(tm);

		System.out.println("add key & value");
		name=scan.next();

		String name1=scan.next();

		tm.put(name, name1);

		System.out.println(tm);

		System.out.println("Get first entry");
		name=scan.next();
		System.out.println(tm.pollFirstEntry());

		System.out.println("Get last entry");
		name=scan.next();
		System.out.println(tm.pollLastEntry());

		System.out.println("do you go main or close");
		name=scan.next();
		collection();

	}
	public void list()
	{
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("1.What is coll");
		arr.add("2.Types");
		arr.add("3.ArrayList");
		arr.add("4.LinkedList");
		arr.add("5.Vector");
		arr.add("6.stack");
		arr.add("7.PriorityQueue");
		arr.add("8.ArrayDeque");
		arr.add("9.HashSet");
		arr.add("10.LinkedHashSet");
		arr.add("11.TreeSet");
		arr.add("12.HashMap");
		arr.add("13.LinkedHashMap");
		arr.add("14.TreeMap");

		for (String string : arr) {
			System.out.println(string);
		}
	}


}
