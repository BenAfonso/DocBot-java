package models;

import java.util.*;

/**
 * @author BenAfonso
 */
public class Comment {

	private String content;
	private String title;
	private int rate;
	private int appointment_id;
	private Date datePost;
    /**
     * Default constructor
     */
    public Comment(int id, String content, String title, int rate, Date datePost, int appointment_id) {
    	this.id = id;
    	this.content=content;
    	this.title=title;
    	this.rate=rate;
    	this.datePost=datePost;
    	this.appointment_id=appointment_id;
    }

    /**
     * 
     */
    public int id;

    /**
     * 
     */

	public String getContent() {
		return content;
	}

	public void setContent(String comment) {
		this.content = comment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rating) {
		this.rate = rating;
	}

	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datepost) {
		this.datePost = datepost;
	}




}