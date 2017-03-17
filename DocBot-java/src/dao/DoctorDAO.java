package dao;

import java.sql.Connection;
import models.Doctor;
import models.Patient;

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

    /**
     * @param doctor
     */
    public void delete(Doctor doctor) {
        // TODO implement here
    }

}