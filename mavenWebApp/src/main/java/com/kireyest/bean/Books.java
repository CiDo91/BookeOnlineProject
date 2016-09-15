package com.kireyest.bean;

public class Books {
	//Comment testtt
	 int id;  
	 String countryName;   
	 double salary;
	 
	 public Books(){}
	   
	 public Books(int i, String countryName) {  
	  super();  
	  this.id = i;  
	  this.countryName = countryName;  
	 }  
	 public int getId() {  
	  return id;  
	 }  
	 public void setId(int id) {  
	  this.id = id;  
	 }  
	 public String getCountryName() {  
	  return countryName;  
	 }  
	 public void setCountryName(String countryName) {  
	  this.countryName = countryName;  
	 }

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}  
}
