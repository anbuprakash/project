package com.admin.page;

public class Materials {
	
	private String maincategory,subcategory,childcategory,Slug,tags;
	
	public Materials(String maincategory,String subcategory,String childcategory,String Slug,String tags) {
		this.maincategory=maincategory;
		this.subcategory=subcategory;
		this.childcategory=childcategory;
		this.Slug=Slug;
		this.tags=tags;
		
	}
	
	public String getmainCategory() {
		return maincategory;
	}
	public String getsubCategory() {
		return subcategory;
	}
	public String getchildCategory() {
		return childcategory;
	}
	public String getSlug() {
		return Slug;
	}
	public String gettags() {
		return tags;
	}



}