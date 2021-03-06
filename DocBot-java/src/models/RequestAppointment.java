package models;

import java.sql.Date;

import facade.RequestAppointmentFacade;

/**
 * @author BenAfonso
 */
public class RequestAppointment {

	private Disponibility disponibility;
	private Person person;
	private int id;
	private int hourStart;
	private int hourEnd;
	private int minuteEnd;
	private int minuteStart;
	private int personid;
	private String firstName;
	private String lastName;
	private Date date;
	private String status;
	private String hourMinuteStart;
	private String hourMinuteEnd;
	private int dispoId;


	/**
	 * Default constructor
	 */
	public RequestAppointment(Disponibility d, Person p) {

		this.setDisponibility(d);
		this.setPerson(p);
	}

	public RequestAppointment(int id, Date date, int hourStart, int minuteStart, int hourEnd, int minuteEnd, String firstName,
			String lastName, int personId) {
		this.setId(id);
		this.setDate(date);
		this.setHourStart(hourStart);
		this.setMinuteStart(minuteStart);
		this.setHourEnd(hourEnd);
		this.setMinuteStart(minuteStart);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public RequestAppointment(int requestAppointmentId,String firstName, String lastName, Date date, int hourStart, int hourEnd, int minuteStart, int minuteEnd,
			boolean rejected) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.hourMinuteStart = hourStart+" : "+minuteStart;
		this.hourMinuteEnd  = hourEnd+" : "+minuteEnd;
		this.hourEnd = hourEnd;
		this.minuteStart = minuteStart;
		this.minuteEnd = minuteEnd;
		if(rejected){
			this.status = "Refus�";
		}else{
			RequestAppointmentFacade raFacade = new RequestAppointmentFacade();
			if (raFacade.hasAnAppointment(this)){
				this.status = "Accept�";
			}else{
				this.status = "En attente de confirmation";
			}

		}

	}


	public RequestAppointment(int id, int dispoId, Date date, int hourStart, int minuteStart, int hourEnd, int minuteEnd, String firstName,
			String lastName, int personId) {
		this.setId(id);
		this.setDate(date);
		this.setHourStart(hourStart);
		this.setMinuteStart(minuteStart);
		this.setHourEnd(hourEnd);
		this.setMinuteStart(minuteStart);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPersonid(personId);
		this.setDispoId(dispoId);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHourStart() {
		return hourStart;
	}

	public void setHourStart(int hourStart) {
		this.hourStart = hourStart;
	}

	public int getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(int hourEnd) {
		this.hourEnd = hourEnd;
	}

	public int getMinuteEnd() {
		return minuteEnd;
	}

	public void setMinuteEnd(int minuteEnd) {
		this.minuteEnd = minuteEnd;
	}

	public int getMinuteStart() {
		return minuteStart;
	}

	public void setMinuteStart(int minuteStart) {
		this.minuteStart = minuteStart;
	}

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDate() {
		return date.toString();
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHourStartFull() {
		String minString="";
		int min = this.getMinuteStart();
		if(min<10){
			minString="0"+min;
		}
    	else{
    		minString=""+min;
    	}
		return this.getHourStart() + ":" + minString;
	}

	public String getHourEndFull() {
		String minString="";
		int min = this.getMinuteEnd();
		if(min<10){
			minString="0"+min;
		}else{
			minString=""+min;
		}
		return this.getHourEnd() + ":" + minString;
	}

	public int getDispoId() {
		return dispoId;
	}


	public String getHourMinuteStart(){
		return this.hourMinuteStart;
	}

	public String getHourMinuteEnd(){
		return this.hourMinuteEnd;
	}

	public String getStatus(){
		return this.status;
	}


	public void setDispoId(int dispoId) {
		this.dispoId = dispoId;
	}



}