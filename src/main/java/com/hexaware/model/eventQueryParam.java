package com.hexaware.model;

public class eventQueryParam {
	
	int id;
	int eventId;
	String queryVal;
	
	public eventQueryParam() {
		
	}

	public eventQueryParam(int id, int eventId, String queryVal) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.queryVal = queryVal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getQueryVal() {
		return queryVal;
	}

	public void setQueryVal(String queryVal) {
		this.queryVal = queryVal;
	}
	

}
