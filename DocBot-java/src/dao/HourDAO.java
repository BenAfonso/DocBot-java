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
    public abstract void create(Hour hour) ;

    /**
     * @param hour
     */
    public abstract void update(Hour hour);

    /**
     * @param hour
     */
    public abstract void find(Hour hour);

    /**
     * @param hour
     */
    public abstract void delete(Hour hour);

}