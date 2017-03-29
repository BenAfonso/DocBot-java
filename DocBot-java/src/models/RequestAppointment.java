package models;
import java.util.*;

/**
 * @author BenAfonso
 */
public class RequestAppointment {

	private Disponibility disponibility;
	private Person person;
    
	/**
     * Default constructor
     */
    public RequestAppointment(Disponibility d, Person p) {
    	this.setDisponibility(d);
    	this.setPerson(p);
    }
    
    public Disponibility getDisponibility() {
		return disponibility;
	}
	public void setDisponibility(Disponibility disponibility) {
		this.disponibility = disponibility;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}



}