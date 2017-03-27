package services;

import models.*;

/**
 * Class allowing to store an authentification via the singleton pattern
 * @author Yoann
 *
 */
public class Authentification {

	private static Person person;
	
	/**
	 *  return the connected user
	 * @return person the person that is connected
	 */
	public Person getUser() {
		return Authentification.person;
	}
	
	/**
	 *  Check if the connected person is a doctor 
	 * @return true if the person is a doctor, false ohterwise
	 */
	public boolean isDoctor(){
		return (getUser() instanceof Doctor);
	}
	
	/**
	 *  Check if the connected person is a patient 
	 * @return true if the person is a patient, false ohterwise
	 */
	public boolean isPatient(){
		return (getUser() instanceof Patient);
	}
	
	/**
	 * Store the connected user 
	 * @param person the user to store as the connected user
	 */
	public void connect(Person person){
		Authentification.person = person;
	}
}
