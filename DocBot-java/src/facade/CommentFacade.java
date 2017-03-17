package facade;
import models.*;
import dao.*;

import java.util.*;

/**
 * @author BenAfonso
 */
public class CommentFacade {

    /**
     * Default constructor
     */
    public CommentFacade() {
    }

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
     * @return the added comment
     */
    public Comment addComment(Comment comment) {
        // TODO implement here
        return null;
    }

}