package com.portal.web.rest.api;

import java.util.ArrayList;
import java.util.List;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import com.portal.web.model.EmployeeModel;
import com.portal.web.rest.ResponseData;
import com.portal.web.rest.ResponseHandler;
import com.portal.web.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    ResponseData<List<EmployeeModel>> AllEmployee;
    
	@SuppressWarnings("rawtypes")
	@Autowired
    ResponseData Employee;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	 public ResponseHandler listAllEmployees()
	 {

    	  List<EmployeeModel> employees = employeeService.getAllEmployeeModel();
		  if (employees.isEmpty()) {
		      return new ResponseHandler(HttpStatus.NO_CONTENT);
	
		  }
	
		  logger.info("User: getting");
		  AllEmployee.setData(employees);
		  AllEmployee.setStatusCode("200");
		  return new ResponseHandler(AllEmployee,HttpStatus.OK);
	}	
    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
    public ResponseHandler getEmployeeByName(@PathVariable("name") String name) {
        EmployeeModel employee = employeeService.getEmployeeModelByfirstName(name);
        
        if (employee == null) {
            return new ResponseHandler(HttpStatus.NO_CONTENT);

        }
        	Employee.setData(employee);
        	Employee.setStatusCode("200");
        
        
            return new ResponseHandler(Employee,HttpStatus.OK);
    }
}
