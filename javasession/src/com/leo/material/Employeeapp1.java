package com.leo.material;

public class Employeeapp1 {
	class Departmentcreat{
		Integer departmentid;
		String departmentname;
		String designation;
		Departmentcreat(int did,String dname,String ddesi){
			departmentid=did;
			departmentname=dname;
			designation=ddesi;	
		}
		public Integer getdid() {
			return departmentid;
		}
		public String getdname() {
			return departmentname;
		}
		public String getddesi() {
			return designation;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
