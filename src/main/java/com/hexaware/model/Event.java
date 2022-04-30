package com.hexaware.model;

public class Event {
	
	int eventId;
	String status;
	String optId;
	String finalQuery;
	
	public Event() {
		
	}

	public Event(int eventId, String status, String optId, String finalQuery) {
		super();
		this.eventId = eventId;
		this.status = status;
		this.optId = optId;
		this.finalQuery = finalQuery;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOptId() {
		return optId;
	}

	public void setOptId(String optId) {
		this.optId = optId;
	}

	public String getFinalQuery() {
		return finalQuery;
	}

	public void setFinalQuery(String finalQuery) {
		this.finalQuery = finalQuery;
	}
	
	

}
