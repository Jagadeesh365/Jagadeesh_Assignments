package com.hotel.Service;

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

import com.hotel.Model.Employee;
import com.hotel.Model.Report;
import com.hotel.Model.Show;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class OwnerService {

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

	// ************************* API Calls To Room Management Service Ends Here *************** //

	public String employeeApi = "employee-management-service";

	// ************************* API Calls to Employee Management Service ********************* //

	public String ADD_EMPLOYEE = "http://" + employeeApi + "/addEmployee";
	public String GET_ALL_EMPLOYEES = "http://" + employeeApi + "/getAllEmployees";
	public String GET_EMPLOYEE_BY_ID = "http://" + employeeApi + "/getEmployeeById/{id}";
	public String GET_EMPLOYEE_BY_NAME = "http://" + employeeApi + "/getEmployeeByName/{name}";
	public String GET_EMPLOYEE_BY_ROLE = "http://" + employeeApi + "/getEmployeeByRole/{role}";
	public String UPDATE_EMPLOYEE = "http://" + employeeApi + "/updateEmployee";
	public String DELETE_EMPLOYEE = "http://" + employeeApi + "/deleteEmployee/{id}";

	// ************************* API Calls to Employee Management Service Ends Here *********** //

	public String guestApi = "guest-management-service";

	// ************************* API Calls to Guest Management Service ************************ // 

	public String ADD_GUEST = "http://" + guestApi + "/addGuest";
	public String GET_ALL_GUESTS = "http://" + guestApi + "/getAllGuests";
	public String GET_GUEST_BY_ID = "http://" + guestApi + "/getGuestById/{id}";
	public String GET_GUEST_BY_NAME = "http://" + guestApi + "/getGuestByName/{name}";
	public String GET_GUEST_BY_STATUS = "http://" + guestApi + "/getGuestByStatus/{status}";
	public String UPDATE_GUEST = "http://" + guestApi + "/updateGuest";
	public String DELETE_GUEST = "http://" + guestApi + "/deleteGuest/{id}";
	
	// ************************* API Calls to Guest Management Service Ends Here ************** //
	
	// Get the generated report
	@HystrixCommand(fallbackMethod = "getReportsFallback")
	public Report getReports()
	{
		Report report = restTemplate.getForObject(GET_REPORT, Report.class);
		return report;
	}
	
	// Get the generated report - Fallback
	public Report getReportsFallback()
	{
		logger.error("Service Down");
		return new Report();
	}
	
	/* Owner Privileges- add Manager, add Receptionist, add Owner
	 * Add Employee
	 */
	@HystrixCommand(fallbackMethod = "addEmployeeFallback")
	public Show addEmployee(Employee employee)
	{
		Show result = restTemplate.postForObject(ADD_EMPLOYEE, employee, Show.class);
		return result;
	}
	
	// Add Employee - Fallback
	public Show addEmployeeFallback(Employee employee)
	{
		logger.error("Service Down");
		return new Show("Fallback!"," Try again");
	}
	
	// Update Employee
	@HystrixCommand(fallbackMethod = "updateEmployeeFallback")
	public Show updateEmployee(Employee employee)
	{
		if(employee.getId().equals(null))
		{
			return new Show("Invalid Id! ","Enter a proper Id");
		}
		
		RequestEntity<Employee> requestEntity = RequestEntity.put(UPDATE_EMPLOYEE).accept(MediaType.APPLICATION_JSON).body(employee);
		ResponseEntity<Show> result = restTemplate.exchange(requestEntity,Show.class);
		return result.getBody();
	}
	
	// Update Employee - Fallback
	public Show updateEmployeeFallback(Employee employee)
	{
		logger.error("Service Down");
		return new Show("Fallback!"," Try again");
	}
	
	// Delete Employee
	@HystrixCommand(fallbackMethod = "deleteEmployeeByIdFallback")
	public Show deleteEmployeeById(String id)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = DELETE_EMPLOYEE;
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<Show> result = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Show.class, id);
		
		return  result.getBody();
	}
	
	// Delete Employee - Fallback
	public Show deleteEmployeeByIdFallback(String id)
	{
		logger.error("Service Down");
		return new Show("Fallback!"," Try again");
	}
}
