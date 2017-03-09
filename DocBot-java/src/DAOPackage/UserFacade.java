package DAOPackage;

import ModelPackage.User;

public class UserFacade {
	DAO<User> userDao;
	AbstractDAOFactory adf;
	public UserFacade() {
	    System.out.println("je créé les DAOs !");

	    adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	    //On récupère un objet faisant le lien entre la base et nos objets 
		  System.out.println("Abstract Dao Factory get");

	    userDao = adf.getUserDAO();
	    System.out.println("j'ai créé les DAOs !");
	}

	public User login(String username, String password) {
		return userDao.find(username,password);
	}

}
