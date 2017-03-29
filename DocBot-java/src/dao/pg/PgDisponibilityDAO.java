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

}