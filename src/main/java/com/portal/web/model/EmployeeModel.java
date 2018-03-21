package com.portal.web.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeModel {
	
	@JsonProperty("FirstName:")
	private  String firstname;
	@JsonProperty("LastName:")
	private  String lastname;
	@JsonProperty("Description:")
	private  String description;	


	
	public EmployeeModel()
	{

	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	@JsonIgnore
	public boolean isEmpty()
	{
		return this.firstname == null && this.lastname ==null;
	}
}
