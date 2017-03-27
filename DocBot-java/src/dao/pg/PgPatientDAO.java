package dao.pg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.PatientDAO;
import models.Doctor;
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
	public Patient find(int id) {
		Patient patient = null;      
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM patient pa, person p WHERE pa.id=p.id AND p.id='"+id+"'");

			if(result.first())
				patient = new Patient(result.getString("firstname"),result.getString("lastname"),result.getString("password"),result.getDate("birthday"),result.getString("phone"),result.getString("email"));         
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patient;
	}

}