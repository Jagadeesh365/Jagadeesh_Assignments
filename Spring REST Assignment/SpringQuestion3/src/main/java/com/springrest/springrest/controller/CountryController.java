package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Country;
import com.springrest.springrest.services.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	/*
	 * @GetMapping("/country") public List<Country> getCountry() { return
	 * this.countryService.getCountries(); }
	 */
	
	@GetMapping("/country/{zipCode}")
	public Country getCountry(@PathVariable String zipCode) {
		return this.countryService.getCountryById(Long.parseLong(zipCode));
	}
	
}
