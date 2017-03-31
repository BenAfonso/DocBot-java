package facade;

import dao.*;
import models.Administrator;
import models.Doctor;
import models.Patient;
import models.Person;
import services.Authentification;

public class PersonFacade {


    /********************************************************
     *
     * 						Properties
     *
     ********************************************************/


    PersonDAO userDao;
    DoctorDAO docDao;
    PatientDAO patientDao;
    AdministratorDAO adminDao;
    AbstractDAOFactory adf;


    /********************************************************
     *
     * 						Constructors
     *
     ********************************************************/


    public PersonFacade() {
        adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.PG_DAOFACTORY);
        // Fetching link between database and models
        userDao = adf.getPersonDAO();
        docDao = adf.getDoctorDAO();
        patientDao = adf.getPatientDAO();
        adminDao = adf.getAdministratorDAO();
    }


    /********************************************************
     *
     * 						Functions
     *
     ********************************************************/


    /**
     * Checks the credentials for an email
     *
     * @param email    the user's email
     * @param password the user's password
     * @return boolean true if the user is real, false otherwise
     * @throws Exception the esxception is thrown when the user doesn't exist
     */
    public boolean checkCredentials(String email, String password) throws Exception {
        Person user = userDao.find(email);

        if (user == null) {
            throw new Exception("User doesn't exist");
        }
        Doctor doc = docDao.find(user.getId());
        if (doc != null) {
            Authentification.connect(doc);
        } else {
            Patient pat = patientDao.find(user.getId());
            if (pat != null) {
                Authentification.connect(pat);
            } else {
                Administrator admin = adminDao.find(user.getId());
                if (admin != null) {
                    Authentification.connect(admin);
                }
            }
        }
        return (user.getPassword().equals(password));
    }

    /**
     * Log a user
     *
     * @param username the user's username
     * @param password the user's password
     * @return boolean true if the user is logged, false otherwise
     */
    public boolean login(String username, String password) {
        try {
            return checkCredentials(username, password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("An error occured while login");
            return false;
        }
    }

    /**
     * Updates a doctor's password given his email
     * @param mail
     * @param newPassword
     * @return
     */
    public boolean updatePassword(String mail, String newPassword) {
        boolean result = false;
        if (userDao.updatePassword(mail, newPassword)) {
            result = true;
        }
        return result;
    }

    /**
     * Returns true if the person's account is validated
     *
     * @param person
     * @return
     */
    public boolean isValidated(Person person) {
        boolean result = false;
        if (docDao.isValidated(person.getId())) {
            result = true;
        }
        return result;
    }

    /**
     * Returns true if the person is blocked by the administrator
     * @param person
     * @return
     */
    public boolean isBlocked(Person person) {
        boolean result = false;
        if (!patientDao.isBlocked(person.getId())) {
            result = true;
        }
        return result;
    }

}
