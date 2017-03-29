package dao;

import models.Schedule;
import java.sql.Connection;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class ScheduleDAO {


    /**
     * @param schedule
     */
    public abstract void create(Schedule schedule);

    /**
     * @param schedule
     */
    public abstract void update(Schedule schedule);

    /**
     * @param schedule
     */
    public abstract void find(Schedule schedule) ;

    /**
     * @param schedule
     */
    public abstract void delete(Schedule schedule);


	public abstract Schedule find(int doctor_id, Date date);
}