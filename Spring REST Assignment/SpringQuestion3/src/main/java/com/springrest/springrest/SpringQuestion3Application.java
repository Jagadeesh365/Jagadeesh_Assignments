package com.springrest.springrest;

/*3) Create a RESTful web service that returns state, city and country information when user passes
zipcode. You can send state, city and country information in JSON format.
Sample Input: 99501
Sample output: {"state": "AK", City: "ANCHORAGE", "country: "US"}
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringQuestion3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuestion3Application.class, args);
	}

}
