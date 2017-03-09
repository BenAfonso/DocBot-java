package DAOPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import ModelPackage.User;



public class UserDAO extends DAO<User> {
	
		  public UserDAO(Connection conn) {
		    super(conn);
			  System.out.println("User Dao Created");

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
		      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM person WHERE id = " + id);
		      if(result.first())
		        user = new User(id,result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"));         
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return user;
		  }
		  public User find(String username, String password) {
			    User user = new User();      
			      System.out.println("blabala");
			    try {
			      ResultSet result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM person WHERE email='" + username+"' AND password ='"+password+"'");
			      if(result.first())
			        user = new User(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"));         
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
			    return user;
			  }
		
}
