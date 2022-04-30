package com.hexaware.model;

public class Employee {
	private int id;
    private String name;
    private String email;
    private String address;
    private String telephone;
    private String dateOfJoin;
	
    public Employee(){
    	
    }
    
    
    public Employee(int id, String name, String email, String address, String telephone, String dateOfJoin) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
		this.dateOfJoin = dateOfJoin;
	}
    public Employee(String name, String email, String address, String telephone, String dateOfJoin) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
		this.dateOfJoin = dateOfJoin;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
    
    
    
    
}
