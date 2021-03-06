package dao.pg;


import dao.RequestAppointmentDAO;
import models.RequestAppointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.RequestAppointmentDAO;
import models.*;


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
	public void update(RequestAppointment requestAppointment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void find(RequestAppointment requestAppointment) {
		// TODO Auto-generated method stub

	}


	@Override
	public void create(RequestAppointment requestAppointment) {

		try {
			ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO RequestAppointment "
							+ "(patient_id, disponibility_id) VALUES "
							+ "('" + requestAppointment.getPerson().getId() + "',"
							+ "'" + requestAppointment.getDisponibility().getId() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


	@Override
	public List<RequestAppointment> findAll(int id) {

		List<RequestAppointment> requestAppointments = new ArrayList<RequestAppointment>();

		String query = "SELECT r.id as id,d.id as dispoId, s.date as date,d.hourStart as hourStart,d.minuteStart as minuteStart,d.hourEnd as hourEnd,d.minuteEnd as minuteEnd,p.lastName as lastName, p.firstName as firstName, p.id as personId FROM requestappointment r, disponibility d, schedule s, person p WHERE r.disponibility_id = d.id AND d.schedule_id=s.id AND r.patient_id = p.id AND r.rejected=false AND s.doctor_id = "+id
				+"EXCEPT SELECT r.id as id,d.id as dispoId, s.date as date,d.hourStart as hourStart,d.minuteStart as minuteStart,d.hourEnd as hourEnd,d.minuteEnd as minuteEnd,p.lastName as lastName, p.firstName as firstName, p.id as personId FROM requestappointment r,appointment a, disponibility d, schedule s, person p WHERE r.disponibility_id = d.id AND d.schedule_id=s.id AND r.patient_id = p.id AND a.requestAppointment_id=r.id AND s.doctor_id = "+id;
		try {
			ResultSet result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);

			while (result.next()) {

				RequestAppointment req = new RequestAppointment(result.getInt("id"),result.getInt("dispoId"), result.getDate("date"), result.getInt("hourStart"), result.getInt("minuteStart"), result.getInt("hourEnd"), result.getInt("minuteEnd"), result.getString("lastName"), result.getString("firstName"), result.getInt("personId"));
				requestAppointments.add(req);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requestAppointments;
	}

	public void reject(int dispoId,int patientId){
		String query = "UPDATE RequestAppointment SET rejected = true WHERE disponibility_id="+dispoId+" AND patient_id!="+patientId;
		try {
			int result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(RequestAppointment requestAppointment) {
		// TODO Auto-generated method stub

	}


	@Override
	public List<RequestAppointment> getAppointmentsFrom(Patient user) {
		List<RequestAppointment> requestAppointments = new ArrayList<RequestAppointment>();

		String query = "SELECT ra.id as id,firstname,lastname,dispo.hourstart,dispo.minutestart,dispo.hourend,dispo.minuteend,s.date,rejected FROM Doctor d,Person P,RequestAppointment ra,Disponibility dispo, Schedule s WHERE d.id = p.id AND s.doctor_id = d.id AND ra.disponibility_id = dispo.id AND dispo.schedule_id = s.id AND ra.patient_id = "+user.getId();

		try {
			ResultSet result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);

			while (result.next()) {

				RequestAppointment req = new RequestAppointment(result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getDate("date"),result.getInt("hourStart"),result.getInt("hourEnd"),result.getInt("minuteStart"),result.getInt("minuteEnd"),result.getBoolean("rejected"));
				requestAppointments.add(req);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requestAppointments;
	}

	@Override
	public boolean hasAnAppointment(RequestAppointment requestAppointment) {
		String query = "SELECT * FROM requestAppointment ra, Appointment a WHERE ra.id = a.requestappointment_id";
		int compteur = 0;
		try {
			ResultSet result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			while (result.next()) {

				compteur ++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (compteur > 0);
	}

	public void reject(int requestAppointment) {
		String query = "UPDATE RequestAppointment SET rejected = true WHERE id="+requestAppointment;
		try {
			int result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}