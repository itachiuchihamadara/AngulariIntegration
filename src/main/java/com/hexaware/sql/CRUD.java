package com.hexaware.sql;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CRUD {
	
	private JdbcTemplate jdbcTemplate;
	

	public CRUD(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public CRUD() {
		
	}
	
	public String saveEmployee() {
		
		return "INSERT INTO employee ( id, dateofjoin, name, email, address, telephone)"
                + " VALUES (?, ?, ?,?, ?, ?)";
	}
	
	public String updateEmployee() {
		return "UPDATE employee SET name=?, email=?, address=?, "
                + "telephone=?, dateofjoin=? WHERE id=?";
	}
	
	public String deleteEmployee() {
		return "DELETE FROM employee WHERE id=?";
	}
	
	public String getEmployeeById(int empid) {
		return "SELECT * FROM employee WHERE id="+empid;
	}
	
	public String listEmployees() {
		return "SELECT * FROM employee";
	}
	
	public String allCountries() {
		return "SELECT * FROM country";
	}
	
	public String statesByCountry(int code) {
		return "SELECT * FROM state where countrycode = "+code;
	}
	
	public String citiesByState(int statid) {
		return "SELECT * FROM capital where stateid = "+statid;
	}
	
	public String listOfAddress(int empid) {
		return "SELECT * FROM EmployeeAddressDetails where empid = "+empid;
	}
	
	public String addAdressDetails() {
		return "INSERT INTO EmployeeAddressDetails ( empid, countryid, stateid, cityid, addressdetails)"
                + " VALUES (?, ?, ?, ?, ?)";
	}
	
	public String updateAddressDetails() {
		return "UPDATE EmployeeAddressDetails SET countryid=?, stateid=?,cityid=? ,addressdetails=?"
                + "WHERE empid=?";
	}
	
	public String getCountry(int code) {
		return "SELECT * FROM Country WHERE countrycode=" + code;
	}
	
	public String getState(int id) {
		return "SELECT * FROM state WHERE id=" + id;
	}
	
	public String getCity(int id) {
		return "SELECT * FROM capital WHERE id=" + id;
	}
	
	public String saveReport() {
		
		return "INSERT INTO Report_Opt_In (startdate, enddate, typeofreport)"
                + " VALUES (?, ?, ?)";
	}
	public String saveEvent() {
		
		return "INSERT INTO Event (status_event, opt_in_id, final_query)"
                + " VALUES (?, ?, ?)";
	}
	public String saveParam() {
		
		return "INSERT INTO event_query_param (event_id, query_val)"
                + " VALUES (?, ?)";
	}
	public String getNoOfEventRows() {
		return "select count(event_id) as id from Event";
	}
	
	public String getNoOfReportRows() {
		return "select count(opt_in_id) as id from report_opt_in";
	}
	
	
	
	
	

}
