package dao;

import java.sql.Connection;
import models.Disponibility;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class DisponibilityDAO {

    /**
     * @param disponibility
     */
    public abstract boolean create(Disponibility disponibility) ;

    /**
     * @param disponibility
     */
    public abstract void update(Disponibility disponibility);

    /**
     * @param disponibility
     */
    public abstract void find(Disponibility disponibility);

    /**
     * @param disponibility
     */

    public abstract void delete(Disponibility disponibility);

    public abstract List<Disponibility> findDoctorDisponibilities(int id);
    public abstract boolean canMakeRequest(int dispo_id,int patient_id);

}