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

}