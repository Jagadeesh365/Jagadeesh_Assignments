package com.springrest.springrest.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springrest.springrest.model.Numbers;
import com.springrest.springrest.services.CalculatorService;

@RestController
public class CalculatorController {

	@Autowired
	RestTemplate template;

	@Autowired
	CalculatorService calculatorService;

	@RequestMapping(value = "/consume/add", method = RequestMethod.POST)
	public String add(@RequestBody Numbers numbers) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Numbers> entity = new HttpEntity<>(numbers, headers);
		return template.exchange("http://localhost:8080/add", HttpMethod.POST, entity, String.class).getBody();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public long addition(@RequestBody Numbers numbers) {

		return calculatorService.add(numbers.getFirstNumber(), numbers.getSecondNumber());
	}
	
	@RequestMapping(value = "/consume/subtract", method = RequestMethod.POST)
	public String subtract(@RequestBody Numbers numbers) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Numbers> entity = new HttpEntity<>(numbers, headers);
		return template.exchange("http://localhost:8080/subtract", HttpMethod.POST, entity, String.class).getBody();
	}

	@RequestMapping(value = "/subtract", method = RequestMethod.POST)
	public long subtraction(@RequestBody Numbers numbers) {

		return calculatorService.subtract(numbers.getFirstNumber(), numbers.getSecondNumber());
	}
	
	

}
