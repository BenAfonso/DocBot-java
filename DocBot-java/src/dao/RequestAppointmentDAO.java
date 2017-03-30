package dao;

import models.Disponibility;
import models.RequestAppointment;
import java.sql.Connection;

import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class RequestAppointmentDAO {


    /**
     * 
     */
    public Connection connect;

    /**
     * @param requestAppointment
     */
    public abstract void create(RequestAppointment requestAppointment);

    /**
     * @param requestAppointment
     */
    public abstract void update(RequestAppointment requestAppointment);

    /**
     * @param requestAppointment
     */
    public abstract void find(RequestAppointment requestAppointment) ;

    /**
     * @param requestAppointment
     */
    public abstract void delete(RequestAppointment requestAppointment) ;

	public abstract List<RequestAppointment> findAll(int id);

}