package facade;
import models.*;
import dao.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * @author BenAfonso
 */
public class DoctorFacade extends PersonFacade {

    /**
     * Default constructor
     */
    public DoctorFacade() {
		adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.PG_DAOFACTORY);
		// Fetching link between database and models
		dao = adf.getDoctorDAO();
		daoPerson=adf.getPersonDAO();
    }

    /**
     * 
     */
    public DoctorDAO dao;
    public PersonDAO daoPerson;


    /**
     * 
     */
    public AbstractDAOFactory adf;

    /**
     * 
     */
    public ScheduleDAO scheduleDao;

    /**
     * 
     */
    public CommentDAO commentDAO;



    /**
     * return the schedule of the  doctor
     * @return the doctor's schedules
     */
    public Schedule[] getSchedule() {
        // TODO implement here
        return null;
    }

    public ArrayList<Doctor> getDoctors() {
    	return dao.findAll();
    }
    
    /**
     * return the doctor's comments
     * @return the comment of the doctors
     */
    public Comment[] getComments() {
        // TODO implement here
        return null;
    }

	
    /**
     *  Load the information of the person
     * @param id the id person's id
     * @return the Person associated with the id
     */
    public Person loadInfo(int id) {
        // TODO implement here
        return null;
    }
    /**
     * Accept the registration of a doctor
     * @param doctor a Doctor object who will be registered
     */
	public boolean register(String fname, String lname, String password, LocalDate birthday, String phoneNumber, String mail, String siret, String streetNumber, String street, String city, String zipCode ) {
		boolean result=false;
		Date date = Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Doctor doctorToRegister = new Doctor(fname,lname,password,date,phoneNumber,mail,siret,streetNumber,street,city,zipCode);
		if(daoPerson.create(doctorToRegister)){
			int id = daoPerson.find(mail).getId();
			if(dao.create(id,siret,streetNumber,street,city,zipCode)){
				result=true;
			}
		}
		return result;
		
	}
    /**
     * Reject the registration of a doctor
     * @param doctor a Doctor object who will be rejected
     */
    public void reject(Doctor doctor) {
        // TODO implement here
    }

}