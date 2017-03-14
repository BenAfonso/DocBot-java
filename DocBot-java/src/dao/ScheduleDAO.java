package dao;

import models.Schedule;
import java.sql.Connection;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class ScheduleDAO {

    /**
     * Default constructor
     */
    public ScheduleDAO() {
    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param schedule
     */
    public void create(Schedule schedule) {
        // TODO implement here
    }

    /**
     * @param schedule
     */
    public void update(Schedule schedule) {
        // TODO implement here
    }

    /**
     * @param schedule
     */
    public void find(Schedule schedule) {
        // TODO implement here
    }

    /**
     * @param schedule
     */
    public void delete(Schedule schedule) {
        // TODO implement here
    }

}