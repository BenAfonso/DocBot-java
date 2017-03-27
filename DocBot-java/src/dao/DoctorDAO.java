package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Doctor;
import models.Patient;

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
    	this.connect = connect;

    }

    /**
     * 
     */
    public Connection connect;

    /**
     * @param doctor
     */
    public void create(Doctor doctor) {
        // TODO implement here
    }

    /**
     * @param doctor
     */
    public void update(Doctor doctor) {
        // TODO implement here
    }

    /**
     * @param doctor
     */
    public void find(Doctor doctor) {
        // TODO implement here
    }
    
    public abstract ArrayList<Doctor> findAll();
    
    public abstract Doctor find(int id);
    
    public abstract Doctor find(String username);
    

    /**
     * @param doctor
     */
    public void delete(Doctor doctor) {
        // TODO implement here
    }
	public boolean create(int id) {
		try {
			int result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Doctor (id) VALUES ('"+id+"')");

				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

}