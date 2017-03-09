package dao;

import java.sql.Connection;

import pg_dao.DAO;
import pg_dao.UserDAO;
import pg_dao.connectDB;


public class DAOFactory extends AbstractDAOFactory{
	
  protected static final Connection conn = connectDB.getInstance(); 
   
  /**
  * Retourne un objet User interagissant avec la BDD
  * @return DAO
  */
  public DAO<?> getUserDAO(){
	  System.out.println("get User Dao ");

	    return new UserDAO(conn);
  }
   
}