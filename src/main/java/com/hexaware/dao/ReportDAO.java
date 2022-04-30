package com.hexaware.dao;
import com.hexaware.model.*;

public interface ReportDAO {
	
	public int insertReport(Reports report);
	
	public void insertEvent(Event event);
	
	public void insertEventParam(eventQueryParam param);
	
	public int noOfRows();
	
	

}
