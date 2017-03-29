package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import models.Patient;
import models.Person;

import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class PatientDAO {
	



    /**
     * @param patient
     */
    public abstract void create(Patient patient) ;

    /**
     * @param patient
     */
    public abstract void update(Patient patient);

    /**
     * @param patient
     */
    public abstract void find(Patient patient) ;

    public abstract Patient find(int id);
    
    public abstract Patient find(String mail);
    
    public abstract boolean update(String mail, String fname, String lname, Date birthday, String phoneNumber);

    /**
     * @param patient
     */
    public void delete(Patient patient) {
        // TODO implement here
    }

	public abstract boolean create(int id) ;



}