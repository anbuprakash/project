package com.sathya.mobile;

public class MobileDetails {
	String brand,regularPrice,currentPrice,amountSaved,rearCamera,frontCamera,ram,rom,operatingSystem,processor;

	public MobileDetails(String  brand,String  regularPrice,String  currentPrice,String  amountSaved,String  rearCamera,String  frontCamera, String  ram, String  rom, String  operatingSystem,String  processor)
	{
		this.brand= brand;
		this.frontCamera=frontCamera;
		this.rearCamera=rearCamera;
		this.rom=rom;
		this.ram=ram;
		this.operatingSystem=operatingSystem;
		this.processor=processor;
		this.amountSaved=amountSaved;
		this.regularPrice=regularPrice;
		this.currentPrice=currentPrice;
	}
	public MobileDetails(String brand2, String currentPrice2, String rearCamara) {
		// TODO Auto-generated constructor stub
	}
	public String getRegularPrice() {
		return regularPrice;
	}
	public String getCurrentPrice() {
		return currentPrice;
	}
	public String getAmountSaved() {
		return amountSaved;
	}
	public String getBrand() {
		return brand;
	}
	public String getFrontCamera() {
		return frontCamera;
	}
	public String getRearCamera() {
		return rearCamera;
	}
	public String getRam() {
		return ram;
	}
	public String getRom() {
		return rom;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public String getProcessor() {
		return processor;


	}

}



