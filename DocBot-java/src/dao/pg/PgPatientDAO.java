package dao.pg;

import java.sql.Connection;

import dao.PatientDAO;
import models.Patient;

/**
 * @author BenAfonso
 */
public class PgPatientDAO extends PatientDAO {

    /**
     * Default constructor
     */
    public PgPatientDAO(Connection conn) {
		super(conn);
    }

}