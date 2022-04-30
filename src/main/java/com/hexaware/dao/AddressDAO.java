package com.hexaware.dao;

import java.util.List;

import com.hexaware.model.AddressDetails;
import com.hexaware.model.Capital;
import com.hexaware.model.Country;
import com.hexaware.model.States;

public interface AddressDAO {
	
	 public List<Country> listOfCountries();
	    
	    public List<States> listOfStatesByCountry(int code);
	    
	    public List<Capital> listOfCitiesByState(int statid);
	    
	    public List<AddressDetails> listOfAddress(int empid);
	    
	    public void addAdressDetails(AddressDetails add);
	    
	    public void updateAddressDetails(AddressDetails add);
	    
	    public Country getCountry(int code);
	    
	    public States getState(int id);
	    
	    public Capital getCity(int id);
	    
	    
	    

}
