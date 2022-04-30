package com.hexaware.model;

public class Reports {
	
	int optId;
	String startDate;
	String EndDate;
	String type;
	
	public Reports() {}

	public Reports(int optId, String startDate, String endDate, String type) {
		super();
		this.optId = optId;
		this.startDate = startDate;
		EndDate = endDate;
		this.type = type;
	}

	public int getOptId() {
		return optId;
	}

	public void setOptId(int optId) {
		this.optId = optId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
	
	

}
