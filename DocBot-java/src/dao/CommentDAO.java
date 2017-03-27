package dao;
import models.Comment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
import javax.swing.JOptionPane;

import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class CommentDAO {

    /**
     * Default constructor
     */
    public CommentDAO(Connection connect) {
    	this.connect = connect;
    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param comment
     */
    public abstract boolean create(Comment comment );

    /**
     * @param comment
     */
    public void update(Comment comment) {
        // TODO implement here
    }

    /**
     * @param comment
     */
    public void delete(Comment comment) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void find(int id) {
        // TODO implement here
    }

}