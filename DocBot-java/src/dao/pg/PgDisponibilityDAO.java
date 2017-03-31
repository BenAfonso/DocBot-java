package dao.pg;

import dao.DisponibilityDAO;
import models.Disponibility;
import models.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static PgDisponibilityDAO getPgDisponibilityDAO() {
        if (pgDisponibilityDAO == null) {
            pgDisponibilityDAO = new PgDisponibilityDAO();
        }
        return pgDisponibilityDAO;
    }


    /**
     * Create an user
     *
     * @param Person the 
     * @return boolean
     */
    public boolean create(Disponibility obj) {
        boolean done = false;
        try {
            int result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Disponibility (schedule_id, hourStart, minuteStart, hourEnd,minuteEnd,description,isBooked) VALUES ('" + obj.getScheduleId() + "','" + obj.getHourStart() + "','" + obj.getMinuteStart() + "','" + obj.getHourEnd() + "','" + obj.getMinuteEnd() + "','" + obj.getDescription() + "','" + obj.isBooked() + "')");
            done = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return done;
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


    /**
     *  Find all the disponibilities of a given doctor
     * @param id the id of the doctor
     * @return the lsit of disponibilities
     */
    public List<Disponibility> findAllDoctorDisponibilities(int id) {

        List<Disponibility> disponibilities = new ArrayList<Disponibility>();

        String query = "SELECT * FROM schedule s, disponibility d WHERE s.id = d.schedule_id AND s.doctor_id = " + id;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery(query);

            while (result.next()) {
                Schedule sche = new Schedule(result.getInt("doctor_id"), result.getDate("date"));
                Disponibility disp = new Disponibility(sche, result.getInt("id"), result.getInt("hourStart"), result.getInt("minuteStart"), result.getInt("hourEnd"), result.getInt("minuteEnd"), result.getString("description"), result.getBoolean("isBooked"));
                disponibilities.add(disp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disponibilities;
    }
    
    /**
     *  Find all the disponibilities of a given doctor that are availables
     * @param id the id of the doctor
     * @return the lsit of disponibilities
     */
    public List<Disponibility> findDoctorDisponibilitiesAvailable(int id) {

        List<Disponibility> disponibilities = new ArrayList<Disponibility>();

        String query = "SELECT * FROM schedule s, disponibility d WHERE s.id = d.schedule_id AND d.isbooked!=true AND s.doctor_id = " + id;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery(query);

            while (result.next()) {
                Schedule sche = new Schedule(result.getInt("doctor_id"), result.getDate("date"));
                Disponibility disp = new Disponibility(sche, result.getInt("id"), result.getInt("hourStart"), result.getInt("minuteStart"), result.getInt("hourEnd"), result.getInt("minuteEnd"), result.getString("description"), result.getBoolean("isBooked"));
                disponibilities.add(disp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disponibilities;
    }

    /**
     * Check if a patient can make a request
     * @param dispo_id the id of the disponibilities
     * @param patient_id the id of the patient
     * @return true if the patient can make a request, false otherwise
     */
    public boolean canMakeRequest(int dispo_id, int patient_id) {
        boolean can = false;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT r.id "
                    + "FROM requestappointment r WHERE "
                    + " r.disponibility_id = " + dispo_id + " AND r.patient_id =" + patient_id);

            while (result.next()) {
                can = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return can;

    }

    /**
     * Set a disponibility to booked
     * @param dispoId the id of the disponibility
     */
	@Override
	public void setBooked(int dispoId) {
		String query = "UPDATE Disponibility SET isbooked = true WHERE id="+dispoId;
		try {
			int result = ConnectDB.getInstance().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}