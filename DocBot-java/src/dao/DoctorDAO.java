package dao;

import models.Doctor;
import models.Person;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @author BenAfonso
 */
public abstract class DoctorDAO extends PersonDAO {

    /**
     *
     */
    public Connection connect;

    /**
     * @param doctor
     */
    public abstract void create(Doctor doctor);

    /**
     * @param doctor
     */
    public abstract void update(Doctor doctor);

    /**
     * get all the doctors that are unchecked
     *
     * @return an array of unchecked doctors
     */
    public abstract List<Doctor> getUncheckedDoctor();

    /**
     * find a don
     * @param doctor
     */
    public abstract void find(Doctor doctor);

    /**
     * Find all the doctors
     * @return the list of doctors
     */
    public abstract List<Doctor> findAll();

    /**
     * Find the doctor, with the given mail
     * @param mail the mail of the doctor
     */
    public abstract Doctor find(String mail);


    /**
     * Delete a doctor
     * @param doctor the doctor to delete
     */
    public abstract void delete(Doctor doctor);

    /**
     * Find the doctor, with the given id
     * @param id the id of the doctor
     */
    public abstract Doctor find(int id);

    /**
     * Create a doctor with the following parameters
     * @param id the id of the doctor
     * @param siret the siret of the doctot 
     * @param number the street number of the doctor
     * @param street the street of the doctor
     * @param city the city of the doctor
     * @param zip_code the zip code of the doctor
     * @return true if the doctor was created, false otherwise
     */
    public abstract boolean create(int id, String siret, String number, String street, String city, String zip_code);

    /**
     * Update a docotor
     * @param mail the new mail of the doctor
     * @param fname the new firstname
     * @param lname the new lastname
     * @param birthday the new birthday
     * @param phoneNumber the new phoneNumber
     * @param streetNumber the new streetNumber
     * @param street the new street
     * @param city the new city
     * @param zipCode the new zipCode
     * @param id the id of the doctor to update
     * @return true if the doctor was updated
     */
    public abstract boolean update(String mail, String fname, String lname, Date birthday, String phoneNumber, String streetNumber, String street, String city, String zipCode, int id);

    /**
     * Reject the registration request of the doctor and delete him
     * @param idDoctor
     */
    public abstract void reject(int idDoctor);

    /**
     * Accept the registration request of the doctor
     * @param idDoctor
     */
    public abstract void accept(Doctor doctor);

    /**
     * Return all the doctor that has been accepted/rejected by the admin
     * @param b true if we want the active doctor, false if we want the inactiv doctor
     * @return the list of doctors
     */
    public abstract List<Doctor> findActive(boolean b);

    /**
     * Delete a doctor with the given id 
     * @param id the id of the doctor to delete
     */
    public abstract void delete(int id);

    /**
     * Check if a doctor is validated
     * @param id the id of doctor to check
     * @return true if the doctor is validated, false otherwise
     */
    public abstract boolean isValidated(int id);

    /**
     * Get the patient that had appointments with the given doctors
     * @param doctor the doctor which we want the patient from
     * @return the list of patients
     */
    public abstract List<Person> getPatients(Doctor doctor);

}