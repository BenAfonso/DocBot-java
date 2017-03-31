package dao.pg;

import dao.DoctorDAO;
import models.Doctor;
import models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author BenAfonso
 */
public class PgDoctorDAO extends DoctorDAO {

    private static PgDoctorDAO pgDoctorDAO;

    /**
     * Default constructor
     */
    private PgDoctorDAO() {
    }

    public static PgDoctorDAO getPgDoctorDAO() {
        if (pgDoctorDAO == null) {
            pgDoctorDAO = new PgDoctorDAO();
        }
        return pgDoctorDAO;
    }

    @Override
    public boolean create(Person person) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Person person) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Person person) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Find the doctor, with the given mail
     * @param mail the mail of the doctor
     */
    @Override
    public Doctor find(String mail) {
        Doctor doctor = null;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM doctor d, person p WHERE d.id=p.id AND p.email='" + mail + "'");

            if (result.first())
                doctor = new Doctor(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("password"), result.getDate("birthday"), result.getString("phone"), result.getString("email"), result.getString("siret"), result.getString("number"), result.getString("street"), result.getString("city"), result.getString("zip_code"), result.getBoolean("isvalidated"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    /**
     * Find all the doctors
     * @return the list of doctors
     */
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<Doctor>();
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT p.id as id, firstname, lastname, password, email, siret, number, street, city, zip_code, isvalidated FROM doctor d, person p WHERE d.id = p.id");

            while (result.next()) {
                Person person = new Person(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("email"), result.getString("password"));
                Doctor doc = new Doctor(person, result.getString("siret"), result.getString("number"), result.getString("street"), result.getString("city"), result.getString("zip_code"), result.getBoolean("isvalidated"));

                doctors.add(doc);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    /**
     * Create a doctor with the following parameters
     * @param id the id of the doctor
     * @param siret the siret of the doctot 
     * @param number the street number of the doctor
     * @param street the street of the doctor
     * @param city the city of the doctor
     * @param zip_code the zip code of the doctor
     * @return true if the doctor was created, false otherwise
     */
    public boolean create(int id, String siret, String number, String street, String city, String zip_code) {
        try {
            ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Doctor (id,siret,number,street,city,zip_code) VALUES ('" + id + "','" + siret + "','" + number + "','" + street + "','" + city + "','" + zip_code + "')");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * Find the doctor, with the given id
     * @param id the id of the doctor
     */
    @Override
    public Doctor find(int id) {
        Doctor doctor = null;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM doctor d, person p WHERE d.id=p.id AND p.id='" + id + "'");

            if (result.first())
                doctor = new Doctor(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("password"), result.getDate("birthday"), result.getString("phone"), result.getString("email"), result.getString("siret"), result.getString("number"), result.getString("street"), result.getString("city"), result.getString("zip_code"), result.getBoolean("isvalidated"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    /**
     * Update a docotor
     * @param mail the new mail of the doctor
     * @param fname the new firstname
     * @param lname the new lastname
     * @param birthday the new birthday
     * @param phoneNumber the new phoneNumber
     * @param streetNumber the new streetNumber
     * @param street the new street
     * @param city the new city
     * @param zipCode the new zipCode
     * @param id the id of the doctor to update
     * @return true if the doctor was updated
     */
    @Override
    public boolean update(String mail, String fname, String lname, Date birthday, String phoneNumber, String streetNumber, String street, String city, String zipCode, int id) {
        try {
            ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE person SET firstname='" + fname + "' ,lastname='" + lname + "' ,birthday='" + birthday + "' ,phone='" + phoneNumber + "' WHERE email='" + mail + "'");
            ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE doctor SET number='" + streetNumber + "' , street='" + street + "' , city='" + city + "' , zip_code='" + zipCode + "'WHERE id='" + id + "'");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Doctor> getUncheckedDoctor() {
        List<Doctor> doctors = new ArrayList<Doctor>();
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM doctor d,person p WHERE isValidated = false ");


            while (result.next()) {
                Person person = new Person(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("email"), result.getString("password"));
                Doctor doc = new Doctor(person, result.getString("siret"), result.getString("number"), result.getString("street"), result.getString("city"), result.getString("zip_code"), result.getBoolean("isvalidated"));

                doctors.add(doc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public void create(Doctor doctor) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Doctor doctor) {

    }

    @Override
    public void find(Doctor doctor) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Doctor doctor) {
        try {
            ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM doctor WHERE id ='" + doctor.getId() + "'");
            ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM person WHERE email ='" + doctor.getEmail() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a doctor with the given id 
     * @param id the id of the doctor to delete
     */
    @Override
    public void delete(int id) {
        try {
            ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM doctor WHERE id ='" + id + "'");
            ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM person WHERE id ='" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reject the registration request of the doctor and delete him
     * @param idDoctor
     */
    public void reject(int idDoctor) {
        delete(idDoctor);
    }

    /**
     * Accept the registration request of the doctor
     * @param idDoctor
     */
    @Override
    public void accept(Doctor doctor) {
        try {
            ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE doctor SET isValidated = true WHERE id ='" + doctor.getId() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Return all the doctor that has been accepted/rejected by the admin
     * @param b true if we want the active doctor, false if we want the inactiv doctor
     * @return the list of doctors
     */
    public List<Doctor> findActive(boolean t) {

        List<Doctor> doctors = new ArrayList<Doctor>();

        String query = "SELECT p.id as id, firstname, lastname, password, email, siret, number, street, city, zip_code, isvalidated FROM doctor d, person p WHERE d.id = p.id AND isvalidated = " + t;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery(query);

            while (result.next()) {
                Person person = new Person(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("email"), result.getString("password"));
                Doctor doc = new Doctor(person, result.getString("siret"), result.getString("number"), result.getString("street"), result.getString("city"), result.getString("zip_code"), result.getBoolean("isvalidated"));

                doctors.add(doc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    @Override
    public boolean updatePassword(String mail, String newPassword) {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * Check if a doctor is validated
     * @param id the id of doctor to check
     * @return true if the doctor is validated, false otherwise
     */
    @Override
    public boolean isValidated(int id) {
        boolean validated = false;
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT isvalidated FROM doctor d, person p WHERE d.id=p.id AND p.id='" + id + "'");

            if (result.first())
                validated = result.getBoolean("isvalidated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return validated;
    }

    /**
     * Get the patient that had appointments with the given doctors
     * @param doctor the doctor which we want the patient from
     * @return the list of patients
     */
    @Override
    public List<Person> getPatients(Doctor doctor) {
        List<Person> patients = new ArrayList<Person>();

        String query = "SELECT p.id as id, firstname, lastname, password, email " +
                " FROM doctor d, person p WHERE " +
                "d.id = p.doctor_id";
        try {
            ResultSet result = ConnectDB.getInstance().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery(query);

            while (result.next()) {
                Person person = new Person(result.getInt("id"), result.getString("firstname"), result.getString("lastname"), result.getString("email"), result.getString("password"));
                patients.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }


}