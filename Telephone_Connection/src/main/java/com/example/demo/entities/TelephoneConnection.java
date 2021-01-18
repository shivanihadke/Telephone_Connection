package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//POJO Class for Telephone Connection

@Entity
public class TelephoneConnection {
	
	//Class Variables 
	
	
	@Id
	private Integer citizenPhoneNumber;
	
	@Min(1)
	private int citizenId;
	
	@NotBlank(message="Citizen Name is required!")
	@Size(min=3,message="Citizen Name should have atleast 3 characters!")
	private String citizenName;
	
	@Min(18)
	private int citizenAge;
	
	@NotBlank(message="Citizen Address is required!")
	private String citizenAddress;
	
	@NotBlank(message="Citizen Mother Name is required!")
	@Size(min=3,message="Citizen Mother Name should have atleast 3 characters!")
	private String citizenMotherName;
	
	@NotBlank(message="Citizen Father Name is required!")
	@Size(min=3,message="Citizen Father Name should have atleast 3 characters!")
	private String citizenFatherName;
	
	
//Default Constructor
	
  public TelephoneConnection() {
		super();
	}
  
  public TelephoneConnection(Integer citizenPhoneNumber) {
		super();
		this.citizenPhoneNumber=citizenPhoneNumber;
	}
	
//Parameterized Constructor
	

	public TelephoneConnection(Integer citizenPhoneNumber,int citizenId, String citizenName, int citizenAge, String citizenAddress,
		String citizenMotherName, String citizenFatherName) {
	super();
	this.citizenPhoneNumber=citizenPhoneNumber;
	this.citizenId = citizenId;
	this.citizenName = citizenName;
	this.citizenAge = citizenAge;
	this.citizenAddress = citizenAddress;
	this.citizenMotherName = citizenMotherName;
	this.citizenFatherName = citizenFatherName;
}

	//Getters & Setters Method
	
	public Integer getCitizenPhoneNumber() {
			return citizenPhoneNumber;
		}
	public void setCitizenPhoneNumber(Integer citizenPhoneNumber) {
		this.citizenPhoneNumber = citizenPhoneNumber;
	}

	public int getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(int citizenId) {
		this.citizenId = citizenId;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public int getCitizenAge() {
		return citizenAge;
	}

	public void setCitizenAge(int citizenAge) {
		this.citizenAge = citizenAge;
	}

	public String getCitizenAddress() {
		return citizenAddress;
	}

	public void setCitizenAddress(String citizenAddress) {
		this.citizenAddress = citizenAddress;
	}

	public String getCitizenMotherName() {
		return citizenMotherName;
	}

	public void setCitizenMotherName(String citizenMotherName) {
		this.citizenMotherName = citizenMotherName;
	}

	public String getCitizenFatherName() {
		return citizenFatherName;
	}

	public void setCitizenFatherName(String citizenFatherName) {
		this.citizenFatherName = citizenFatherName;
	}
	@Override
	public String toString()
	{
		return "Citizen Phone number: "+citizenPhoneNumber+"Citizen ID: "+citizenId+"-Citizen Name: "+citizenName+"Citizen Age: "+citizenAge+"Citizen Address: "+citizenAddress+"Citizen Mother Name: "+citizenMotherName+"Citizen Father Name: "+citizenFatherName;
	}

	
}
