package facade;

import dao.AbstractDAOFactory;
import dao.PatientDAO;
import dao.PersonDAO;
import models.Patient;
import models.Person;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * @author BenAfonso
 */
public class PatientFacade {


    /**
     *
     */
    public PatientDAO dao;

    public PersonDAO daoPerson;

    /**
     *
     */
    public AbstractDAOFactory adf;

    /**
     * Default constructor
     */
    public PatientFacade() {
        adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.PG_DAOFACTORY);
        // Fetching link between database and models
        dao = adf.getPatientDAO();
        daoPerson = adf.getPersonDAO();
    }


    /**
     * load the information about the Patient
     *
     * @param mail the mail associated with the user
     * @return the Patient linked to the mail
     */
    public Patient loadInfo(String mail) {
        Patient patient = null;
        try {
            patient = dao.find(mail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return patient;
    }

    public boolean register(String fname, String lname, String password, LocalDate birthday, String phoneNumber, String mail) {
        boolean result = false;
        Date date = Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Patient patientToRegister = new Patient(fname, lname, password, date, phoneNumber, mail);
        if (daoPerson.create(patientToRegister)) {
            int id = daoPerson.find(mail).getId();
            if (dao.create(id)) {
                result = true;
            }
        }
        return result;

    }

    /**
     * Update a profile patient
     *
     * @param patient a Patient object who will be updated
     */
    public boolean update(String mail, String fname, String lname, LocalDate birthday, String phoneNumber) {
        boolean result = false;
        Date date = Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
        if (dao.update(mail, fname, lname, date, phoneNumber)) {
            result = true;
        }
        return result;
    }

    public List<Person> getAllPatients() {
        return dao.getAllPatients();
    }
}