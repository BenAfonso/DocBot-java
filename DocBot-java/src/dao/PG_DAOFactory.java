package dao;

import java.sql.Connection;

import models.Person;
import pg_dao.PG_UserDAO;
import pg_dao.connectDB;


public class PG_DAOFactory extends AbstractDAOFactory{
	
  protected static final Connection conn = connectDB.getInstance(); 
   
  /**
  * Retourne un objet User interagissant avec la BDD
  * @return DAO
  */
  public PersonDAO getUserDAO(){
	  System.out.println("get User Dao ");
	    return new PG_UserDAO(conn);
  }
   
}