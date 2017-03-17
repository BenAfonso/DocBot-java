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
     * @param disponibility 
     * @param person
     */
    public void createNewRequest(Disponibility disponibility, Person person) {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean delete() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public AppointmentFacade generateAppointment() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean checkIfDoctorIsInAutoAcceptPolicy() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Disponibility getDisponibility() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Patient getPatient() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Doctor getDoctor() {
        // TODO implement here
        return null;
    }

}