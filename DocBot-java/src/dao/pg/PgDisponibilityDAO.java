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

	private static PgDisponibilityDAO pgDisponibilityDAO;
    /**
     * Default constructor
     */
    private PgDisponibilityDAO() {
    }
    
    public static PgDisponibilityDAO getPgDisponibilityDAO(){
    	if( pgDisponibilityDAO == null ){
    		pgDisponibilityDAO  = new PgDisponibilityDAO();
    	}
    	return pgDisponibilityDAO;
    }
    
    
	/**
	 * Create an user
	 * @param Person
	 * @return boolean
	 */
	public void create(Disponibility obj) {
		try {
			int result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Disponibility (schedule_id, hourStart, minuteStart, hourEnd,minuteEnd,description,isBooked) VALUES ('"+obj.getScheduleId()+"','"+obj.getHourStart()+"','"+obj.getMinuteStart()+"','"+obj.getHourEnd()+"','"+obj.getMinuteEnd()+"','"+obj.getDescription()+"','"+obj.isBooked()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Disponibility disponibility) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void find(Disponibility disponibility) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Disponibility disponibility) {
		// TODO Auto-generated method stub
	}
		

	public List<Disponibility> findDoctorDisponibilities(int id) {
		
		List<Disponibility> disponibilities = new ArrayList<Disponibility>();
		
		String query = "SELECT * FROM schedule s, disponibility d WHERE s.id = d.schedule_id AND s.doctor_id = "+id;
		try {
			ResultSet result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			
			while (result.next()) {
				Schedule sche=new Schedule(result.getInt("doctor_id"),result.getDate("date"));
				Disponibility disp = new Disponibility(sche,result.getInt("id"),result.getInt("hourStart"),result.getInt("minuteStart"),result.getInt("hourEnd"),result.getInt("minuteEnd"),result.getString("description"),result.getBoolean("isBooked"));
				disponibilities.add(disp);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return disponibilities;
	}

}