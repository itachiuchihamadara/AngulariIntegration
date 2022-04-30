package com.hexaware.model;

public class AddressDetails {
	
	int id;
	int empId;
	int countryCode;
	int stateId;
	int cityId;
	String details;
	
	
	public AddressDetails() {
		super();
	}
	public AddressDetails(int id, int empId, int countryCode, int stateId, int cityid, String details) {
		super();
		this.id = id;
		this.empId = empId;
		this.countryCode = countryCode;
		this.stateId = stateId;
		this.cityId = cityid;
		this.details = details;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
