package com.employee.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="EmployeeInventory")
public class Employee {

	
	@Id
	private String id;
	private String url;
	private String name;
	private String password;
	private String role;
	private long salary;
	private String email;
	private String country;
	private String state;
	private String city;
	private String street;
	private String zipcode;
	private long mobileNo;
	
	//Default
	public Employee()
	{
		
	}
	
	//For Post Method
	
	public Employee(String url, String name, String password, String role, long salary, String email, String country,
			String state, String city, String street, String zipcode, long mobileNo) {
		super();
		this.url = url;
		this.name = name;
		this.password = password;
		this.role = role;
		this.salary = salary;
		this.email = email;
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.mobileNo = mobileNo;
	

	}
	
	//For Update Method
	
	
	public Employee(String id, String url, String name, String password, String role, long salary, String email,
			String country, String state, String city, String street, String zipcode, long mobileNo) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
		this.password = password;
		this.role = role;
		this.salary = salary;
		this.email = email;
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.mobileNo = mobileNo;
	}

	
	//Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	
	
	
}
