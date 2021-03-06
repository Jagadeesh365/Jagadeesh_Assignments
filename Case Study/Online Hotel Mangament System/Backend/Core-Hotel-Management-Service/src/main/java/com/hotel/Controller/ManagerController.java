package com.hotel.Controller;

import java.util.List;

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
import com.hotel.Model.Room;
import com.hotel.Model.RoomDetails;
import com.hotel.Model.Show;
import com.hotel.Service.ManagerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	/* Manager Operations 
	 * Add- Room/Employee/Inventory  
	 * Update- Room/Employee/Inventory
	 * Delete- Room/Employee/Inventory
	 * Cannot do Operations that include Employee Roles as Owner- For Eg: Cannot delete owner
	 */
	
	// ************************** Manager Add Operations ***************** //
	@PostMapping("/addRoom")
	public Show addRoom(@RequestBody Room room)
	{
		return managerService.addRoom(room);
	}
	
	@PostMapping("/addMultiple/{type}/{count}")
	public Show addMultipleRooms(@PathVariable int count, @PathVariable String type)
	{
		return managerService.addMultipleRooms(count, type);
	}
	
	@PostMapping("/addRoomType")
	public Show addRoomType(@RequestBody RoomDetails roomDetails)
	{
		return managerService.addRoomType(roomDetails);
	}
	
	@PostMapping("/addEmployee")
	public Show addEmployee(@RequestBody Employee employee)
	{
		return managerService.addEmployee(employee);
	}
	
	// ************************** Manager Update Operations *************** //
	
	@PutMapping("/updateRoom")
	public Show updateRoom(@RequestBody Room room)
	{
		return managerService.updateRoomDetails(room);
	}
	
	/* Here add method is used for both creation and updation- Room Management Service 
	 * If roomType is already present in the database then it updates the price
	 */
	@PutMapping("/updateRoomDetails")
	public Show updateRoomDetails(@RequestBody RoomDetails roomDetails)
	{
		return managerService.addRoomType(roomDetails);
	}
	
	@PutMapping("/updateEmployee")
	public Show updateEmployee(@RequestBody Employee employee)
	{
		return managerService.updateEmployee(employee);
	}
	
	// ************************** Manager Delete Operations *************** //
	
	@DeleteMapping("/deleteEmployee/{id}")
	public Show deleteEmployeeById(@PathVariable String id)
	{
		return managerService.deleteEmployeeById(id);
	}
	
	@DeleteMapping("/deleteRoom/{id}")
	public Show deleteRoomById(@PathVariable String id)
	{
		return managerService.deleteRoomById(id);
	}
	
	@DeleteMapping("/deleteRoomType/{type}")
	public Show deleteRoomType(@PathVariable String type)
	{
		return managerService.deleteRoomType(type);
	}
	
	// ************************** Manager GET Operations *************** //
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployees()
	{
		return managerService.getAllEmployees();
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable String id)
	{
		return managerService.getEmployeeById(id);
	}
	
	@GetMapping("/getEmployeeByName/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name)
	{
		return managerService.getEmployeeByName(name);
	}
	
	@GetMapping("/getEmployeeByRole/{role}")
	public List<Employee> getEmployeeByRole(@PathVariable String role)
	{
		return managerService.getEmployeeByRole(role);
	}
}
