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
		adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.PG_DAOFACTORY);
		// Fetching link between database and models
		dao = adf.getScheduleDAO();
		dispoDao = adf.getDisponibilityDAO();
    }

    /**
     * 
     */
    public ScheduleDAO dao;
    public DisponibilityDAO dispoDao;
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
    public Schedule createSchedule(int doctor_id,Date date) {
       Schedule scheduleToInsert = new Schedule (doctor_id,date); 
       dao.create(scheduleToInsert);
        return scheduleToInsert;
    }



    /**
     * Create a disponibility with a hour and a schedule in parameter
     * @param withSchedule 
     * @param withHour 
     * @return the disponibility added
     */
    public Disponibility createDisponibility(Schedule withSchedule, int hourStart,int minuteStart, int hourEnd,int minuteEnd, String description) {
        Disponibility dispoToInsert = new Disponibility(withSchedule.getId(),hourStart,minuteStart,hourEnd,minuteEnd,description,false);
        dispoDao.create(dispoToInsert);
        return null;
    }

}