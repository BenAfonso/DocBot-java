package facade;
import models.*;

import java.util.*;

/**
 * @author BenAfonso
 */
public class AppointmentFacade {

    /**
     * Default constructor
     */
    public AppointmentFacade() {
    }


    /** 
     * create an appointment from a requestAppointment
     * @param request the request to be accepted
     * @return true if the process worked without failure, else otherwise
     */
    public boolean accept(RequestAppointment request) {
        // TODO implement here
        return false;
    }

    /**
     * Create a new Appointment
     * @param appointment the Appointment to create
     * @return true if the process worked without failure, else otherwise
     */
    public boolean addNewAppointment(Appointment appointment) {
        // TODO implement here
        return false;
    }

    /**
     * Remove an appointment
     * @param request the request to be removed
     * @return true if the process worked without failure, else otherwise
     */
    public boolean remove(RequestAppointment request) {
        // TODO implement here
        return false;
    }

    /**
     *  Reject an appointment with the answer request associated
     * @param request request to reject
     * @param answer reason why the request is rejected
     * @return true if the process worked without failure, else otherwise
     */
    public boolean reject(RequestAppointment request, AnswerRequest answer) {
        // TODO implement here
        return false;
    }

    /**
     * Create an answer
     * @param answer answer to be created
     */
    public void createAnswer(AnswerRequest answer) {
        // TODO implement here
    }

}