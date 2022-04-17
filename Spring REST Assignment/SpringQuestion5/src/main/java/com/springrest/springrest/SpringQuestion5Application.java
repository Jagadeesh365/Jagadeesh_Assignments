package com.springrest.springrest;

/*5) Develop RESTful web services for "Employee Management System" that manages the
information about employees
1. Add a new employee
2. Searching for specific employee
3. Deleting an existing employee
4. Finding all employees
5. Editing/updating employee information.
Create a Employee domain model class having following properties: employeeId,
employeeName, employeeDepartment, employeeDesignation, employeeSalary. Employee Id
should be generated automatically at database level.
Develop controller, service and repository layers classes.
Use CrudRepository from Spring Data.*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringQuestion5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuestion5Application.class, args);
	}

}
