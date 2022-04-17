package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entity.Country;

public interface CountryService {
	/* public List<Country> getCountries(); */
	public Country getCountryById(long zipCode);
}
