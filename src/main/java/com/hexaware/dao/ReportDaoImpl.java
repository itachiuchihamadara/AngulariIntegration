package com.hexaware.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.hexaware.model.Employee;
import com.hexaware.model.Event;
import com.hexaware.model.Reports;
import com.hexaware.model.eventQueryParam;
import com.hexaware.sql.CRUD;

public class ReportDaoImpl implements ReportDAO{

private JdbcTemplate jdbcTemplate;
	

	@Autowired
	private CRUD query;
	public ReportDaoImpl(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int insertReport(Reports report) {
		String sql = query.saveReport();
		jdbcTemplate.update(sql, report.getStartDate(), report.getEndDate(), 
			report.getType());
		
		sql = query.getNoOfReportRows();
		  return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
				 
		        @Override
		        public Integer extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	return rs.getInt("id");
		            }
		            return null;
		        }
		    });
		
		
	}

	@Override
	public void insertEvent(Event event) {
		
			String sql = query.saveEvent();
			jdbcTemplate.update(sql,event.getStatus(), event.getOptId(), event.getFinalQuery());
	}

	@Override
	public void insertEventParam(eventQueryParam param) {
		String sql = query.saveParam();
		jdbcTemplate.update(sql, param.getEventId(), param.getQueryVal());
	}
	
	@Override
	public int noOfRows() {
		String sql = query.getNoOfEventRows();
		  return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
				 
		        @Override
		        public Integer extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	return rs.getInt("id");
		            }
		            return null;
		        }
		    });
	}

}
