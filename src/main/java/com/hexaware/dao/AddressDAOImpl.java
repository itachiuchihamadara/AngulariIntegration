package com.hexaware.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.hexaware.model.AddressDetails;
import com.hexaware.model.Capital;
import com.hexaware.model.Country;
import com.hexaware.model.Employee;
import com.hexaware.model.States;
import com.hexaware.sql.CRUD;

public class AddressDAOImpl implements AddressDAO {
	

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CRUD query;
	
	public AddressDAOImpl(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Country> listOfCountries() {
			
		
		String sql = query.allCountries();
	    List<Country> listCoun = jdbcTemplate.query(sql, new RowMapper<Country>() {
	 
	        @Override
	        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Country aCoun = new Country();
	        	aCoun.setCountryCode(rs.getInt("countrycode"));
	        	aCoun.setName(rs.getString("name"));
	            return aCoun;
	        }
	    });
	    
	    return listCoun;	
		

	}
	
	


	@Override
	public List<States> listOfStatesByCountry(int code) {
		
		String sql = query.statesByCountry(code);
	    List<States> liststat = jdbcTemplate.query(sql, new RowMapper<States>() {
	 
	        @Override
	        public States mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	States aStat = new States();
	        	aStat.setId(rs.getInt("id"));
	        	aStat.setCountryCode(rs.getInt("countrycode"));
	        	aStat.setName(rs.getString("name"));
	            return aStat;
	        }
	    });
	    
	    return liststat;	



	}


	@Override
	public List<Capital> listOfCitiesByState(int statid) {

		String sql = query.citiesByState(statid);
	    List<Capital> listcap = jdbcTemplate.query(sql, new RowMapper<Capital>() {
	 
	        @Override
	        public Capital mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Capital aCap = new Capital();
	        	aCap.setId(rs.getInt("id"));
	        	aCap.setStateId(rs.getInt("stateid"));
	        	aCap.setName(rs.getString("name"));
	            return aCap;
	        }
	    });
	    
	    return listcap;	

	}


	@Override
	public List<AddressDetails> listOfAddress(int empid) {
			
		String sql = query.listOfAddress(empid);
	    List<AddressDetails> listadd = jdbcTemplate.query(sql, new RowMapper<AddressDetails>() {
	 
	        @Override
	        public AddressDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	AddressDetails aAdd = new AddressDetails();
	        	aAdd.setId(rs.getInt("addressId"));
	        	aAdd.setStateId(rs.getInt("stateid"));
	        	aAdd.setEmpId(rs.getInt("empid"));
	        	aAdd.setCityId(rs.getInt("cityId"));
	        	aAdd.setCountryCode(rs.getInt("countryid"));
	        	aAdd.setDetails(rs.getString("addressdetails"));
	            return aAdd;
	        }
	    });
	    
	    return listadd;	
	}

	@Override
	public void addAdressDetails(AddressDetails add) {
		// TODO Auto-generated method stub
		String sql = query.addAdressDetails();
		jdbcTemplate.update(sql, add.getEmpId(),add.getCountryCode() ,add.getStateId(),add.getCityId(), add.getDetails());
		
	}

	@Override
	public void updateAddressDetails(AddressDetails add) {
		// TODO Auto-generated method stub
		
		
		String sql = query.updateAddressDetails();
    jdbcTemplate.update(sql, add.getCountryCode(), add.getStateId(),add.getCityId() ,add.getDetails(), add.getEmpId());

		
	}

	@Override
	public Country getCountry(int code) {
		// TODO Auto-generated method stub
		
		
		 String sql = query.getCountry(code);
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Country>() {
		 
		        @Override
		        public Country extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	Country coun = new Country();
		            	coun.setCountryCode(rs.getInt("countrycode"));
		            	coun.setName(rs.getString("name"));
		            
		                return coun;
		            }
		 
		            return null;
		        }
		 
		    });
	}

	@Override
	public States getState(int id) {

		
		 String sql = query.getState(id);
		    return jdbcTemplate.query(sql, new ResultSetExtractor<States>() {
		 
		        @Override
		        public States extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	States stat = new States();
		            	stat.setCountryCode(rs.getInt("countrycode"));
		            	stat.setName(rs.getString("name"));
		            	stat.setId(rs.getInt("id"));
		                return stat;
		            }
		 
		            return null;
		        }
		 
		    });

		
		
		
	}

	@Override
	public Capital getCity(int id) {


		String sql = query.getCity(id);
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Capital>() {
	 
	        @Override
	        public Capital extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Capital cap = new Capital();
	            	cap.setStateId(rs.getInt("stateid"));
	            	cap.setName(rs.getString("name"));
	            	cap.setId(rs.getInt("id"));
	                return cap;
	            }
	 
	            return null;
	        }
	 
	    });
		
		
		
	}
	
	
	

}
