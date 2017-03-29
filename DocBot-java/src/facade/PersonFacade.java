package facade;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import dao.AbstractDAOFactory;
import dao.DoctorDAO;
import dao.PatientDAO;
import dao.PersonDAO;
import models.Doctor;
import models.Patient;
import models.Person;
import services.Authentification;

public class PersonFacade {
	
	
	/********************************************************
	 * 
	 * 						Properties
	 * 
	 ********************************************************/
	
	
	PersonDAO userDao;
	DoctorDAO docDao;
	PatientDAO patientDao;
	AbstractDAOFactory adf;
	
	
	/********************************************************
	 * 
	 * 						Constructors
	 * 
	 ********************************************************/
	
	
	public PersonFacade() {
		adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.PG_DAOFACTORY);
		// Fetching link between database and models
		userDao = adf.getPersonDAO();
		docDao = adf.getDoctorDAO();
		patientDao = adf.getPatientDAO();
	}
	
	
	/********************************************************
	 * 
	 * 						Functions
	 * 
	 ********************************************************/
	

	
	/**
	 * Checks the credentials for an email
	 * @param email the user's email
	 * @param password the user's password
	 * @return boolean true if the user is real, false otherwise
	 * @throws Exception the esxception is thrown when the user doesn't exist
	 */
	public boolean checkCredentials(String email, String password) throws Exception {
		Person user = userDao.find(email);
		
		if (user == null) {
			throw new Exception("User doesn't exist");
		} 
		Doctor doc = docDao.find(user.getId());
		if(doc !=null){
			Authentification.connect(doc);
		}else{
			Patient pat = patientDao.find(user.getId());
			if(pat !=null){
				Authentification.connect(pat);
			}
		}
		return (user.getPassword().equals(password));
	}

	/**
	 * Log a user
	 * @param username the user's username
	 * @param password the user's password
	 * @return boolean true if the user is logged, false otherwise
	 */
	public boolean login(String username, String password) {
		try {
			return checkCredentials(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("An error occured while login");
			return false;
		}
	}
	
	/**
     * Update a profile doctor
     * @param doctor a Doctor object who will be updated
     */
	public boolean updatePassword(String mail, String newPassword){
		boolean result=false;
		if(userDao.updatePassword(mail, newPassword)){
			result=true;
		}
		return result;
	}

}
