package facade;

import dao.AbstractDAOFactory;
import dao.AppointmentDAO;
import dao.CommentDAO;
import models.Comment;
import models.Doctor;

import java.util.Date;
import java.util.List;

/**
 * @author BenAfonso
 */
public class CommentFacade {
    /**
     *
     */
    public AbstractDAOFactory adf;

    /**
     *
     */
    public CommentDAO dao;
    /**
     *
     */
    public AppointmentDAO daoApp;


    /**
     * Default constructor
     */
    public CommentFacade() {
        adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.PG_DAOFACTORY);
        dao = adf.getCommentDAO();
    }

    /**
     * Update a comment
     * @param comment
     * @return
     */
    public Comment updateComment(Comment comment) {
        // TODO implement here
        return null;
    }

    /**
     * Test if a comment is valid or not
     * @param comment
     * @return
     */
    public Boolean isCommentValide(Comment comment) {
        // TODO implement here
        return (!(comment.getRate() > 5) || !(comment.getRate() < 0));
    }

    /**
     * Add a comment
     * @param content
     * @param title
     * @param rate
     * @param datePost
     * @param doctor_id
     * @param patient_id
     * @return
     */
    public Boolean addComment(String content, String title, int rate, Date datePost, int doctor_id, int patient_id) {
        Comment commentToPost = new Comment(0, content, title, rate, datePost, doctor_id, patient_id);
        return (dao.create(commentToPost));
    }

    /**
     * Check if a patient can add a comment
     *
     * @param doctor_id
     * @param patient_id
     * @return
     */
    public Boolean canAddComment(int doctor_id, int patient_id) {
        return (dao.canAddAComment(doctor_id, patient_id));
    }

    /**
     *
     * @param doctor
     * @return
     */
    public List<Comment> getCommentsOf(Doctor doctor) {
        // TODO Auto-generated method stub

        return dao.findAll(doctor);
    }

}