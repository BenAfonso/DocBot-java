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
	public Doctor find(String mail) {
		Doctor doctor = null;      
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM doctor d, person p WHERE d.id=p.id AND p.email='"+mail+"'");

			if(result.first())
				doctor = new Doctor(result.getString("firstname"),result.getString("lastname"),result.getString("password"),result.getDate("birthday"),result.getString("phone"),result.getString("email"),result.getString("siret"),result.getString("number"),result.getString("street"),result.getString("city"),result.getString("zip_code"));         
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctor;
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
	public boolean create(int id, String siret, String number, String street, String city, String zip_code) {
		try {
			int result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Doctor (id,siret,number,street,city,zip_code) VALUES ('"+id+"','"+siret+"','"+number+"','"+street+"','"+city+"','"+zip_code+"')");

				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	@Override
	public Doctor find(int id) {
		Doctor doctor = null;      
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM doctor d, person p WHERE d.id=p.id AND p.id='"+id+"'");

			if(result.first())
				doctor = new Doctor(result.getString("firstname"),result.getString("lastname"),result.getString("password"),result.getDate("birthday"),result.getString("phone"),result.getString("email"),result.getString("siret"),result.getString("number"),result.getString("street"),result.getString("city"),result.getString("zip_code"));         
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctor;
	}

	@Override
	public Doctor[] getUncheckedDoctor() {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();    
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM doctor d,person p WHERE isValidated = 0 ");

			
			while (result.next()) {
				Person person = new Person(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"));         
				Doctor doc = new Doctor(person, result.getString("siret"), "");
				
				doctors.add(doc);
			}       
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (Doctor[]) doctors.toArray();
	}

	@Override
	public void create(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

}