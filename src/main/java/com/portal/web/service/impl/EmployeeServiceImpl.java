package com.portal.web.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.web.entity.Employee;
import com.portal.web.model.EmployeeModel;
import com.portal.web.repository.EmployeeRepository;
import com.portal.web.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    
	@Override
	public Employee addEmployee(Employee Employee) {
		Employee savedEmployee = employeeRepository.saveAndFlush(Employee);
		return savedEmployee;
	}

	@Override
	public void delete(long id) {
		employeeRepository.delete(id);
		
	}

	@Override
	public Employee getByEmployeename(String firstname) {

		return employeeRepository.findByEmployeename(firstname);
	}



	@Override
	public Employee getById(Long id) {

		return employeeRepository.findById(id);
	}

	@Override
	public Employee editEmployee(Employee Employee) {
		
		return employeeRepository.saveAndFlush(Employee);
	}

	@Override
	public List<Employee> getAll() {
	
		return employeeRepository.findAll();
	}

	@Override
	public boolean isEmployeeExist(Employee Employee) {
		
		return getByEmployeename(Employee.getFirstName()) != null;
	}

	@Override
	public EmployeeModel getEmployeeModelByfirstName(String firstname) {
		Employee employee = employeeRepository.findByEmployeename(firstname);
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setFirstname(employee.getFirstName());
		employeeModel.setLastname(employee.getLastName());
		employeeModel.setDescription(employee.getDescription());
		return employeeModel;
	}

	@Override
	public List<EmployeeModel> getAllEmployeeModel() {
		
		List<EmployeeModel> allEmployee = new ArrayList<EmployeeModel>();
		
		List<Employee> employees=employeeRepository.findAll();
		
		for(Employee employee:employees)
		{
			EmployeeModel employeeModel = new EmployeeModel();
			employeeModel.setFirstname(employee.getFirstName());
			employeeModel.setLastname(employee.getLastName());
			employeeModel.setDescription(employee.getDescription());
			allEmployee.add(employeeModel);
		}
		
		return allEmployee;
	}
	
	

}
