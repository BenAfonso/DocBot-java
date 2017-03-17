package facade;
import models.*;
import dao.*;

import java.util.*;

/**
 * @author BenAfonso
 */
public class DoctorFacade extends PersonFacade {

    /**
     * Default constructor
     */
    public DoctorFacade() {
    }

    /**
     * 
     */
    public DoctorDAO dao;

    /**
     * 
     */
    public AbstractDAOFactory adf;

    /**
     * 
     */
    public ScheduleDAO scheduleDao;

    /**
     * 
     */
    public CommentDAO commentDAO;



    /**
     * return the schedule of the  doctor
     * @return the doctor's schedules
     */
    public Schedule[] getSchedule() {
        // TODO implement here
        return null;
    }

    /**
     * return the doctor's comments
     * @return the comment of the doctors
     */
    public Comment[] getComments() {
        // TODO implement here
        return null;
    }

    /**
     *  Load the information of the person
     * @param id the id person's id
     * @return the Person associated with the id
     */
    public Person loadInfo(int id) {
        // TODO implement here
        return null;
    }

}