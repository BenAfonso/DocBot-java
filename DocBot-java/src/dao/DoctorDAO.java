package dao;

import java.sql.Connection;
import models.Doctor;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class DoctorDAO extends PersonDAO {

    /**
     * Default constructor
     */
    public DoctorDAO(Connection connect) {
    	super(connect);
    }

}