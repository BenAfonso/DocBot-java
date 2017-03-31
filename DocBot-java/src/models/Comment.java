package models;

import java.util.Date;

/**
 * @author BenAfonso
 */
public class Comment {


    public int id;
    private String content;
    private String title;
    private int rate;
    private int doctor_id;
    private int patient_id;
    private Date datePost;

    /**
     * Default constructor
     */
    public Comment(int id, String content, String title, int rate, Date datePost, int doctor_id, int patient_id) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.rate = rate;
        this.datePost = datePost;
        this.setDoctor_id(doctor_id);
        this.setPatient_id(patient_id);
    }


    /**
     * Get the content
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content
     *
     * @param comment
     */
    public void setContent(String comment) {
        this.content = comment;
    }

    /**
     * Get the title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the rating
     * @return rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * Set the rating
     * @param rating
     */
    public void setRate(int rating) {
        this.rate = rating;
    }

    /**
     * get the post date
     * @return date
     */
    public Date getDatePost() {
        return datePost;
    }

    /**
     * set the date
     * @param datepost
     */
    public void setDatePost(Date datepost) {
        this.datePost = datepost;
    }

    /**
     * Returns the date
     * @return dateString
     */
    public String getDate() {
        return datePost.toString();
    }

    /**
     *
     * Return the doctor_id
     * @return doctor_id
     */
    public int getDoctor_id() {
        return doctor_id;
    }

    /**
     * Set the doctor_id
     * @param doctor_id
     */
    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    /**
     * Get the patient id
     * @return patient_id
     */
    public int getPatient_id() {
        return patient_id;
    }

    /**
     * Set the patient_id
     * @param patient_id
     */
    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }


}