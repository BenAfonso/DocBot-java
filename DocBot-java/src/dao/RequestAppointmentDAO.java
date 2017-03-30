package dao;


import models.*;
import models.RequestAppointment;

import java.sql.Connection;
import java.util.List;

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
    public abstract boolean hasAnAppointment(RequestAppointment requestAppointment) ;


    /**
     * @param requestAppointment
     */
    public abstract void delete(RequestAppointment requestAppointment);

    public abstract List<RequestAppointment> findAll(int id);

	public abstract void reject(int dispoId, int personid);
	public abstract void reject(int requestAppointment);


	public abstract List<RequestAppointment> getAppointmentsFrom(Patient user) ;

}