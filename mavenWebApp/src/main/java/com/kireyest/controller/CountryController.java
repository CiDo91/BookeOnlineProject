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

import com.kireyest.bean.Books;

@RestController
public class CountryController {
	@CrossOrigin("http://localhost:3000")
	 @RequestMapping(value = "/countries", method = RequestMethod.GET,headers="Accept=application/json")  
	 public List<Books> getCountries()  
	 {  
	  List<Books> listOfCountries = new ArrayList<Books>();  
	  listOfCountries=createCountryList();  
	  return listOfCountries;  
	  //Comment ss
	 }  
	  
	 @RequestMapping(value = "/country/{id}", method = RequestMethod.GET,headers="Accept=application/json")  
	 public Books getCountryById(@PathVariable int id)  
	 {  
	  List<Books> listOfCountries = new ArrayList<Books>();  
	  listOfCountries=createCountryList();  
	  
	  for (Books country: listOfCountries) {  
	   if(country.getId()==id)  
	    return country;  
	  }  
	    
	  return null;  
	 }
	 @CrossOrigin("http://localhost:3000")
	 @RequestMapping(value="/addcountries/", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE}, headers="Accept=application/json", produces={MediaType.APPLICATION_JSON_VALUE})
	 public Books addCountry(@RequestBody Books country){
		 System.out.println("Country ID:" + country.getId() + " , " + "Country NAME: " + country.getCountryName());
		 
		 return country;
	 }
	 
	 @CrossOrigin("http://localhost:3000")
	 @RequestMapping(value="/country/{id}", method=RequestMethod.DELETE, produces={"application/json"})
	 public List<Books> deleteCountry(@PathVariable int id){
		 List<Books> listOfCountries = this.getCountries();
		 for(Books country: listOfCountries){
			 if(country.getId() == id){
				 listOfCountries.remove(country);
				 System.out.println("The country with ID: " + country.getId() + " was been deleted");
				 return listOfCountries;
			 }
		 }
		 return null;
	 }
	  
	// Utiliy method to create country list.  
	 public List<Books> createCountryList()  
	 {  
	  Books indiaCountry=new Books(1, "India");  
	  Books chinaCountry=new Books(4, "China");  
	  Books nepalCountry=new Books(3, "Nepal");  
	  Books bhutanCountry=new Books(2, "Bhutan");  
	  
	  List<Books> listOfCountries = new ArrayList<Books>();  
	  listOfCountries.add(indiaCountry);  
	  listOfCountries.add(chinaCountry);  
	  listOfCountries.add(nepalCountry);  
	  listOfCountries.add(bhutanCountry);  
	  return listOfCountries;  
	 }
}
