package dao.pg;

import java.util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DoctorDAO;
import models.Doctor;
import models.Person;

/**
 * @author BenAfonso
 */
public class PgDoctorDAO extends DoctorDAO {

    /**
     * Default constructor
     */
    public PgDoctorDAO(Connection connect) {
    	super(connect);
    	this.connect = connect;
    }

    /**
     * 
     */
    public Connection connect;

	@Override
	public boolean create(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Doctor find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor find(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Doctor> findAll() {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		try {

			
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT p.id as id, firstname, lastname, password, email, siret FROM doctor d, person p WHERE d.id = p.id");
			
			while (result.next()) {
				Person person = new Person(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"));         
				Doctor doc = new Doctor(person, result.getString("siret"), "");
				
				doctors.add(doc);
			}
			
			
			
			 
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return doctors;
	}

}