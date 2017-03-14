package pg_dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.PersonDAO;
import models.Person;



public class PG_UserDAO extends PersonDAO {

	public PG_UserDAO(Connection conn) {
		super(conn);
		System.out.println("User Dao Created");
	}

	/**
	 * Create an user
	 * @param Person
	 * @return boolean
	 */
	public boolean create(Person obj) {
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Person (firstname, lastname, email, password) VALUES ('"+obj.getFisrtName()+"','"+obj.getLastName()+"','"+obj.getEmail()+"','"+obj.getPassword()+"') FROM Person WHERE id = '"+obj.getId()+"')");
			if(result.first())
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
			ResultSet result = this.connect.createStatement(
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
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Person SET (firstname, lastname, email, password) = ('"+obj.getFisrtName()+"','"+obj.getLastName()+"','"+obj.getEmail()+"','"+obj.getPassword()+"')");
			if(result.first())
				user  = new Person(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"));         
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * Find an user with his id
	 * @param int
	 * @return User
	 */
	public Person find(int id) {
		Person user = null;     

		try {
			ResultSet result = this.connect.createStatement(
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
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM person WHERE email='" + username + "'");
			if(result.first())
				user = new Person(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"));         
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
