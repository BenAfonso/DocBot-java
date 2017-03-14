package dao;

import java.sql.Connection;
import models.Person;


public abstract class PersonDAO {
	protected Connection connect = null;

	public PersonDAO(Connection conn){
		System.out.println("Person Dao Created");
		this.connect = conn;
	}
   
  /**
  * Méthode de création
  * @param Person
  * @return boolean 
  */
  public abstract boolean create(Person person);

  /**
  * Méthode pour effacer
  * @param Person
  * @return boolean 
  */
  public abstract boolean delete(Person person);

  /**
  * Méthode de mise à jour
  * @param Person
  * @return boolean
  */
  public abstract boolean update(Person person);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return User
  */
  public abstract Person find(int id);

  public abstract Person find(String username);
}