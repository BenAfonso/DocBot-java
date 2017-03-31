package dao.pg;

import dao.AppointmentDAO;
import models.Appointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static PgAppointmentDAO getPgAppointmentDAO() {
        if (pgAppointmentDAO == null) {
            pgAppointmentDAO = new PgAppointmentDAO();
        }
        return pgAppointmentDAO;
    }

    @Override
    public boolean create(Appointment appointment) {
        try {
            ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Appointment (requestAppointment_id) VALUES ('" + appointment.getRequest_appointmentId() + "')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void update(Appointment appointment) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Appointment> findDoctorAppointment(int idDoctor) {
        String query = "SELECT a.id as id, s.date as date,d.hourStart as hourStart,d.minuteStart as minuteStart,d.hourEnd as hourEnd,d.minuteEnd as minuteEnd,p.lastName as lastName, p.firstName as firstName, p.id as personId FROM appointment a,requestappointment r, disponibility d, schedule s, person p WHERE a.requestAppointment_id=r.id AND r.disponibility_id = d.id AND d.schedule_id=s.id AND r.patient_id = p.id AND r.rejected=false AND s.doctor_id = " + idDoctor;
        List<Appointment> appointments = new ArrayList<Appointment>();
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery(query);

            while (result.next()) {

                Appointment app = new Appointment(result.getInt("id"), result.getDate("date"), result.getInt("hourStart"), result.getInt("minuteStart"), result.getInt("hourEnd"), result.getInt("minuteEnd"), result.getString("lastName"), result.getString("firstName"), result.getInt("personId"));
                appointments.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    @Override
    public void delete(Appointment appointment) {
        // TODO Auto-generated method stub

    }

}