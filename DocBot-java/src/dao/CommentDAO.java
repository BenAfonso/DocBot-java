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
     * @param comment
     */
    public abstract boolean create(Comment comment );

    /**
     * @param comment
     */
    public abstract void update(Comment comment) ;
    /**
     * @param comment
     */
    public abstract void delete(Comment comment);

    /**
     * @param id
     */
    public abstract void find(int id) ;

}