package facade;
import models.*;
import models.*;
import dao.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * @author BenAfonso
 */
public class PatientFacade {


    /**
     * 
     */
    public PatientDAO dao;
    
    public PersonDAO daoPerson;

    /**
     * 
     */
    public AbstractDAOFactory adf;

    /**
     * Default constructor
     */
    public PatientFacade() {
		adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.PG_DAOFACTORY);
		// Fetching link between database and models
		dao = adf.getPatientDAO();
		daoPerson = adf.getPersonDAO();
    }


    /**
     * load the information about the Person
     * @param id the id associated with the user
     * @return the Person linked to the id
     */
    public Person loadInfo(int id) {
        // TODO implement here
        return null;
    }

	public boolean register(String fname, String lname, String password, LocalDate birthday, String phoneNumber, String mail) {
		boolean result=false;
		Date date = Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Patient patientToRegister = new Patient(fname,lname,password,date,phoneNumber,mail);
		if(daoPerson.create(patientToRegister)){
			int id = daoPerson.find(mail).getId();
			if(dao.create(id)){
				result=true;
			}
		}
		return result;
		
	}

}