package models;

import java.util.*;

/**
 * @author BenAfonso
 */
public class Administrator extends Person {

	/**
     * Default constructor
     */
    public Administrator(int id,String fname, String lname, String password, Date birthday, String phoneNumber, String mail) {
    	super(id,fname,lname,password,birthday,phoneNumber,mail);
    }

    public Administrator() {

    }
}