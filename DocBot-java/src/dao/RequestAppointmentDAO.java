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
     * Create a request appointment in the DB
     * @param requestAppointment the request to add
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
     * check if the request appointment became an appointment
     * @param requestAppointment the request to check
     */
    public abstract boolean hasAnAppointment(RequestAppointment requestAppointment) ;


    /**
     * @param requestAppointment
     */
    public abstract void delete(RequestAppointment requestAppointment);

    /**
     * Get all the request appointment of a given doctor that are not appointment yet
     * @param id the id of the doctor
     * @return the list of request appointment
     */
    public abstract List<RequestAppointment> findAll(int id);

    /**
     * Reject the appointment in the disponibilities by the person with the given id
     * @param dispoId the id of the disponibility
     * @param personid the id of the person
     */
	public abstract void reject(int dispoId, int personid);
	
	/**
	 * Reject the request Appointment
	 * @param requestAppointment the request to reject
	 */
	public abstract void reject(int requestAppointment);

	/**
	 * Get all the request Appointment made by a patient 
	 * @param user the user to get the request from
	 * @return list of request appointments
	 */
	public abstract List<RequestAppointment> getAppointmentsFrom(Patient user) ;
	

}