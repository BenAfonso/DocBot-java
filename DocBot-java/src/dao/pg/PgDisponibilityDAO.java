package dao.pg;
import dao.DisponibilityDAO;
import models.Disponibility;
import models.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author BenAfonso
 */
public class PgDisponibilityDAO extends DisponibilityDAO {

    /**
     * Default constructor
     */
    public PgDisponibilityDAO(Connection conn) {
    	super(conn);
    }
	/**
	 * Create an user
	 * @param Person
	 * @return boolean
	 */
	public void create(Disponibility obj) {
		try {
			int result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Disponibility (schedule_id, hourStart, minuteStart, hourEnd,minuteEnd,description,isBooked) VALUES ('"+obj.getScheduleId()+"','"+obj.getHourStart()+"','"+obj.getMinuteStart()+"','"+obj.getHourEnd()+"','"+obj.getMinuteEnd()+"','"+obj.getDescription()+"','"+obj.isBooked()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}