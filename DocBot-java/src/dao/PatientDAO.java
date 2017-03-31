package dao;

import models.Patient;
import models.Person;

import java.util.Date;
import java.util.List;

/**
 * @author BenAfonso
 */
public abstract class PatientDAO {


    /**
     * Create a patient
     * @param patient the patient to add in the DB
     */
    public abstract void create(Patient patient);

    /**
     * Update a patient
     * @param patient the patient to update in the DB
     */
    public abstract void update(Patient patient);

    /**
     * find a patient
     * @param patient the patient to find
     */
    public abstract void find(Patient patient);

    /**
     * Find a patient
     * @param id the id of the patient
     * @return the Patient
     */
    public abstract Patient find(int id);

    /**
     * The patient to find
     * @param mail the mail of the patient
     * @return the patient
     */
    public abstract Patient find(String mail);
    
    /**
     * Update the patient
     * @param mail the mail of the patient
     * @param fname the new first name of the patient
     * @param lname the new last name of the patient
     * @param birthday the new birthday of the patient
     * @param phoneNumber the new phone number of the patient
     * @return true if the update went right, false otherwise
     */
    public abstract boolean update(String mail, String fname, String lname, Date birthday, String phoneNumber);

    /**
     * Check if a patient is blocked
     * @param id the id of the patient
     * @return true if the patient is blocked, false otherwise
     */
    public abstract boolean isBlocked(int id);

    /**
     * delete a patient
     * @param patient the patient to delete
     */
    public abstract void delete(Patient patient);

    /**
     * Create a new Patient
     * @param id the id of the patient
     * @return true if the creation went right, false otherwise
     */
    public abstract boolean create(int id);

    /**
     * Return all the patient
     * @return the patients
     */
    public abstract List<Person> getAllPatients();
}