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
	public static Person getUser() {
		return Authentification.person;
	}
	
	/**
	 *  Check if the connected person is a doctor 
	 * @return true if the person is a doctor, false ohterwise
	 */
	public static boolean isDoctor(){
		return (getUser() instanceof Doctor);
	}
	
	/**
	 *  Check if the connected person is an Admin 
	 * @return true if the person is a doctor, false ohterwise
	 */
	public static boolean isAdministrator(){
		return (getUser() instanceof Administrator);
	}
	
	/**
	 *  Check if the connected person is a patient 
	 * @return true if the person is a patient, false ohterwise
	 */
	public static boolean isPatient(){
		return (getUser() instanceof Patient);
	}
	
	/**
	 * Store the connected user 
	 * @param person the user to store as the connected user
	 */
	public static void connect(Person person){
		Authentification.person = person;
	}
	
	/**
	 * Delete the user
	 */
	public static void disconnect(){
		Authentification.person = null;
	}
}
