package dao;

import models.Comment;
import models.Doctor;

import java.util.List;

/**
 * @author BenAfonso
 */
public abstract class CommentDAO {


    /**
     * @param comment
     */
    public abstract boolean create(Comment comment);

    /**
     * @param comment
     */
    public abstract void update(Comment comment);

    /**
     * @param comment
     */
    public abstract void delete(Comment comment);

    /**
     * @param id
     */
    public abstract void find(int id);

    public abstract List<Comment> findAll(Doctor doctor);

    public abstract boolean canAddAComment(int doctor_id, int patient_id);

}