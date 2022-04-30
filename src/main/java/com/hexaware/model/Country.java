package com.hexaware.model;

public class Country {
	
	int countryCode;
	String name;
	
	
	public Country() {
		super();
	}
	public Country(int countryCode, String name) {
		super();
		this.countryCode = countryCode;
		this.name = name;
	}
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
