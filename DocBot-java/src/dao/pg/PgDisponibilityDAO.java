package dao.pg;
import dao.DisponibilityDAO;
import models.Disponibility;
import models.Doctor;
import models.Person;
import models.Schedule;

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
	public List<Disponibility> findDoctorDisponibilities(int id) {
		
		List<Disponibility> Disponibilities = new ArrayList<Disponibility>();
		
		String query = "SELECT * FROM schedule s, disponibility d WHERE s.id = d.schedule_id AND s.doctor_i = "+id;
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			
			while (result.next()) {
				Schedule sche=new Schedule(result.getInt("doctor_id"),result.getDate("date"));
				Disponibility disp = new Disponibility(sche,result.getInt("hourStart"),result.getInt("minuteStart"),result.getInt("hourEnd"),result.getInt("minuteEnd"),result.getString("description"),result.getBoolean("isBooked"));
				Disponibilities.add(disp);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Disponibilities;
	}

}