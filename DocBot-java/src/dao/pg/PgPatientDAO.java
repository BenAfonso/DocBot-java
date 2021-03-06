package dao.pg;

import dao.PatientDAO;
import models.Patient;
import models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author BenAfonso
 */
public class PgPatientDAO extends PatientDAO {

    private static PgPatientDAO pgPatientDAO;

    /**
     * Default constructor
     */
    private PgPatientDAO() {
    }

    public static PgPatientDAO getPgPatientDAO() {
        if (pgPatientDAO == null) {
            pgPatientDAO = new PgPatientDAO();
        }
        return pgPatientDAO;
    }

    public Patient find(int id) {
        Patient patient = null;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM patient pa, person p WHERE pa.id=p.id AND p.id='" + id + "'");

            if (result.first())
                patient = new Patient(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("password"), result.getDate("birthday"), result.getString("phone"), result.getString("email"), result.getBoolean("isBlocked"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public Patient find(String mail) {
        Patient patient = null;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM patient pa, person p WHERE pa.id=p.id AND p.email='" + mail + "'");

            if (result.first())
                patient = new Patient(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("password"), result.getDate("birthday"), result.getString("phone"), result.getString("email"), result.getBoolean("isBlocked"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public boolean update(String mail, String fname, String lname, Date birthday, String phoneNumber) {
        try {
            int result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE person SET firstname='" + fname + "' ,lastname='" + lname + "' ,birthday='" + birthday + "' ,phone='" + phoneNumber + "' WHERE email='" + mail + "'");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean create(int id) {
        try {
            int result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Patient (id) VALUES ('" + id + "')");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public List<Person> getAllPatients() {
        List<Person> patients = new ArrayList<Person>();

        String query = "SELECT p.id as id, firstname, lastname, password, email " +
                " FROM patient pa, person p WHERE " +
                "pa.id = p.id";
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery(query);

            while (result.next()) {
                Person patient = new Person(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("email"), result.getString("password"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }

    @Override
    public void create(Patient patient) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Patient patient) {
        // TODO Auto-generated method stub

    }

    @Override
    public void find(Patient patient) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isBlocked(int id) {
        boolean blocked = false;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT isblocked FROM patient pa, person p WHERE pa.id=p.id AND p.id='" + id + "'");

            if (result.first())
                blocked = result.getBoolean("isblocked");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blocked;
    }

}