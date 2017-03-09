package facades;

import dao.AbstractDAOFactory;
import models.User;
import pg_dao.DAO;

public class UserFacade {
	
	
	/********************************************************
	 * 
	 * 						Properties
	 * 
	 ********************************************************/
	
	
	DAO<User> userDao;
	AbstractDAOFactory adf;
	@SuppressWarnings("unchecked")
	
	
	/********************************************************
	 * 
	 * 						Constructors
	 * 
	 ********************************************************/
	
	
	public UserFacade() {
		adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		// Fetching link between database and models
		userDao = adf.getUserDAO();
	}
	
	
	/********************************************************
	 * 
	 * 						Functions
	 * 
	 ********************************************************/
	
	

	/**
	 * Returns an user with username
	 * @param username
	 * @return User
	 */
	public User getUser(String username) {
		return userDao.find(username);
	}

	/**
	 * Checks the credentials for an email
	 * @param email
	 * @param password
	 * @return boolean
	 */
	public boolean checkCredentials(String email, String password) {
		User user = getUser(email);
		return (user.getPassword().equals(password));
	}

	/**
	 * Login function
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public boolean login(String username, String password) {
		return checkCredentials(username, password);
	}

}
