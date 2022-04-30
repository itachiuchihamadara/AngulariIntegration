package com.hexaware.model;

public class Capital {
	
	int id;
	
	int stateId;
	
	String name;

	
	
	public Capital() {
		super();
	}

	public Capital(int id, int stateId, String name) {
		super();
		this.id = id;
		this.stateId = stateId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
