package dao.pg;
import dao.PersonDAO;
import models.Person;
import java.sql.Connection;

import java.util.*;

/**
 * @author BenAfonso
 */
public class PgPersonDAO extends PersonDAO {

    /**
     * Default constructor
     */
    public PgPersonDAO(Connection conn) {
    	super(conn);
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