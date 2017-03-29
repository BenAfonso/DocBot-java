package dao.pg;

import java.sql.Connection;
import java.util.*;
import dao.*;

/**
 * @author BenAfonso
 */
public class PgDAOFactory extends AbstractDAOFactory {
	 
	private static PgDAOFactory pgDaoFactory;
	 
    /**
     * Default constructor
     */
    private PgDAOFactory() {
    }
    
    public static PgDAOFactory getPgDAOFactory(){
    	if(pgDaoFactory == null ){
    		pgDaoFactory = new PgDAOFactory();
    	}
    	return pgDaoFactory;
    }

    /**
     * @return
     */
    @Override
    public DoctorDAO getDoctorDAO() {
       
        return PgDoctorDAO.getPgDoctorDAO();
    }

    public PatientDAO getPatientDAO() {
        return PgPatientDAO.getPgPatientDAO();
    }
	@Override
	public PersonDAO getPersonDAO() {
		// TODO Auto-generated method stub
		return PgPersonDAO.getPgPersonDAO();
	}

	@Override
	public ScheduleDAO getScheduleDAO() {
		// TODO Auto-generated method stub
		return PgScheduleDAO.getPgScheduleDAO();
	}

	@Override
	public HourDAO getHourDAO() {
		// TODO Auto-generated method stub
		return PgHourDAO.getPgHourDAO();
	}

	@Override
	public DisponibilityDAO getDisponibilityDAO() {
		// TODO Auto-generated method stub
		return PgDisponibilityDAO.getPgDisponibilityDAO();
	}

	@Override
	public RequestAppointmentDAO getRequestAppointmentDAO() {
		// TODO Auto-generated method stub
		return  PgRequestAppointmentDAO.getPgRequestAppointmentDAO();
	}

	@Override
	public AnswerRequestDAO getAnswerRequestDAO() {
		// TODO Auto-generated method stub
		return PgAnswerRequestDAO.getPgAnswerRequestDAO();
	}

	@Override
	public AppointmentDAO getAppointmentDAO() {
		// TODO Auto-generated method stub
		return PgAppointmentDAO.getPgAppointmentDAO();
	}

	@Override
	public CommentDAO getCommentDAO() {
		// TODO Auto-generated method stub
		return PgCommentDAO.getPgCommentDAO();
	}

}