package models;

import java.util.*;

/**
 * @author BenAfonso
 */
public class Doctor extends Person {

    /**
     * Default constructor
     */
    public Doctor() {
    }
    
    public Doctor(Person person, String siret, String adress) {
    	this.person = person;
    	this.siret = siret;
    	this.adress = adress;
    }

    public Person person;
    /**
     * 
     */
    public String siret;

    /**
     * 
     */
    public String adress;




}