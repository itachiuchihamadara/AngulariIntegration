package com.hexaware.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hexaware.dao.AddressDAO;
import com.hexaware.dao.EmployeeDAO;
import com.hexaware.dao.LoginDAO;
import com.hexaware.dao.ReportDAO;
import com.hexaware.model.*;
@Controller
public class WebController {
	
	@Autowired
	private EmployeeDAO empDao;
	
	@Autowired
	private AddressDAO addDAO;
	
	@Autowired
	private LoginDAO logDAO;
	
	@Autowired
	private ReportDAO repDAO;
	
	@RequestMapping(value="/View")
	@ResponseBody
	public List<Employee> listEmployee() throws IOException{
	    List<Employee> listemployee = empDao.list();
	    return listemployee;
		}
	
	
	@RequestMapping(value = "/**/{[path:[^\\.]*}")
    public String redirect() {
    
        return "forward:/resources/index.html";
    }

	
	@RequestMapping(value="/deleteEmployeeById", method = RequestMethod.GET)
	@ResponseBody
	void deleteEmloyeerById(@RequestParam(value = "id")  int empId) {
			empDao.delete(empId);
	}
	
	@RequestMapping("/getEmployeeById")
	@ResponseBody
	Employee getEmployeeById(@RequestParam(value = "id")  int empId) {
			return empDao.get(empId);
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	@ResponseBody
	public void saveEmployee(@RequestBody Employee emp) {
		empDao.save(emp);
	   // return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	@ResponseBody
	public void updateEmployee(@RequestBody Employee emp) {
		empDao.update(emp);
	   // return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/listCountries", method = RequestMethod.GET)
	@ResponseBody
	public List<Country> listOfCountries(){
		return addDAO.listOfCountries();
	}
	@RequestMapping(value = "/countriesByState", method = RequestMethod.GET)
	@ResponseBody
	public List<States> listOfStates(@RequestParam(value="code") int code){
		return addDAO.listOfStatesByCountry(code);
	}
	
	@RequestMapping(value = "/countryByCode", method = RequestMethod.GET)
	@ResponseBody
	public Country countryCode(@RequestParam(value="code") int code){
		return addDAO.getCountry(code);
	}
	@RequestMapping(value = "/stateById", method = RequestMethod.GET)
	@ResponseBody
	public States stateId(@RequestParam(value="id") int id){
		return addDAO.getState(id);
	}
	@RequestMapping(value = "/capitalById", method = RequestMethod.GET)
	@ResponseBody
	public Capital capitalId(@RequestParam(value="id") int id){
		return addDAO.getCity(id);
	}
	
	
	@RequestMapping(value = "/citiesByState", method = RequestMethod.GET)
	@ResponseBody
	public List<Capital> listOfCities(@RequestParam(value="stateid") int statid){
		return addDAO.listOfCitiesByState(statid);
	}
	@RequestMapping(value = "/addressDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<AddressDetails> Details(@RequestParam(value="empid") int empid){
		return addDAO.listOfAddress(empid);
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> Login(@RequestBody Login log){
		HashMap<String, String> res = new HashMap<>();
		
		try {
		if(log.getPasswrd().equals(logDAO.getPassword(log.getAdmid()).getPasswrd())){
			res.put("login", "true");
		    return res;
		    
		}
		else
		{
			res.put("login", "false");
	        return res;
	}
	}
	
	catch(Exception e) {
		e.printStackTrace();
		res.put("login", "false");
	    return res;
	    
	}
	}
	@RequestMapping(value = "/addAddressDetails", method = RequestMethod.POST)
	@ResponseBody
	public void addAddress(@RequestBody AddressDetails add) {
		addDAO.addAdressDetails(add);
	}
	@RequestMapping(value = "/updateAddressDetails", method = RequestMethod.POST)
	@ResponseBody
	public void updateAddress(@RequestBody AddressDetails add) {
		addDAO.updateAddressDetails(add);
	}
	@RequestMapping(value = "/savereport", method = RequestMethod.POST)
	@ResponseBody
	public int saveReport(@RequestBody Reports report) {
			return repDAO.insertReport(report);
	}
	@RequestMapping(value = "/saveevent", method = RequestMethod.POST)
	@ResponseBody
	public void saveEvent(@RequestBody Event event) {
			repDAO.insertEvent(event);
	}
	@RequestMapping(value = "/noofrows", method = RequestMethod.GET)
	@ResponseBody
	public int getNoOfRows() {
		return repDAO.noOfRows();
	}
	@RequestMapping(value = "/saveparam", method = RequestMethod.POST)
	@ResponseBody
	public void saveParam(@RequestBody eventQueryParam param) {
			repDAO.insertEventParam(param);
	}
	
	
	
}
