package dao.pg;

import java.util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
	
	public List<Doctor> findAll() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		try {

			
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT p.id as id, firstname, lastname, password, email, siret, number, street, city, zip_code, policy_id, isvalidated FROM doctor d, person p WHERE d.id = p.id");
			
			while (result.next()) {
				Person person = new Person(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"),result.getBoolean("isvalidated"));         
				Doctor doc = new Doctor(person, result.getString("siret"), result.getString("number"), result.getString("street"), result.getString("city"), result.getString("zip_code"), result.getInt("policy_id"));
				
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
	public boolean update(String mail,String fname, String lname, Date birthday, String phoneNumber, String streetNumber, String street, String city, String zipCode, int id){
		try {
			int result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE person SET firstname='"+fname+"' ,lastname='"+lname+"' ,birthday='"+birthday+"' ,phone='"+phoneNumber+"' WHERE email='"+mail+"'");
			int result2 = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE doctor SET number='"+streetNumber+"' , street='"+street+"' , city='"+city+"' , zip_code='"+zipCode+"'WHERE id='"+id+"'");
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Doctor> getUncheckedDoctor() {
		List<Doctor> doctors = new ArrayList<Doctor>();    
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM doctor d,person p WHERE isValidated = false ");

			
			while (result.next()) {
				Person person = new Person(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"));         
				Doctor doc = new Doctor(person, result.getString("siret"), result.getString("number"), result.getString("street"), result.getString("city"), result.getString("zip_code"), result.getInt("policy_id"));
				
				doctors.add(doc);
			}       
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctors;
	}

	@Override
	public void create(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Doctor doctor) {
		
	}

	@Override
	public void find(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Doctor doctor) {
		try {
			int result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM doctor WHERE id ='"+doctor.getId()+"'");
			result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM person WHERE email ='"+doctor.getEmail()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int id) {
		try {
			int result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM doctor WHERE id ='"+id+"'");
			result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM person WHERE id ='"+id+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void reject(int idDoctor) {
		delete(idDoctor);
	}

	@Override
	public void accept(Doctor doctor) {
		Doctor docToAccept = find(doctor.getEmail());
		docToAccept.setIsValidated(true);
		try {
			int result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE person SET isValidated = true WHERE email ='"+doctor.getEmail()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Doctor> findActive(boolean t) {
		
		List<Doctor> doctors = new ArrayList<Doctor>();
		
		String query = "SELECT p.id as id, firstname, lastname, password, email, siret, number, street, city, zip_code, policy_id, isvalidated FROM doctor d, person p WHERE d.id = p.id AND isvalidated = "+t;
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			
			while (result.next()) {
				Person person = new Person(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("email"),result.getString("password"),result.getBoolean("isvalidated"));         
				Doctor doc = new Doctor(person, result.getString("siret"), result.getString("number"), result.getString("street"), result.getString("city"), result.getString("zip_code"), result.getInt("policy_id"));
				
				doctors.add(doc);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return doctors;
	}

	@Override
	public boolean updatePassword(String mail, String newPassword) {
		// TODO Auto-generated method stub
		return true;
	}
	

}