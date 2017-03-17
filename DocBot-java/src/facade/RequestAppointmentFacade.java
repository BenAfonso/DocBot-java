package facade;
import models.*;
import dao.*;

import java.util.*;

/**
 * @author BenAfonso
 */
public class RequestAppointmentFacade {

    /**
     * Default constructor
     */
    public RequestAppointmentFacade() {
    }

    /**
     * 
     */
    public RequestAppointmentDAO dao;

    /**
     * 
     */
    public AbstractDAOFactory adf;

    /**
     * 
     */
    public AnswerRequestDAO answer;


    /**
     * Create a new requestAppointment
     * @param disponibility the disponibility of the requestAppointment
     * @param person the person who asked for the appointment
     */
    public void createNewRequest(Disponibility disponibility, Person person) {
        // TODO implement here
    }

    /**
     * Delete the disponibility
     * @return true if it went right, false otherwise
     */
    public boolean delete() {
        // TODO implement here
        return false;
    }

    /**	Generate an appointment from the request
     * @return the appointment generated
     */
    public AppointmentFacade generateAppointment() {
        // TODO implement here
        return null;
    }

    /**
     * Check if the doctor is in auto accept policy
     * @return true if the doctor is in auto accept mode, false otherwise
     */
    public Boolean checkIfDoctorIsInAutoAcceptPolicy() {
        // TODO implement here
        return null;
    }

    /**
     * Get the disponibility associated with the requestAppointment
     * @return the disponibility associated
     */
    public Disponibility getDisponibility() {
        // TODO implement here
        return null;
    }

    /**
     * Return the patient associated with the requestAppointment
     * @return the patient associated
     */
    public Patient getPatient() {
        // TODO implement here
        return null;
    }

    /**
     * Get the doctor associated with the requestAppointment
     * @return the doctor associated with the requestAppointment
     */
    public Doctor getDoctor() {
        // TODO implement here
        return null;
    }

}