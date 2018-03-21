package com.portal.web.service;

import java.util.List;

import com.portal.web.entity.Employee;
import com.portal.web.model.EmployeeModel;

public interface EmployeeService {
    Employee addEmployee(Employee Employee);
    void delete(long id);
    Employee getByEmployeename(String firstname);
    Employee getById(Long id);
    Employee editEmployee(Employee Employee);
    List<Employee> getAll();
    boolean isEmployeeExist(Employee Employee);
    EmployeeModel getEmployeeModelByfirstName(String firstname);
    List<EmployeeModel> getAllEmployeeModel();
}
