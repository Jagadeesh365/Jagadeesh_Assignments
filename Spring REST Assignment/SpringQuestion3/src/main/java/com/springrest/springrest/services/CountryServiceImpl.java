package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entity.Country;

@Service
public class CountryServiceImpl implements CountryService {

	List<Country> countryList;

	public CountryServiceImpl() {
		countryList = new ArrayList(Arrays.asList(
				new Country(1171, "Kavali", "Tamil Nadu", "US"),
				new Country(1172, "Nellore", "Andhra Pradesh", "India"), 
				new Country(1173, "Jalandhar", "Telangana", "India"),
				new Country(1174, "Ongole", "Andhra Pradesh", "India"),
				new Country(1175, "Warangal", "Uttar pradesh", "India")));

	}

	/*
	 * @Override public List<Country> getCountries() { return countryList; }
	 */

	@Override
	public Country getCountryById(long zipCode) {
		for (Country country : countryList) {
			if (country.getZipcode() == zipCode) {
				return country;
			}
		}
		return null;
	}

}
