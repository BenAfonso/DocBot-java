package test;
import static org.junit.Assert.*;

import org.junit.Test;

import models.*;
import services.Authentification;

public class testAuthentification {

	@Test
	public void testConnect() {
		Person person = new Person();
		Authentification.connect(person);
		assertEquals(Authentification.getUser(),person);
	}
	
	@Test
	public void testConnect2() {
		Person person = new Person();
		Authentification.connect(person);
		Person person2 = new Person();
		Authentification.connect(person2);
		assertEquals(Authentification.getUser(),person2);
	}
	
	@Test
	public void testisDoctor() {
		Person person = new Doctor();
		Authentification.connect(person);
		assertTrue(Authentification.isDoctor());
	}
	
	@Test
	public void testisPatient() {
		Person person = new Patient(null, null, null, null, null, null);
		Authentification.connect(person);
		assertTrue(Authentification.isPatient());
	}

}
