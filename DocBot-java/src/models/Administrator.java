package models;

import java.util.*;

/**
 * @author BenAfonso
 */
public class Administrator extends Person {

	/**
     * Default constructor
     */
    public Administrator(String fname, String lname, String password, Date birthday, String phoneNumber, String mail) {
    	super(fname,lname,password,birthday,phoneNumber,mail);
    }

}