package models;

import java.util.*;

/**
 * @author BenAfonso
 */
public class Patient extends Person {

    /**
     * Default constructor
     */
    public Patient(String fname, String lname, String password, Date birthday, String phoneNumber, String mail) {
    	super(fname,lname,password,birthday,phoneNumber,mail);
    }
    public Patient(String fname, String lname, String password, Date birthday, String phoneNumber, String mail,boolean isValidated) {
    	super(fname,lname,password,birthday,phoneNumber,mail,isValidated);
    }
    public Patient(int id,String fname, String lname, String password, Date birthday, String phoneNumber, String mail,boolean isValidated) {
    	super(id,fname,lname,password,birthday,phoneNumber,mail,isValidated);
    }

    /**
     * 
     */
    public boolean isBlocked;


}