package dao;

import java.sql.Connection;
import models.Disponibility;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class DisponibilityDAO {

    /**
     * Default constructor
     */
    public DisponibilityDAO() {
    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param disponibility
     */
    public void create(Disponibility disponibility) {
        // TODO implement here
    }

    /**
     * @param disponibility
     */
    public void update(Disponibility disponibility) {
        // TODO implement here
    }

    /**
     * @param disponibility
     */
    public void find(Disponibility disponibility) {
        // TODO implement here
    }

    /**
     * @param disponibility
     */
    public void delete(Disponibility disponibility) {
        // TODO implement here
    }

}