package dao;

import java.sql.Connection;
import models.Appointment;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class AppointmentDAO {

    /**
     * Default constructor
     */
    public AppointmentDAO() {
    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param appointment
     */
    public void create(Appointment appointment) {
        // TODO implement here
    }

    /**
     * @param appointment
     */
    public void update(Appointment appointment) {
        // TODO implement here
    }

    /**
     * @param appointment
     */
    public void find(Appointment appointment) {
        // TODO implement here
    }

    /**
     * @param appointment
     */
    public void delete(Appointment appointment) {
        // TODO implement here
    }

}