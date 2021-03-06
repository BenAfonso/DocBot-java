package facade;

import dao.*;
import dao.pg.PgAppointmentDAO;
import dao.pg.PgDisponibilityDAO;
import dao.pg.PgRequestAppointmentDAO;
import models.*;

import java.util.List;


/**
 * @author BenAfonso
 */
public class RequestAppointmentFacade {

    /**
     *
     */
    public RequestAppointmentDAO requestAppointmentDao;
    public DisponibilityDAO disponibilityDao;
    public AppointmentDAO appointmentDao;

    /**
     *
     */
    public AbstractDAOFactory adf;
    /**
     *
     */
    public AnswerRequestDAO answer;

    /**
     * Default constructor
     */
    public RequestAppointmentFacade() {
        this.requestAppointmentDao = PgRequestAppointmentDAO.getPgRequestAppointmentDAO();
        this.disponibilityDao = PgDisponibilityDAO.getPgDisponibilityDAO();
        this.appointmentDao=PgAppointmentDAO.getPgAppointmentDAO();
    }

    /**
     * Create a new requestAppointment
     *
     * @param disponibility the disponibility of the requestAppointment
     * @param person        the person who asked for the appointment
     */
    public boolean createNewRequest(Disponibility disponibility, Person person) {
        if (requestAppointmentDao == null) {
            return false; // Raise error (dao not instancied)
        }

        if (disponibility.isBooked()) {
            //throw new Error("Disponibility already booked");
            return false; // Raise error (disponibility already booked)
        }

        RequestAppointment requestAppointment = new RequestAppointment(disponibility, person);
        requestAppointmentDao.create(requestAppointment);
        return true;
    }

    /**
     * Delete the disponibility
     *
     * @return true if it went right, false otherwise
     */
    public boolean delete() {
        // TODO implement here
        return false;
    }

    /**
     * Generate an appointment from the request
     *
     * @return the appointment generated
     */
    public boolean accept(RequestAppointment request_appointment) {
    	
    	Appointment appointment= new Appointment(request_appointment.getId());
    	System.out.println(appointment.getRequest_appointmentId());
    	appointmentDao.create(appointment);
    	requestAppointmentDao.reject(request_appointment.getDispoId(),request_appointment.getPersonid());
    	disponibilityDao.setBooked(request_appointment.getDispoId());
    	return true;
    	
    }

    /**
     * Rejects a request appointment
     *
     * @param requestAppointment
     * @return true if the request appointment has been rejected, false either
     */
    public boolean reject(int requestAppointment){
        requestAppointmentDao.reject(requestAppointment);
        return true;
    }

    /**
     * Check if the doctor is in auto accept policy
     *
     * @return true if the doctor is in auto accept mode, false otherwise
     */
    public boolean checkIfDoctorIsInAutoAcceptPolicy() {
        // TODO implement here
        return false;
    }

    /**
     * Get the disponibility associated with the requestAppointment
     *
     * @return the disponibility associated
     */
    public Disponibility getDisponibility() {
        // TODO implement here
        return null;
    }

    /**
     * Return the patient associated with the requestAppointment
     *
     * @return the patient associated
     */
    public Patient getPatient() {
        // TODO implement here
        return null;
    }

    /**
     * Get the doctor associated with the requestAppointment
     *
     * @return the doctor associated with the requestAppointment
     */
    public Doctor getDoctor() {
        // TODO implement here
        return null;
    }

    /**
     * Returns all the request appointments of a person
     * @param person
     * @return list of requestAppointments
     */
    public List<RequestAppointment> getRequestAppointment(Person person) {
        // TODO Auto-generated method stub
        return requestAppointmentDao.findAll(person.getId());
    }

    /**
     * Returns al lthe appointments of a user
     * @param user
     * @return list of requestAppointments
     */
    public List<RequestAppointment> getAppointmentsFrom(Patient user) {
        return requestAppointmentDao.getAppointmentsFrom(user);
    }

    /**
     * Return true if the request appointment corresponds to an accepted appointment
     * @param requestAppointment
     * @return true if the request appointment corresponds to an appointment, false either
     */
    public boolean hasAnAppointment(RequestAppointment requestAppointment) {
        return requestAppointmentDao.hasAnAppointment(requestAppointment);
    }

}