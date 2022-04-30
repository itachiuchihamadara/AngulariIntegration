package com.hexaware.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.hexaware.model.*;
import com.hexaware.sql.CRUD;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import com.hexaware.dao.*;


public class EmployeeDAOImpl implements EmployeeDAO{
 
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CRUD query;
	

public EmployeeDAOImpl(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
}


	public void save(Employee emp) {
		
		 String sql = query.saveEmployee();
     jdbcTemplate.update(sql, emp.getId(), emp.getDateOfJoin(), emp.getName(), emp.getEmail(),
    		 emp.getAddress(), emp.getTelephone());
	}
	
	public void update(Employee emp) {
		String sql = query.updateEmployee();
    jdbcTemplate.update(sql, emp.getName(), emp.getEmail(),
    		emp.getAddress(), emp.getTelephone(), emp.getDateOfJoin(), emp.getId());

	}

	public void delete(int empId) {
		// TODO Auto-generated method stub
	    String sql = query.deleteEmployee();
	    jdbcTemplate.update(sql, empId);
	}

	public Employee get(int empId) {
		// TODO Auto-generated method stub
		 String sql = query.getEmployeeById(empId);
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
		 
		        @Override
		        public Employee extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	Employee emp = new Employee();
		            	emp.setId(rs.getInt("id"));
		            	emp.setName(rs.getString("name"));
		            	emp.setEmail(rs.getString("email"));
		            	emp.setAddress(rs.getString("address"));
		            	emp.setTelephone(rs.getString("telephone"));
		            	emp.setDateOfJoin(rs.getString("dateOfJoin"));
		                return emp;
		            }
		 
		            return null;
		        }
		 
		    });
	}

	public List<Employee> list() {
		// TODO Auto-generated method stub
		String sql = query.listEmployees();
	    List<Employee> listEmp = jdbcTemplate.query(sql, new RowMapper<Employee>() {
	 
	        @Override
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Employee aEmp = new Employee();
	        	aEmp.setId(rs.getInt("id"));
	        	aEmp.setName(rs.getString("name"));
	        	aEmp.setEmail(rs.getString("email"));
	        	aEmp.setAddress(rs.getString("address"));
	        	aEmp.setTelephone(rs.getString("telephone"));
	        	aEmp.setDateOfJoin(rs.getString("dateOfJoin"));
	            return aEmp;
	        }
	    });
	    
	    return listEmp;
	}


	

}
