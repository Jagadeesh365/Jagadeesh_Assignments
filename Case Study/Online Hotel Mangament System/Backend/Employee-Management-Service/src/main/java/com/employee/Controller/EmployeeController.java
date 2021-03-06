package com.employee.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Exception.ResourceNotFoundException;
import com.employee.Model.Employee;
import com.employee.Model.Show;
import com.employee.Service.EmployeeService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping("/addEmployee")
	public Show addEmployee(@RequestBody Employee employee)
	{
		logger.info("Inside addEmployee() method of EmployeeController");
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees()
	{
		logger.info("Inside getAllEmployees() method of EmployeeController");
		return employeeService.getAllEmployees();
	}
	
	
 	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable String id)
	{	
 		logger.info("Inside getEmployeeById() method of EmployeeController");
		return employeeService.getEmployeeById(id);
	}

	/*
	 * // orElseThrow is not Working
	 * 
	 * @GetMapping("/getEmployeeById/{id}") public ResponseEntity<Employee>
	 * getEmployeeById(@PathVariable String id) throws ResourceNotFoundException {
	 * Employee employee = employeeService.getEmployeeById(id) .orElseThrow(() ->
	 * new ResourceNotFoundException("Employee not found for this id :: " + id));
	 * return ResponseEntity.ok().body(employee); }
	 */

	@GetMapping("/getEmployeeByName/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name)
	{	
		logger.info("Inside getEmployeeByName() method of EmployeeController");
		return employeeService.getEmployeeByName(name);
	}
	
	@GetMapping("/getEmployeeByRole/{role}")
	public List<Employee> getEmployeeByRole(@PathVariable String role)
	{	
		logger.info("Inside getEmployeeByRole() method of EmployeeController");
		return employeeService.getEmployeeByRole(role);
	}
	
	@PutMapping("/updateEmployee")
	public Show updateEmployee(@RequestBody Employee employee)
	{	
		logger.info("Inside updateEmployee() method of EmployeeController");
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public Show deleteEmployee(@PathVariable String id)
	{	
		logger.info("Inside deleteEmployee() method of EmployeeController");
		return employeeService.deleteEmployee(id);
	}
	
	
}
