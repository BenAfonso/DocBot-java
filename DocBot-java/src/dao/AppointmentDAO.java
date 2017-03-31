package dao;

import models.Appointment;

import java.util.List;

/**
 * @author BenAfonso
 */
public abstract class AppointmentDAO {


    /**
     * Create An appointment in the DB
     * @param appointment the appointment to create
     */
    public abstract boolean create(Appointment appointment);


    /**
     * Return the list of Appoitment of the doctor given in parameters
     * @param appointment the list of appointment
     */
    public abstract List<Appointment> findDoctorAppointment(int idDoctor);

  

}