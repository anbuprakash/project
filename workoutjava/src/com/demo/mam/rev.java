package com.demo.mam;

public class rev {
	private String name,company;
	private int id;

	public rev(String name, String company, int id) {
		super();
		this.name = name;
		this.company = company;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String setName(String name) {
		return name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getId() {
		return id;
	}
	public static void main(String[] args) {
		rev  r=new rev("prakash","com",120);
	System.out.println(r.getCompany()+" "+r.getId()+" "+r.getName());
	}

}

