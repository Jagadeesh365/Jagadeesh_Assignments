package com.springrest.springrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
