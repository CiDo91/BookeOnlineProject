package com.kireyest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kireyest.bean.Country;

@RestController
public class CountryController {
	@CrossOrigin("http://localhost:3000")
	 @RequestMapping(value = "/countries", method = RequestMethod.GET,headers="Accept=application/json")  
	 public List<Country> getCountries()  
	 {  
	  List<Country> listOfCountries = new ArrayList<Country>();  
	  listOfCountries=createCountryList();  
	  return listOfCountries;  
	  //Comment ss
	 }  
	  
	 @RequestMapping(value = "/country/{id}", method = RequestMethod.GET,headers="Accept=application/json")  
	 public Country getCountryById(@PathVariable int id)  
	 {  
	  List<Country> listOfCountries = new ArrayList<Country>();  
	  listOfCountries=createCountryList();  
	  
	  for (Country country: listOfCountries) {  
	   if(country.getId()==id)  
	    return country;  
	  }  
	    
	  return null;  
	 }
	 @CrossOrigin("http://localhost:3000")
	 @RequestMapping(value="/addcountries/", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE}, headers="Accept=application/json", produces={MediaType.APPLICATION_JSON_VALUE})
	 public Country addCountry(@RequestBody Country country){
		 System.out.println("Country ID:" + country.getId() + " , " + "Country NAME: " + country.getCountryName());
		 
		 return country;
	 }
	 
	 @CrossOrigin("http://localhost:3000")
	 @RequestMapping(value="/country/{id}", method=RequestMethod.DELETE, produces={"application/json"})
	 public List<Country> deleteCountry(@PathVariable int id){
		 List<Country> listOfCountries = this.getCountries();
		 for(Country country: listOfCountries){
			 if(country.getId() == id){
				 listOfCountries.remove(country);
				 System.out.println("The country with ID: " + country.getId() + " was been deleted");
				 return listOfCountries;
			 }
		 }
		 return null;
	 }
	  
	// Utiliy method to create country list.  
	 public List<Country> createCountryList()  
	 {  
	  Country indiaCountry=new Country(1, "India");  
	  Country chinaCountry=new Country(4, "China");  
	  Country nepalCountry=new Country(3, "Nepal");  
	  Country bhutanCountry=new Country(2, "Bhutan");  
	  
	  List<Country> listOfCountries = new ArrayList<Country>();  
	  listOfCountries.add(indiaCountry);  
	  listOfCountries.add(chinaCountry);  
	  listOfCountries.add(nepalCountry);  
	  listOfCountries.add(bhutanCountry);  
	  return listOfCountries;  
	 }
}
