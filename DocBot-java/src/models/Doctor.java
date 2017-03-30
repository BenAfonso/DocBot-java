package models;

import java.util.*;

/**
 * @author BenAfonso
 */
public class Doctor extends Person {

	/********************************************************
	 * 
	 * 						Properties
	 * 
	 ********************************************************/
	
    private String streetNumber;
	private String street;
	private String city;
	private String zipCode;
	private Person person;
	private String siret;
	private String adress;

	/********************************************************
	 * 
	 * 						Constructors
	 * 
	 ********************************************************/
    public Doctor() {
    }
    
    public Doctor(Person person, String siret, String number, String street, String city, String zip_code) {
    	this.setPerson(person);
    	this.setId(person.getId());
    	this.setFirstName(person.getFirstName());
    	this.setLastName(person.getLastName());
    	this.setPassword(person.getPassword());
    	this.setEmail(person.getEmail());
    	this.setSiret(siret);
    	this.setAdress(adress);
    	this.setStreetNumber(number);
    	this.setStreet(street);
    	this.setCity(city);
    	this.setZipCode(zip_code);
    	this.setIsValidated(person.getIsValidated());
    }
    
    public Doctor(String fname, String lname, String password, Date birthday, String phoneNumber, String mail, String siret, String streetNumber, String street, String city, String zipcode) {
    	super(fname,lname,password,birthday,phoneNumber,mail);
    	this.setSiret(siret);
    	this.setStreetNumber(streetNumber);
    	this.setStreet(street);
    	this.setCity(city);
    	this.setZipCode(zipcode);
    }
    
    public Doctor(String fname, String lname, String password, Date birthday, String phoneNumber, String mail, String siret, String streetNumber, String street, String city, String zipcode,boolean isValidated) {
    	super(fname,lname,password,birthday,phoneNumber,mail,isValidated);
    	this.setSiret(siret);
    	this.setStreetNumber(streetNumber);
    	this.setStreet(street);
    	this.setCity(city);
    	this.setZipCode(zipcode);
    }
    
    public Doctor(int id,String fname, String lname, String password, Date birthday, String phoneNumber, String mail, String siret, String streetNumber, String street, String city, String zipcode,boolean isValidated) {
    	super(id,fname,lname,password,birthday,phoneNumber,mail,isValidated);
    	this.setSiret(siret);
    	this.setStreetNumber(streetNumber);
    	this.setStreet(street);
    	this.setCity(city);
    	this.setZipCode(zipcode);
    }
    
    

    
    /********************************************************
	 * 
	 * 						Getters and setters
	 * 
	 ********************************************************/
    
    public String getStreetNumber() {
		return streetNumber;
	}

    
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	





}