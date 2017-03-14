package dao;

import java.sql.Connection;
import models.Patient;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class PatientDAO {

    /**
     * Default constructor
     */
    public PatientDAO() {
    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param patient
     */
    public void create(Patient patient) {
        // TODO implement here
    }

    /**
     * @param patient
     */
    public void update(Patient patient) {
        // TODO implement here
    }

    /**
     * @param patient
     */
    public void find(Patient patient) {
        // TODO implement here
    }

    /**
     * @param patient
     */
    public void delete(Patient patient) {
        // TODO implement here
    }

}