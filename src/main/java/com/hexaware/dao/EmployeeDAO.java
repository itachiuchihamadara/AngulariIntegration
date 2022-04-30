package com.hexaware.dao;

import java.util.List;
import com.hexaware.model.*;
public interface EmployeeDAO {
		
    public void save(Employee emp);
    
    public void update(Employee emp);
    
    public void delete(int empId);
     
    public Employee get(int empId);
     
    public List<Employee> list();
    
   
    

}
