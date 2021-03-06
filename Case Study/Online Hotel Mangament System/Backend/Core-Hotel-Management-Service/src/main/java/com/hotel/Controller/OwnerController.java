package com.hotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.Model.Employee;
import com.hotel.Model.Report;
import com.hotel.Model.Show;
import com.hotel.Service.OwnerService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
	
	/* Owner Operations
	 * View Reports
	 * Insert Department
	 * Update Department Details
	 * Delete Department Details
	 */
	
	// ************************* Owner Operations ************************** // 
	
	@GetMapping("/getReports")
	public Report getReports()
	{
		return ownerService.getReports();
	}
	
	@PostMapping("/addEmployee")
	public Show addEmployee(@RequestBody Employee employee)
	{
		return ownerService.addEmployee(employee);
	}
	
	@PutMapping("/updateEmployee")
	public Show updateEmployee(@RequestBody Employee employee)
	{
		return ownerService.updateEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public Show deleteEmployeeById(@PathVariable String id)
	{
		return ownerService.deleteEmployeeById(id);
	}
}
