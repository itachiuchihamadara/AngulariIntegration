package com.hexaware.model;

public class States {

	int id;
	int countryCode;
	String name;
	
	
	public States() {
		super();
	}
	public States(int id, int countryCode, String name) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
