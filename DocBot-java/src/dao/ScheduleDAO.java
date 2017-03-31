package dao;

import models.Schedule;

import java.util.Date;

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
    public abstract void find(Schedule schedule);

    /**
     * @param schedule
     */
    public abstract void delete(Schedule schedule);


    /**
     * Find the schedule of the doctor in a given date
     * @param doctor_id the id of the doctor
     * @param date the date of the schedule
     * @return the Schedule of the doctor
     */
    public abstract Schedule find(int doctor_id, Date date);
}