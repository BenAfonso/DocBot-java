package dao;

import models.RequestAppointment;
import java.sql.Connection;

import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class RequestAppointmentDAO {

    /**
     * Default constructor
     */
    public RequestAppointmentDAO() {
    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param requestAppointment
     */
    public void create(RequestAppointment requestAppointment) {
        // TODO implement here
    }

    /**
     * @param requestAppointment
     */
    public void update(RequestAppointment requestAppointment) {
        // TODO implement here
    }

    /**
     * @param requestAppointment
     */
    public void find(RequestAppointment requestAppointment) {
        // TODO implement here
    }

    /**
     * @param requestAppointment
     */
    public void delete(RequestAppointment requestAppointment) {
        // TODO implement here
    }

}