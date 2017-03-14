package facades;

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
		userDao = adf.getUserDAO();
	}
	
	
	/********************************************************
	 * 
	 * 						Functions
	 * 
	 ********************************************************/
	

	
	/**
	 * Checks the credentials for an email
	 * @param email
	 * @param password
	 * @return boolean
	 * @throws Exception 
	 */
<<<<<<< HEAD:DocBot-java/src/facades/PersonFacade.java
	public boolean checkCredentials(String email, String password) throws Exception {
		Person user = userDao.find(email);
		
		if (user == null) {
			throw new Exception("User doesn't exist");
		} 
		
=======
	public boolean checkCredentials(String email, String password) {
		User user = userDao.find(email);
>>>>>>> b970e77a309235fbe4acd1b850858eff54b4542a:DocBot-java/src/facades/UserFacade.java
		return (user.getPassword().equals(password));
	}

	/**
	 * Login function
	 * @param username
	 * @param password
	 * @return boolean
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
