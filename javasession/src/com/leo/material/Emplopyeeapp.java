package com.leo.material;

import java.util.ArrayList;

class Employee{
	Integer employeeid;
	String employeename;
	String department;
	
	Employee(int eid,String ename,String edept) {
		employeeid=eid;
		employeename=ename;
		department=edept;
		 System.out.println("employee ID :\t"+eid+"\nemployee Name :\t"+ename+"\ndepartment :\t"+edept+"");			
	}
	
}
class Department {
	
	Integer departmentid;
	String departmentname;
	String designation;
	
	Department(int did,String dname,String ddesi){
		departmentid=did;
		departmentname=dname;
		designation=ddesi;
		System.out.println("Department ID :\t"+did+"\nDepartment Name :"+dname+"\nDesignation :\t"+ddesi+"\n");
		
}
}


public class Emplopyeeapp  {

	
	public static void main(String[] args) {
		ArrayList<Employee> employee=new ArrayList<Employee>();
		ArrayList<Department>dept=new ArrayList<Department>();
		employee.add(new Employee(408214,"prakash","developer"));
		dept.add(new Department(210425,"mechanical","senior engineer"));
		employee.add(new Employee(408215,"dinesh","test engineer"));
		dept.add(new Department(210426,"mechanical","junior engineer"));
		employee.add(new Employee(408216,"anbarasu","test engineer"));
		dept.add(new Department(210427,"computer science","trainee engineer"));
		employee.add(new Employee(408217,"selvapathy","developer"));
		dept.add(new Department(210427,"civil engineer","senior engineer"));

	
		

		
//		ArrayList<Department>dept=new ArrayList<Department>();
//		dept.add(new Department(210425,"mechanical","senior engineer"));
//		dept.add(new Department(210426,"mechanical","junior engineer"));
//		dept.add(new Department(210427,"computer science","trainee engineer"));
//		
		
	}


}
 



	


