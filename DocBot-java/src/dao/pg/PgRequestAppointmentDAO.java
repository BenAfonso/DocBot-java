package dao.pg;


import java.sql.Connection;
import dao.RequestAppointmentDAO;
import models.RequestAppointment;

/**
 * @author BenAfonso
 */
public class PgRequestAppointmentDAO extends RequestAppointmentDAO {

	private static PgRequestAppointmentDAO pgRequestAppointmentDAO;
    /**
     * Default constructor
     */
    private PgRequestAppointmentDAO() {
    }
    
    public static PgRequestAppointmentDAO getPgRequestAppointmentDAO(){
    	if ( pgRequestAppointmentDAO == null ){
    		pgRequestAppointmentDAO = new PgRequestAppointmentDAO();
    	}
    	return pgRequestAppointmentDAO;
    }
    

	@Override
	public void create(RequestAppointment requestAppointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RequestAppointment requestAppointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(RequestAppointment requestAppointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(RequestAppointment requestAppointment) {
		// TODO Auto-generated method stub
		
	}

}