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
     * update a comment
     *
     * @param Comment the new comment
     * @return the updated comment
     */
    public Comment updateComment(Comment comment) {
        // TODO implement here
        return null;
    }

    /**
     * Check if the comment is valid
     *
     * @param Comment the comment to check
     * @return true if the comment is valide, false otherwise
     */
    public Boolean isCommentValide(Comment comment) {
        // TODO implement here
        return null;
    }

    /**
     * Add a comment
     *
     * @param Comment the comment to add
     * @return boolean
     */
    public Boolean addComment(String content, String title, int rate, Date datePost, int doctor_id, int patient_id) {
        Comment commentToPost = new Comment(0, content, title, rate, datePost, doctor_id, patient_id);
        return (dao.create(commentToPost));
    }

    public Boolean canAddComment(int doctor_id, int patient_id) {
        return (dao.canAddAComment(doctor_id, patient_id));
    }

    public List<Comment> getCommentsOf(Doctor doctor) {
        // TODO Auto-generated method stub

        return dao.findAll(doctor);
    }

}