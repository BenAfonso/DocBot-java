package facade;

import dao.AbstractDAOFactory;
import dao.PersonDAO;
import models.Person;

public class PersonFacade {
	
	
	/********************************************************
	 * 
	 * 						Properties
	 * 
	 ********************************************************/
	
	
	PersonDAO userDao;
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
			System.out.println("An error occured while login");
			return false;
		}
	}

}
