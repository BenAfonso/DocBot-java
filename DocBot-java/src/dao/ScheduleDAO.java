package dao;

import models.Schedule;
import java.sql.Connection;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class ScheduleDAO {
	protected Connection connect = null;

    /**
     * Default constructor
     */
    public ScheduleDAO() {
    }


	public ScheduleDAO(Connection conn){
		this.connect = conn;
	}

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