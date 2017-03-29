package dao.pg;
import dao.ScheduleDAO;
import models.Person;
import models.Schedule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author BenAfonso
 */
public class PgScheduleDAO extends ScheduleDAO {

    /**
     * Default constructor
     */
    public PgScheduleDAO(Connection conn) {
    	super(conn);
    }

	/**
	 * Create an user
	 * @param Person
	 * @return boolean
	 */
	public void create(Schedule obj) {
		try {
			int result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Schedule (doctor_id, date) VALUES ('"+obj.getDoctor_id()+"','"+obj.getDate()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}