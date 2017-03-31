package facade;

import dao.AbstractDAOFactory;
import dao.DisponibilityDAO;
import dao.ScheduleDAO;
import models.Disponibility;
import models.Doctor;
import models.Schedule;

import java.util.Date;
import java.util.List;

/**
 * @author BenAfonso
 */
public class ScheduleFacade {

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
     * Default constructor
     */
    public ScheduleFacade() {
        adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.PG_DAOFACTORY);
        // Fetching link between database and models
        dao = adf.getScheduleDAO();
        dispoDao = adf.getDisponibilityDAO();
    }

    /**
     * Return the disponibilities associated with the schedule
     *
     * @return the disponibilities associated with the schedule
     */
    public Disponibility getDisponibilities() {
        // TODO implement here
        return null;
    }

    /**
     * Create a schedule with a date in parameter
     *
     * @param date the date of schedule that will be created
     * @return the schedule added
     */
    public Schedule createSchedule(int doctor_id, Date date) {
        Schedule scheduleToInsert = dao.find(doctor_id, date);
        if (dao.find(doctor_id, date) == null) {
            scheduleToInsert = new Schedule(doctor_id, date);
            dao.create(scheduleToInsert);
            scheduleToInsert = dao.find(doctor_id, date);
        }
        return scheduleToInsert;
    }


    /**
     * Create a disponibility with a hour and a schedule in parameter
     * @param doctor_id
     * @param date
     * @param hourStart
     * @param minuteStart
     * @param hourEnd
     * @param minuteEnd
     * @param description
     * @return the disponibility added
     */
    public boolean createDisponibility(int doctor_id, Date date, int hourStart, int minuteStart, int hourEnd, int minuteEnd, String description) {
        Schedule sched = createSchedule(doctor_id, date);
        Disponibility dispoToInsert = new Disponibility(sched.getId(), hourStart, minuteStart, hourEnd, minuteEnd, description, false);
        return dispoDao.create(dispoToInsert);
    }

    /**
     * Returns true if a patient can make a request on a disponbility
     *
     * @param disponibilities_id
     * @param patient_id
     * @return true or false
     */
    public boolean canMakeRequest(int disponibilities_id, int patient_id) {
        return dispoDao.canMakeRequest(disponibilities_id, patient_id);
    }

    /**
     * Get all the disponibilities of the given doctor
     * @param doctor
     * @return a list of disponibilities
     */
    public List<Disponibility> getAllDoctorDisponibilities(Doctor doctor) {
        // TODO Auto-generated method stub
        return dispoDao.findAllDoctorDisponibilities(doctor.getId());
    }

    /**
     * Get all the available disponibilities of the given doctor
     * @param doctor
     * @return a list of disponibilities
     */
    public List<Disponibility> getDoctorDisponibilitiesAvalaible(Doctor doctor) {
        // TODO Auto-generated method stub
        return dispoDao.findDoctorDisponibilitiesAvailable(doctor.getId());
    }

}