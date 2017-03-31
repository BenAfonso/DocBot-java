package dao.pg;

import dao.ScheduleDAO;
import models.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author BenAfonso
 */
public class PgScheduleDAO extends ScheduleDAO {

    private static PgScheduleDAO pgScheduleDAO;

    /**
     * Default constructor
     */
    private PgScheduleDAO() {
    }

    public static PgScheduleDAO getPgScheduleDAO() {
        if (pgScheduleDAO == null) {
            pgScheduleDAO = new PgScheduleDAO();
        }
        return pgScheduleDAO;
    }

    /**
     * Create an user
     *
     * @param Person
     * @return boolean
     */
    public void create(Schedule obj) {
        try {
            int result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Schedule (doctor_id, date) VALUES ('" + obj.getDoctor_id() + "','" + obj.getDate() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find the schedule of the doctor in a given date
     * @param doctor_id the id of the doctor
     * @param date the date of the schedule
     * @return the Schedule of the doctor
     */
    public Schedule find(int doctor_id, Date date) {
        Schedule schedule = null;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Schedule WHERE doctor_id='" + doctor_id + "' AND date='" + date + "'");

            if (result.first())
                schedule = new Schedule(result.getInt("id"), result.getInt("doctor_id"), result.getDate("date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedule;
    }

    @Override
    public void update(Schedule schedule) {
        // TODO Auto-generated method stub

    }

    @Override
    public void find(Schedule schedule) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Schedule schedule) {
        // TODO Auto-generated method stub

    }


}