package com.hexaware.model;

public class Login {
	
	int admid;
	String passwrd;
	public Login() {
		super();
	}
	public Login(int admid, String passwrd) {
		super();
		this.admid = admid;
		this.passwrd = passwrd;
	}
	public int getAdmid() {
		return admid;
	}
	public void setAdmid(int admid) {
		this.admid = admid;
	}
	public String getPasswrd() {
		return passwrd;
	}
	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}
	
	
	

}
