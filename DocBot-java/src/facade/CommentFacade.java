package facade;
import models.*;
import dao.*;

import java.util.*;

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
     * Default constructor
     */
    public CommentFacade() {
		adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.PG_DAOFACTORY);
    	dao=adf.getCommentDAO();
    }



    /**
     * 
     */
    public AppointmentDAO daoApp;


    /**
     * update a comment
     * @param Comment the new comment
     * @return the updated comment
     */
    public Comment updateComment(Comment comment) {
        // TODO implement here
        return null;
    }

    /**
     * Check if the comment is valid
     * @param Comment the comment to check
     * @return true if the comment is valide, false otherwise
     */
    public Boolean isCommentValide(Comment comment) {
        // TODO implement here
        return null;
    }

    /**
     * Add a comment 
     * @param Comment the comment to add 
     * @return boolean
     */
    public Boolean addComment(String content, String title, int rate, Date datePost, int appointment_id) {
        Comment commentToPost=new Comment(0,content,title,rate,datePost,appointment_id);
        return (dao.create(commentToPost));
    }

	public List<Comment> getCommentsOf(Doctor doctor) {
		// TODO Auto-generated method stub
		
		return dao.findAll(doctor);
	}

}