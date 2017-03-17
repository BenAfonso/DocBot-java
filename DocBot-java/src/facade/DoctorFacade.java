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
     * @return
     */
    public Schedule getSchedule() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Comment getComments() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Person loadInfo(int id) {
        // TODO implement here
        return null;
    }
    /**
     * @param doctor
     */
    public void registrer(Doctor doctor) {
        // TODO implement here
    }

    /**
     * @param doctor
     */
    public void reject(Doctor doctor) {
        // TODO implement here
    }

}