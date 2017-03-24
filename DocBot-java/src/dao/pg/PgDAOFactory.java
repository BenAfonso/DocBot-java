package dao.pg;

import java.sql.Connection;
import java.util.*;
import dao.*;

/**
 * @author BenAfonso
 */
public class PgDAOFactory extends AbstractDAOFactory {
	 protected static final Connection conn = connectDB.getInstance(); 

    /**
     * Default constructor
     */
    public PgDAOFactory() {
    }

    /**
     * @return
     */
    @Override
    public DoctorDAO getDoctorDAO() {
        // TODO implement here
        return new PgDoctorDAO(conn);
    }

	@Override
	public PersonDAO getPersonDAO() {
		// TODO Auto-generated method stub
		return new PgPersonDAO(conn);
	}

	@Override
	public ScheduleDAO getScheduleDAO() {
		// TODO Auto-generated method stub
		return new PgScheduleDAO();
	}

	@Override
	public HourDAO getHourDAO() {
		// TODO Auto-generated method stub
		return new PgHourDAO();
	}

	@Override
	public DisponibilityDAO getDisponibilityDAO() {
		// TODO Auto-generated method stub
		return new PgDisponibilityDAO();
	}

	@Override
	public RequestAppointmentDAO getRequestAppointmentDAO() {
		// TODO Auto-generated method stub
		return new PgRequestAppointmentDAO();
	}

	@Override
	public AnswerRequestDAO getAnswerRequestDAO() {
		// TODO Auto-generated method stub
		return new PgAnswerRequestDAO();
	}

	@Override
	public AppointmentDAO getAppointmentDAO() {
		// TODO Auto-generated method stub
		return new PgAppointmentDAO();
	}

	@Override
	public CommentDAO getCommentDAO() {
		// TODO Auto-generated method stub
		return new PgCommentDAO();
	}

}