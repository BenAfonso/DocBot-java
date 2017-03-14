package dao;

import java.sql.Connection;
import models.Hour;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class HourDAO {

    /**
     * Default constructor
     */
    public HourDAO() {
    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param hour
     */
    public void create(Hour hour) {
        // TODO implement here
    }

    /**
     * @param hour
     */
    public void update(Hour hour) {
        // TODO implement here
    }

    /**
     * @param hour
     */
    public void find(Hour hour) {
        // TODO implement here
    }

    /**
     * @param hour
     */
    public void delete(Hour hour) {
        // TODO implement here
    }

}