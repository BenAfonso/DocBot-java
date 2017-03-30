package dao.pg;

import dao.PersonDAO;
import models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;



public class PgPersonDAO extends PersonDAO {
	
	private static PgPersonDAO pgPersonDAO;
	
	private PgPersonDAO() {
	}
	
	public static PgPersonDAO getPgPersonDAO(){
		if( pgPersonDAO == null ){
			pgPersonDAO = new PgPersonDAO();
		}
		return pgPersonDAO;
	}

	/**
	 * Create an user
	 * @param Person
	 * @return boolean
	 */
	public boolean create(Person obj) {
		try {
			int result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Person (firstname, lastname, email, password,phone,birthday) VALUES ('"+obj.getFirstName()+"','"+obj.getLastName()+"','"+obj.getEmail()+"','"+obj.getPassword()+"','"+obj.getPhoneNumber()+"','"+obj.getBirthday()+"')");
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * Delete an user
	 * @param Person
	 * @return boolean
	 */
	public boolean delete(Person obj) {
		try {
			ResultSet result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Person WHERE id = '"+obj.getId()+"')");
			if(result.first())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * Update an user
	 * @param Person
	 * @return boolean
	 */
	public boolean update(Person obj) {
		Person user = null;
		try {
			ResultSet result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Person SET (firstname, lastname, email, password) = ('"+obj.getFirstName()+"','"+obj.getLastName()+"','"+obj.getEmail()+"','"+obj.getPassword()+"')");
			if(result.first())
				user  = new Person(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"));         
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return user != null;
    }


	/**
	 * Find an user with his id
	 * @param int
	 * @return User
	 */
	public Person find(int id) {
		Person user = null;     

		try {
			ResultSet result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM person WHERE id = " + id);
			if(result.first())
				user = new Person(id,result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"));         
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	/**
	 * Find an user with his username
	 * @param String
	 * @return User
	 */
	public Person find(String username) {
		Person user = null;  
		System.out.println(ConnectDB.getInstance());
		try {
			ResultSet result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM person WHERE email='" + username + "'");

			if(result.first())
				user = new Person(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"));         
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updatePassword(String mail, String newPassword) {
		try {
			int result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE person SET password='"+newPassword+"' WHERE email='"+mail+"'");
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
