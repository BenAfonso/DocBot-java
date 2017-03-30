package test.facade;

import facade.PersonFacade;
import models.Doctor;
import models.Patient;
import models.Person;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by benjaminafonso on 30/03/2017.
 */
public class PersonFacadeTest {
    @Test
    public void checkCredentials() throws Exception {
        PersonFacade pfacade = new PersonFacade();
        Person p = new Person("fname", "lname", "1234", new Date(), "023232323", "a@b.cd");
        assertTrue(pfacade.checkCredentials(p.getEmail(), p.getPassword()));
        assertFalse(pfacade.checkCredentials(p.getEmail(), p.getPassword() + "12"));
    }

    @Test
    public void login() throws Exception {
        PersonFacade pfacade = new PersonFacade();
        Person p = new Person("fname", "lname", "1234", new Date(), "023232323", "a@b.cd");
        assertTrue(pfacade.login(p.getEmail(), p.getPassword()));
        assertFalse(pfacade.login(p.getEmail(), p.getPassword() + "12"));
    }

    @Test
    public void updatePassword() throws Exception {
        // Async
    }

    @Test
    public void isValidated() throws Exception {
        PersonFacade pfacade = new PersonFacade();
        Doctor d1 = new Doctor("fname", "lname", "123", new Date(), "0112", "a@b.cd", "AZEAZE", "23", "abc", "AA", "222", false);
        Doctor d2 = new Doctor("fname", "lname", "123", new Date(), "0112", "a@b.cd", "AZEAZE", "23", "abc", "AA", "222");
        assertFalse(pfacade.isValidated(d1));
        d1.setValidated(true);
        assertTrue(pfacade.isValidated(d1));
        assertFalse(pfacade.isValidated(d2));
    }

    @Test
    public void isBlocked() throws Exception {
        PersonFacade pfacade = new PersonFacade();
        Patient p1 = new Patient("fname", "lname", "123", new Date(), "02332", "aa@b.cd", "121", "AZE", "azea", "aze", "aea");
        assertFalse(p1.isBlocked());
        p1.setBlocked(true);
        assertTrue(p1.isBlocked());
    }

}