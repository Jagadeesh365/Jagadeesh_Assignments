        
package com.employee.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.Model.Employee;
import com.employee.Model.Show;
import com.employee.Repository.EmployeeRepository;
import com.employee.Service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@MockBean
	private Show result;
    
	
	@Test
	public void testaddEmployee() {
		Employee employee = new Employee();
		Show result = new Show();
		result.setMessage("Success!, Employee Added");
		result.setRefId("E1");
		employee.setId("E1");
		employee.setName("ABCDEF");
		employee.setRole("RECEIPTIONIST");
		employee.setSalary(50000);
		employee.setPassword("qwerty");

		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(result.getRefId(), "E1");
		assertEquals(result.getMessage(), "Success!, Employee Added");
	}

	
	  @Test public void testgetAllEmployees() { Employee employee1 = new
	  Employee(); Show result1 = new Show();
	  result1.setMessage("Success!, Employee Added"); result1.setRefId("E1");
	  employee1.setId("E1"); employee1.setName("ABCDEF");
	  employee1.setRole("RECEIPTIONIST"); employee1.setSalary(50000);
	  employee1.setPassword("qwerty");
	  
	  Employee employee2 = new Employee(); Show result2 = new Show();
	  result2.setMessage("Success!, Employee Added"); result2.setRefId("E2");
	  employee2.setId("E2"); employee2.setName("ASDFGH");
	  employee2.setRole("MANAGER"); employee2.setSalary(100000);
	  employee2.setPassword("poiuyt");
	  
	  List<Employee> employeeList = new ArrayList<>(); employeeList.add(employee1);
	  employeeList.add(employee2);
	  
	  Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
	  assertThat(employeeService.getAllEmployees()).isEqualTo(employeeList); }
	
	  
	  
	  
	  
	  
	 
	  @Test public void testUpdateEmployee() { Employee employee = new Employee();
	  Show result = new Show();
	  result.setMessage("Success!, Employee Details Updated");
	  result.setRefId("E1"); employee.setId("E1"); employee.setName("ABCDEF");
	  employee.setRole("MANAGER"); employee.setSalary(50000);
	  employee.setPassword("qwerty");
	  
	  Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
	  assertEquals(result.getRefId(),"E1");
	  assertEquals(result.getMessage(),"Success!, Employee Details Updated"); }
	  
	  @Test public void testdeleteEmployee() { Optional<Employee> employee =
	  Optional.of(new Employee()); Show result = new Show();
	  result.setMessage("Success!, Employee Added"); result.setRefId("E1");
	  employee.get().setId("E1"); employee.get().setName("ABCDEF");
	  employee.get().setRole("MANAGER"); employee.get().setSalary(50000);
	  employee.get().setPassword("qwerty");
	  
	  Mockito.when(employeeRepository.findById("G1")).thenReturn(employee);
	  Mockito.when(employeeRepository.existsById(employee.get().getId())).
	  thenReturn(false);
	  assertFalse(employeeRepository.existsById(employee.get().getId())); }
	 

}
