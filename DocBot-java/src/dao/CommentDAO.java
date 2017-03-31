package dao;

import models.Comment;
import models.Doctor;

import java.util.List;

/**
 * @author BenAfonso
 */
public abstract class CommentDAO {


    /**
     * Create a comment in the DB
     * @param comment the comment to create
     */
    public abstract boolean create(Comment comment);

    /**
     * Update an comment in the DB
     * @param comment the comment to Update
     */
    public abstract void update(Comment comment);

    /**
     * delete a comment from the DB
     * @param comment the comment to delete
     */
    public abstract void delete(Comment comment);

    /**
     * find an appointment with the id
     * @param id the id of the comment
     */
    public abstract void find(int id);

    /**
     * Find all the comment of a given doctor
     * @param doctor the doctor which we want the comment from
     * @return the list of comment
     */
    public abstract List<Comment> findAll(Doctor doctor);

    /**
     * Check if a patient can add a comment on the doctor
     * @param doctor_id the doctor to add the comment
     * @param patient_id the patient that could post the comment
     * @return true if the patient can post the comment on the doctor, false otherwise
     */
    public abstract boolean canAddAComment(int doctor_id, int patient_id);

}