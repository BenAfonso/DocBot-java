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
    public void create(Doctor doctor) {
        // TODO implement here
    }

    /**
     * @param doctor
     */
    public void update(Doctor doctor) {
        // TODO implement here
    }

    /**
     * @param doctor
     */
    public void find(Doctor doctor) {
        // TODO implement here
    }
    
    public abstract ArrayList<Doctor> findAll();
    
    
    public abstract Doctor find(String username);
    

    /**
     * @param doctor
     */
    public void delete(Doctor doctor) {
        // TODO implement here
    }
    public abstract Doctor find(int id);

	public abstract boolean create(int id, String siret, String number, String street, String city, String zip_code);

}