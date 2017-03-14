package dao.pg;

import java.util.*;

import java.sql.Connection;
import dao.DoctorDAO;
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
    }

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
	public Person find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person find(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}