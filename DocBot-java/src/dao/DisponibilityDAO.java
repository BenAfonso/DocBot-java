package dao;

import models.Disponibility;

import java.util.List;

/**
 * @author BenAfonso
 */
public abstract class DisponibilityDAO {

    /**
     * @param disponibility
     */
    public abstract boolean create(Disponibility disponibility);

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

    public abstract List<Disponibility> findDoctorDisponibilitiesAvailable(int id);
    public abstract List<Disponibility> findAllDoctorDisponibilities(int id);

    public abstract boolean canMakeRequest(int dispo_id, int patient_id);

	public abstract void setBooked(int dispoId);

}