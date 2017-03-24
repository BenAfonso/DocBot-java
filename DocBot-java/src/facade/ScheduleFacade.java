package facade;
import models.*;
import dao.*;

import java.util.*;

/**
 * @author BenAfonso
 */
public class ScheduleFacade {

    /**
     * Default constructor
     */
    public ScheduleFacade() {
    }

    /**
     * 
     */
    public ScheduleDAO dao;

    /**
     * 
     */
    public AbstractDAOFactory adf;

    /**
     * 
     */
    public DisponibilityDAO dispoDAO;

    /**
     * 
     */
    public HourDAO hourDAO;


    /**
     * Return the disponibilities associated with the schedule
     * @return the disponibilities associated with the schedule
     */
    public Disponibility getDisponibilities() {
        // TODO implement here
        return null;
    }
    /** 
     * Create a schedule with a date in parameter
     * @param date the date of shedule that will be created
     * @return the schedule added
     */
    public Schedule createSchedule(Date date) {
        // TODO implement here
        return null;
    }

    /** 
     * Create a hour 
     * @param hour the hour of Hour object that will be created
     * @return the hour added
     */
    public Hour createHour(Hour hour) {
        // TODO implement here
        return null;
    }

    /**
     * Create a disponibility with a hour and a schedule in parameter
     * @param withSchedule 
     * @param withHour 
     * @return the disponibility added
     */
    public Disponibility createDisponibility(Schedule withSchedule, Hour withHour) {
        // TODO implement here
        return null;
    }

}