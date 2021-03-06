package com.hotel.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.Model.Employee;
import com.hotel.Model.Room;
import com.hotel.Model.RoomDetails;
import com.hotel.Model.Show;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ManagerService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Logger logger;

	public String roomApi = "room-management-service";

	// ************************* API Calls To Room Management Service ********************* //

	public String ADD_ROOM = "http://" + roomApi + "/addRoom";
	public String ADD_MULTIPLE_ROOMS = "http://" + roomApi + "/addMultiple/{type}/{count}";
	public String GET_ROOM_BY_ID = "http://" + roomApi + "/getRoom/{id}";
	public String GET_ROOM_BY_TYPE = "http://" + roomApi + "/getAllRoomsByType/{type}";
	public String GET_ROOM_BY_STATUS = "http://" + roomApi + "/getAllRoomsByStatus/{status}";
	public String GET_ALL_AVAILABLE_ROOMS = "http://" + roomApi + "/getAllAvailableRooms";
	public String GET_ALL_BOOKED_ROOMS = "http://" + roomApi + "/getAllBookedRooms";
	public String UPDATE_ROOM = "http://" + roomApi + "/updateRoom";
	public String DELETE_ROOM = "http://" + roomApi + "/deleteRoom/{id}";
	public String ADD_NEWROOM_TYPE = "http://" + roomApi + "/addRoomType";
	public String GET_ALL_ROOMTYPES = "http://" + roomApi + "/getAllTypes";
	public String DELETE_ROOMTYPE = "http://" + roomApi + "/deleteRoomType/{type}";
	public String GET_REPORT = "http://" + roomApi + "/getReports";
	public String GET_ALL_ROOMS= "http://" + roomApi + "/getAllRooms";

	// ************************* API Calls To Room Management Service Ends Here ********************* //

	public String employeeApi = "employee-management-service";

	// ************************* API Calls to Employee Management Service ********************* //

	public String ADD_EMPLOYEE = "http://" + employeeApi + "/addEmployee";
	public String GET_ALL_EMPLOYEES = "http://" + employeeApi + "/getAllEmployees";
	public String GET_EMPLOYEE_BY_ID = "http://" + employeeApi + "/getEmployeeById/{id}";
	public String GET_EMPLOYEE_BY_NAME = "http://" + employeeApi + "/getEmployeeByName/{name}";
	public String GET_EMPLOYEE_BY_ROLE = "http://" + employeeApi + "/getEmployeeByRole/{role}";
	public String UPDATE_EMPLOYEE = "http://" + employeeApi + "/updateEmployee";
	public String DELETE_EMPLOYEE = "http://" + employeeApi + "/deleteEmployee/{id}";

	// ************************* API Calls to Employee Management Service Ends Here ********************* //

	// Adding a New Room
	@HystrixCommand(fallbackMethod = "addRoomFallback")
	public Show addRoom(Room room)
	{
		return restTemplate.postForObject(ADD_ROOM, room, Show.class);
	}

	// AddRoom - Fallback
	public Show addRoomFallback(Room room)
	{
		return getShowFallback();
	}

	// Adding Multiple Rooms
	@HystrixCommand(fallbackMethod = "addMultipleRoomsFallback")
	public Show addMultipleRooms(int count, String type)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		Show result = restTemplate.postForObject(ADD_MULTIPLE_ROOMS, httpEntity, Show.class, count, type);
		return result;
	}

	// Adding Multiple Rooms- Fallback
	public Show addMultipleRoomsFallback(int count, String type)
	{
		return getShowFallback();
	}

	// Updating Room
	@HystrixCommand(fallbackMethod = "updateRoomDetailsFallback")
	public Show updateRoomDetails(Room room)
	{
		if(room.getId()==null)
		{
			return new Show("Invalid Id","Enter a proper Id");
		}

		RequestEntity<Room> requestEntity = RequestEntity.put(UPDATE_ROOM).accept(MediaType.APPLICATION_JSON).body(room);
		ResponseEntity<Show> updatedResult = restTemplate.exchange(requestEntity, Show.class);
		return updatedResult.getBody();
	}

	// Updating Room - Fallback
	public Show updateRoomDetailsFallback(Room room)
	{
		return getShowFallback();
	}

	// Delete Room
	@HystrixCommand(fallbackMethod = "deleteRoomByIdFallback")
	public Show deleteRoomById(String id)
	{
		ResponseEntity<Show> result = delete(DELETE_ROOM,id);
		return result.getBody();
	}

	// Delete Room- Fallback
	public Show deleteRoomByIdFallback(String id)
	{
		return getShowFallback();
	}

	// Add Room Type
	@HystrixCommand(fallbackMethod = "addRoomTypeFallback")
	public Show addRoomType(RoomDetails roomDetails)
	{
		RequestEntity<RoomDetails> requestEntity = RequestEntity.post(ADD_NEWROOM_TYPE) .accept(MediaType.APPLICATION_JSON).body(roomDetails);
		ResponseEntity<Show> result = restTemplate.exchange(requestEntity,Show.class);
		return result.getBody();
	}

	// Add Room Type - Fallback
	public Show addRoomTypeFallback(RoomDetails roomDetails)
	{
		return getShowFallback();
	}

	// Delete Room Type
	@HystrixCommand(fallbackMethod = "deleteRoomTypeFallback")
	public Show deleteRoomType(String type)
	{
		ResponseEntity<Show> result = delete(DELETE_ROOMTYPE,type);
		return result.getBody();
	}

	// Delete Room Type -Fallback
	public Show deleteRoomTypeFallback(String type)
	{
		return getShowFallback();
	}


	// ******************************* Room Methods End Here ***************************************//


	//Add New Employee
	@HystrixCommand(fallbackMethod = "addEmployeeFallback")
	public Show addEmployee(Employee employee)
	{
		if(employee.getRole().equalsIgnoreCase("OWNER"))
		{
			return new Show("Invalid Action!","You are not authorized to perform this action");
		}

		Show result = restTemplate.postForObject(ADD_EMPLOYEE, employee, Show.class);
		return result;
	}

	//Add New Employee - Fallback
	public Show addEmployeeFallback(Employee employee)
	{
		return getShowFallback();
	}


	// Update Employee
	@HystrixCommand(fallbackMethod = "updateEmployeeFallback")
	public Show updateEmployee(Employee employee)
	{
		if(employee.getId()==null)
		{
			return new Show("Invalid Id!"," Enter a proper Id");
		}

		if(employee.getRole().equalsIgnoreCase("OWNER"))
		{
			return new Show("Invalid Request!"," You are not authorized to perform this action");
		}
		
		Employee resource = getEmployeeById(employee.getId());
		if(resource.getRole().equalsIgnoreCase("OWNER")
				&& (employee.getRole().equalsIgnoreCase("MANAGER") || employee.getRole().equalsIgnoreCase("RECEPTIONIST"))) {
			return new Show("Invalid Request!", " You are not authorized to perform this action");
		}
		
		RequestEntity<Employee> requestEntity = RequestEntity.put(UPDATE_EMPLOYEE).accept(MediaType.APPLICATION_JSON).body(employee);
		ResponseEntity<Show> result = restTemplate.exchange(requestEntity, Show.class);
		return result.getBody();
	}

	// Update Employee - Fallback
	public Show updateEmployeeFallback(Employee employee)
	{
		return getShowFallback();
	}

	// Delete Employee - Manager is not Allowed to delete employees with role as Owner
	//@HystrixCommand(fallbackMethod = "deleteEmployeeByIdFallback")
	public Show deleteEmployeeById(String id)
	{
		Employee employee = getEmployeeById(id);
		if(employee.getRole().equalsIgnoreCase("OWNER"))
		{
			return new Show("Invalid Request!","You are not authorized to perform this action");
		}

		ResponseEntity<Show> result = delete(DELETE_EMPLOYEE, id);
		return result.getBody();
	}

	/*// Delete Employee - Fallback
	public Show deleteEmployeeByIdFallback(String id)
	{
		return getShowFallback();
	}*/

	// Get All Employees
	@HystrixCommand(fallbackMethod = "getAllEmployeesFallback")
	public List<Employee> getAllEmployees()
	{
		ResponseEntity<Object[]> employees = restTemplate.getForEntity(GET_ALL_EMPLOYEES, Object[].class);
		ObjectMapper mapper = new ObjectMapper();

		List<Employee> employeeList = Arrays.stream(employees.getBody()).map(e->mapper.convertValue(e,Employee.class)).collect(Collectors.toList());
		return employeeList;	
	}

	// Get All Employees - Fallback
	public List<Employee> getAllEmployeesFallback()
	{
		return getListFallback();
	}

	// Get Employee By Id
	// @HystrixCommand(fallbackMethod = "getEmployeeByIdFallback")
	public Employee getEmployeeById(String id)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = GET_EMPLOYEE_BY_ID;

		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<Employee> employee = restTemplate.exchange(url,HttpMethod.GET, httpEntity,Employee.class,id);
		return employee.getBody();
	}
	/*
	// Get Employee By Id - Fallback
	public Employee getEmployeeByIdFallBack(String id)
	{
		logger.error("Service Down");
		return null;
	}
	*/

	// Get Employee By Name
	@HystrixCommand(fallbackMethod = "getEmployeeByNameFallback")
	public List<Employee> getEmployeeByName(String name)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = GET_EMPLOYEE_BY_NAME;

		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<Employee[]> employees = restTemplate.exchange(url,HttpMethod.GET, httpEntity,Employee[].class,name);
		Employee[] allEmployees = employees.getBody();

		ObjectMapper mapper = new ObjectMapper();
		List<Employee> employeeList = Arrays.stream(allEmployees).map(e->mapper.convertValue(e, Employee.class)).collect(Collectors.toList());
		return employeeList;
	}

	// Get Employee By Name - Fallback
	public List<Employee> getEmployeeByNameFallback(String name)
	{
		return getListFallback();
	}

	// Get Employee By Role
	@HystrixCommand(fallbackMethod = "getEmployeeByRoleFallback")
	public List<Employee> getEmployeeByRole(String role){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = GET_EMPLOYEE_BY_ROLE;

		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<Employee[]> employees = restTemplate.exchange(url,HttpMethod.GET, httpEntity,Employee[].class,role);
		Employee[] allEmployees = employees.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<Employee> employeeList = Arrays.stream(allEmployees).map(e->mapper.convertValue(e, Employee.class)).collect(Collectors.toList());
		return employeeList;
	}

	// Get Employee By Role - Fallback
	public List<Employee> getEmployeeByRoleFallback(String role)
	{
		return getListFallback();
	}

	// ******************************* Employee Methods End Here ***************************************//


	// Common Code to implement delete methods
	@HystrixCommand(fallbackMethod = "deleteFallback")
	public ResponseEntity<Show> delete(String url,String value)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<Show> result = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Show.class, value);
		return result;
	}

	// Common code to implement Fallback 
	public Show getShowFallback()
	{
		logger.error("Service Down");
		return new Show("Fallback!"," Service Down! Try again");
	}

	public List<Employee> getListFallback()
	{
		logger.error("Service Down");
		return null;
	}

	public ResponseEntity<Show> deleteFallback(String url, String value)
	{
		Show result = getShowFallback();
		return ResponseEntity.ok(result);
	}
}
