package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(long id);

	void deleteEmployee(long id);

	List<Employee> getAllEmployees();

	Employee updateEmployee(Employee employee, long id);

}
