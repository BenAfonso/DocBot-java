package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Doctor;
import models.Patient;
import models.Person;

import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class DoctorDAO extends PersonDAO {
    /**
     * Default constructor
     */
    public DoctorDAO(Connection connect) {
    	super(connect);
    	this.connect = connect;

    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param doctor
     */
    public abstract void create(Doctor doctor);

    /**
     * @param doctor
     */
    public abstract void update(Doctor doctor) ;
    
    /**
     * get all the doctors that are unchecked
     * @return an array of unchecked doctors
     */
    public  abstract Doctor[] getUncheckedDoctor() ;
    /**
     * @param doctor
     */

    public abstract void find(Doctor doctor) ;
 
    
    public abstract List<Doctor> findAll();

    
    
    public abstract Doctor find(String mail);
    

    /**
     * @param doctor
     */
    public abstract void delete(Doctor doctor);
    
    public abstract Doctor find(int id);

	public abstract boolean create(int id, String siret, String number, String street, String city, String zip_code);

	public abstract void reject(Doctor doctor);
	
	public abstract void accept(Doctor doctor);

}