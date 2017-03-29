package dao.pg;


import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		try {
			ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO RequestAppointment "
							+ "(patient_id, disponibility_id) VALUES "
							+ "('"+requestAppointment.getPerson().getId()+"',"
							+ "'"+requestAppointment.getDisponibility().getId()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
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