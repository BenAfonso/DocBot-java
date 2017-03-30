package test;

import models.Administrator;
import models.Doctor;
import models.Patient;
import models.Person;
import org.junit.Test;
import services.Authentification;

import static org.junit.Assert.*;

public class testAuthentification {

    @Test
    public void testConnect() {
        Person person = new Person();
        Authentification.connect(person);
        assertEquals(Authentification.getUser(), person);
    }

    @Test
    public void testConnect2() {
        Person person = new Person();
        Authentification.connect(person);
        Person person2 = new Person();
        Authentification.connect(person2);
        assertEquals(Authentification.getUser(), person2);
    }

    @Test
    public void testIsDoctor() {
        Person person = new Doctor();
        Authentification.connect(person);
        assertTrue(Authentification.isDoctor());
        assertFalse(Authentification.isAdministrator());
        assertFalse(Authentification.isPatient());
    }


    @Test
    public void testIsAdministrator() {
        Person person = new Administrator();
        Authentification.connect(person);
        assertTrue(Authentification.isAdministrator());
        assertFalse(Authentification.isDoctor());
        assertFalse(Authentification.isPatient());
    }

    @Test
    public void testIsPatient() {
        Person person = new Patient(null, null, null, null, null, null);
        Authentification.connect(person);
        assertTrue(Authentification.isPatient());
        assertFalse(Authentification.isDoctor());
        assertFalse(Authentification.isAdministrator());
    }

}
