package dao;

import models.User;
import pg_dao.DAO;

public class OtherDAOFactory extends AbstractDAOFactory{
	 public DAO<User> getUserDAO() {      
		    return null;
	 }
}
