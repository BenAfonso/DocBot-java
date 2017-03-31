package facade;

import dao.*;
import models.Comment;
import models.Doctor;
import models.Person;
import models.Schedule;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * @author BenAfonso
 */
public class DoctorFacade extends PersonFacade {

    /**
     *
     */
    public DoctorDAO dao;
    public PersonDAO daoPerson;
    /**
     *
     */
    public AbstractDAOFactory adf;
    /**
     *
     */
    public ScheduleDAO scheduleDao;
    /**
     *
     */
    public CommentDAO commentDAO;

    /**
     * Default constructor
     */
    public DoctorFacade() {
        adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.PG_DAOFACTORY);
        // Fetching link between database and models
        dao = adf.getDoctorDAO();
        daoPerson = adf.getPersonDAO();
    }

    /**
     * return the schedule of the  doctor
     *
     * @return the doctor's schedules
     */
    public Schedule[] getSchedule() {
        // TODO implement here
        return null;
    }

    public List<Doctor> getDoctors() {
        return dao.findAll();
    }


    /**
     * return the doctor's comments
     *
     * @return the comments of the doctors
     */
    public Comment[] getComments() {
        // TODO implement here
        return null;
    }


    /**
     * Load the information of the doctor
     *
     * @param mail the person's mail
     * @return the Doctor associated with the mail
     */
    public Doctor loadInfo(String mail) {
        Doctor doctor = null;
        try {
            doctor = dao.find(mail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return doctor;
    }

    /**
     * get all the doctor that are not checked yet
     *
     * @return a list of unchecked doctors
     */
    public List<Doctor> getUncheckedDoctors() {

        return dao.getUncheckedDoctor();
    }


    /**
     * Register a new doctor's account
     * @param fname
     * @param lname
     * @param password
     * @param birthday
     * @param phoneNumber
     * @param mail
     * @param siret
     * @param streetNumber
     * @param street
     * @param city
     * @param zipCode
     * @return true if register went right, false if register went wrong
     */
    public boolean register(String fname, String lname, String password, LocalDate birthday, String phoneNumber, String mail, String siret, String streetNumber, String street, String city, String zipCode) {
        boolean result = false;
        Date date = Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Doctor doctorToRegister = new Doctor(fname, lname, password, date, phoneNumber, mail, siret, streetNumber, street, city, zipCode, false);
        if (daoPerson.create(doctorToRegister)) {
            int id = daoPerson.find(mail).getId();
            if (dao.create(id, siret, streetNumber, street, city, zipCode)) {
                result = true;
            }
        }
        return result;

    }


    /**
     * Update a doctor
     * @param mail
     * @param fname
     * @param lname
     * @param birthday
     * @param phoneNumber
     * @param streetNumber
     * @param street
     * @param city
     * @param zipCode
     * @param id
     * @return true if register went right, false if register went wrong
     */
    public boolean update(String mail, String fname, String lname, LocalDate birthday, String phoneNumber, String streetNumber, String street, String city, String zipCode, int id) {
        boolean result = false;
        Date date = Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
        if (dao.update(mail, fname, lname, date, phoneNumber, streetNumber, street, city, zipCode, id)) {
            result = true;
        }
        return result;
    }

    /**
     * Reject the registration of a doctor
     *
     * @param doctor a Doctor object who will be rejected
     */
    public void reject(Doctor doctor) {
        dao.reject(daoPerson.find(doctor.getEmail()).getId());
    }

    /**
     * Accept the registration of a doctor
     *
     * @param doctor a Doctor object who will be accepted
     */
    public void accept(Doctor doctor) {
        // TODO Auto-generated method stub
        dao.accept(doctor);
    }

    /**
     * Get the list of pending doctors
     *
     * @return doctors
     */
    public List<Doctor> getPendingDoctors() {
        // TODO Auto-generated method stub
        return dao.findActive(false);
    }

    /**
     * Returns the list of all doctor's patient
     * @param doctor
     * @return a list of all the patients of the given doctor
     */
    public List<Person> getPatients(Doctor doctor) {
        return dao.getPatients(doctor);
    }

}