package com.hexaware.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.hexaware.model.Employee;
import com.hexaware.model.Login;

public class LoginDAOImpl implements LoginDAO{

	private JdbcTemplate jdbcTemplate;
	

	public LoginDAOImpl(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public Login getPassword(int admid) {
		String sql = "SELECT * FROM Login WHERE admid=" + admid;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Login>() {
	 
	        @Override
	        public Login extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Login log = new Login();
	            	log.setAdmid(rs.getInt("admid"));
	            	log.setPasswrd(rs.getString("passwrd"));
	                return log;
	            }
	 
	            return null;
	        }
	 
	    });
	}
	

}
