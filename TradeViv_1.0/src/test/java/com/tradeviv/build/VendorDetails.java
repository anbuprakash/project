package com.tradeviv.build;

public class VendorDetails 
{
	String vendorName,companyEmail,companyName,mobNo;
	public VendorDetails(String vendorName,String companyEmail,String companyName,String mobNo)
	{
		this.vendorName=vendorName;
		this.companyEmail=companyEmail;
		this.companyName=companyName;
		this.mobNo=mobNo;
	}
	public String getvendorName()
	{
		return vendorName;
	}
	public String getcompanyEmail()
	{
		return companyEmail;
	}
	public String getcompanyName()
	{
		return companyName;
	}
	public String getmobNo()
	{
		return mobNo;
	}

}
