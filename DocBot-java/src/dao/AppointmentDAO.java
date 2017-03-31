package dao;

import models.Appointment;

import java.util.List;

/**
 * @author BenAfonso
 */
public abstract class AppointmentDAO {


    /**
     * @param appointment
     */
    public abstract boolean create(Appointment appointment);

    /**
     * @param appointment
     */
    public abstract void update(Appointment appointment);

    /**
     * @param appointment
     */
    public abstract List<Appointment> findDoctorAppointment(int idDoctor);

    /**
     * @param appointment
     */
    public abstract void delete(Appointment appointment);

}