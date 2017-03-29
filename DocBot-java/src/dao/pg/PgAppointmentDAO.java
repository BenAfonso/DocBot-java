package dao.pg;
import dao.AppointmentDAO;
import models.Appointment;
import java.sql.Connection;
import java.util.*;

/**
 * @author BenAfonso
 */
public class PgAppointmentDAO extends AppointmentDAO {
	
	private static PgAppointmentDAO pgAppointmentDAO;

    /**
     * Default constructor
     */
    private PgAppointmentDAO() {
    }
    
	public static PgAppointmentDAO getPgAppointmentDAO(){
		if (pgAppointmentDAO == null){
			pgAppointmentDAO = new PgAppointmentDAO();
		}
		return pgAppointmentDAO;
	}

	@Override
	public void create(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}

}