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
    public abstract void update(Doctor doctor) ;
    
    /**
     * get all the doctors that are unchecked
     * @return an array of unchecked doctors
     */
    public  abstract List<Doctor> getUncheckedDoctor() ;
    /**
     * @param doctor
     */

    public abstract void find(Doctor doctor) ;
 
    
    public abstract List<Doctor> findAll();

    
    
    public abstract Doctor find(String mail);
    

    /**
     * @param doctor
     */
    public abstract void delete(Doctor doctor);
    
    public abstract Doctor find(int id);

	public abstract boolean create(int id, String siret, String number, String street, String city, String zip_code);
	
	public abstract boolean update(String mail,String fname, String lname, Date birthday, String phoneNumber, String streetNumber, String street, String city, String zipCode, int id);

	public abstract void reject(int idDoctor);
	
	public abstract void accept(Doctor doctor);

	public abstract List<Doctor> findActive(boolean b);

	public abstract void delete(int id);
	
	public abstract boolean isValidated(int id);

    public abstract List<Person> getPatients(Doctor doctor);

}