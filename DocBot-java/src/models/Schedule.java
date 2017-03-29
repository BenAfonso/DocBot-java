package models;

import java.util.*;

/**
 * @author BenAfonso
 */
public class Schedule {
	private int id;
    private int doctor_id;
    private Date date;
    /**
     * Default constructor
     */
    public Schedule(int doctor_id,Date date) {
    	this.setDoctor_id(doctor_id);
    	this.setDate(date);
    }
    public Schedule(int id,int doctor_id,Date date) {
    	this.setId(id);
    	this.setDoctor_id(doctor_id);
    	this.setDate(date);
    }
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}