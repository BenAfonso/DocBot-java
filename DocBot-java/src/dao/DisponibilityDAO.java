package dao;

import models.Disponibility;

import java.util.List;

/**
 * @author BenAfonso
 */
public abstract class DisponibilityDAO {

    /**
     * @param disponibility
     */
    public abstract boolean create(Disponibility disponibility);

    /**
     * @param disponibility
     */
    public abstract void update(Disponibility disponibility);

    /**
     * @param disponibility
     */
    public abstract void find(Disponibility disponibility);

    /**
     * @param disponibility
     */

    public abstract void delete(Disponibility disponibility);

    /**
     *  Find all the disponibilities of a given doctor that are availables
     * @param id the id of the doctor
     * @return the lsit of disponibilities
     */
    public abstract List<Disponibility> findDoctorDisponibilitiesAvailable(int id);
    
    /**
     *  Find all the disponibilities of a given doctor
     * @param id the id of the doctor
     * @return the lsit of disponibilities
     */
    public abstract List<Disponibility> findAllDoctorDisponibilities(int id);

    /**
     * Check if a patient can make a request
     * @param dispo_id the id of the disponibilities
     * @param patient_id the id of the patient
     * @return true if the patient can make a request, false otherwise
     */
    public abstract boolean canMakeRequest(int dispo_id, int patient_id);

    /**
     * Set a disponibility to booked
     * @param dispoId the id of the disponibility
     */
	public abstract void setBooked(int dispoId);

}