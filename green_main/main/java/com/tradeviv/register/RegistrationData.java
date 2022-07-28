package com.tradeviv.register;

public class RegistrationData {
	private String vendorName,companyName,CompanyEmail,phoneNumbers;

	RegistrationData(String vendorName,String companyName,String CompanyEmail,String phoneNumbers) {
		this.vendorName=vendorName;
		this.companyName=companyName;
		this.CompanyEmail=CompanyEmail;
		this.phoneNumbers=phoneNumbers;
	}

	public String getvendorName() {
		return vendorName;
	}
	public String getcompanyName() {
		return companyName;
	}
	public String getCompanyEmail() {
		return CompanyEmail;
	}
	public String getphoneNumber() {
		return phoneNumbers;
	}

}
