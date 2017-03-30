package models;

import java.util.Date;

/**
 * @author BenAfonso
 */
public class Comment {

    /**
     *
     */
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


    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datepost) {
        this.datePost = datepost;
    }

    public String getDate() {
        return datePost.toString();
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }


}