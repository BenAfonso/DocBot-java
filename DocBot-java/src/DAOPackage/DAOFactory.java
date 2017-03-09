package DAOPackage;

import java.sql.Connection;

public class DAOFactory extends AbstractDAOFactory{
	
  protected static final Connection conn = connectDB.getInstance(); 
   
  /**
  * Retourne un objet User interagissant avec la BDD
  * @return DAO
  */
  public DAO getUserDAO(){
	    return new UserDAO(conn);
  }
   
}