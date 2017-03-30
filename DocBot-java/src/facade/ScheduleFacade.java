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
     * Return the disponibilities associated with the schedule
     * @return the disponibilities associated with the schedule
     */
    public Disponibility getDisponibilities() {
        // TODO implement here
        return null;
    }
    /** 
     * Create a schedule with a date in parameter
     * @param date the date of schedule that will be created
     * @return the schedule added
     */
    public Schedule createSchedule(int doctor_id,Date date) {
    	Schedule scheduleToInsert=dao.find(doctor_id, date);
    	if(dao.find(doctor_id, date)==null){
    		scheduleToInsert = new Schedule (doctor_id,date); 
    		dao.create(scheduleToInsert);
    		scheduleToInsert = dao.find(doctor_id, date);
    	}
        return scheduleToInsert;
    }



    /**
     * Create a disponibility with a hour and a schedule in parameter
     * @param withSchedule 
     * @param withHour 
     * @return the disponibility added
     */
    public Disponibility createDisponibility(int doctor_id,Date date, int hourStart,int minuteStart, int hourEnd,int minuteEnd, String description) {
    	Schedule sched=createSchedule(doctor_id,date);
        Disponibility dispoToInsert = new Disponibility(sched.getId(),hourStart,minuteStart,hourEnd,minuteEnd,description,false);
        dispoDao.create(dispoToInsert);
        return null;
    }
	public List<Disponibility> getDoctorDisponibilities(Doctor doctor) {
		// TODO Auto-generated method stub
		return dispoDao.findDoctorDisponibilities(doctor.getId());
	}

}