package facade;
import models.*;
import models.*;
import dao.*;

import java.util.*;

/**
 * @author BenAfonso
 */
public class PatientFacade {

    /**
     * Default constructor
     */
    public PatientFacade() {
    }

    /**
     * 
     */
    public PatientDAO dao;

    /**
     * 
     */
    public AbstractDAOFactory adf;



    /**
     * load the information about the Person
     * @param id the id associated with the user
     * @return the Person linked to the id
     */
    public Person loadInfo(int id) {
        // TODO implement here
        return null;
    }

}