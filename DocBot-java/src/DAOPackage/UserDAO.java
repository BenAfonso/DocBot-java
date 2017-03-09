package DAOPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import ModelPackage.User;



public class UserDAO extends DAO<User> {
	
		  public UserDAO(Connection conn) {
		    super(conn);
		  }

		  public boolean create(User obj) {
		    return false;
		  }

		  public boolean delete(User obj) {
		    return false;
		  }
		   
		  public boolean update(User obj) {
		    return false;
		  }
		   
		  public User find(int id) {
		    User user = new User();      
		      
		    try {
		      ResultSet result = this.connect.createStatement(
		      ResultSet.TYPE_SCROLL_INSENSITIVE,
		      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM users WHERE id = " + id);
		      if(result.first())
		        user = new User(id,result.getString("fname"),result.getString("lname"),result.getString("mail"),result.getString("mdp"));         
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return user;
		  }
		
}
