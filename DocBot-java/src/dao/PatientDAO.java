package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Patient;
import java.util.*;

/**
 * @author BenAfonso
 */
public abstract class PatientDAO {
	
    /**
     * Default constructor
     */
	public PatientDAO(Connection conn){
		System.out.println("Person Dao Created");
		this.connect = conn;
	}

    /**
     * 
     */
    public Connection connect;

    /**
     * @param patient
     */
    public void create(Patient patient) {
        // TODO implement here
    }

    /**
     * @param patient
     */
    public void update(Patient patient) {
        // TODO implement here
    }

    /**
     * @param patient
     */
    public void find(Patient patient) {
        // TODO implement here
    }

    /**
     * @param patient
     */
    public void delete(Patient patient) {
        // TODO implement here
    }

	public boolean create(int id) {
		try {
			int result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Patient (id) VALUES ('"+id+"')");

				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}



}