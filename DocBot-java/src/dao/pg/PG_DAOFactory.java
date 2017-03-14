package dao.pg;

import java.sql.Connection;

import dao.AbstractDAOFactory;
import dao.PersonDAO;
import models.Person;


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