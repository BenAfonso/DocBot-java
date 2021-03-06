package ui;

import facade.PatientFacade;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Patient;
import services.Authentification;
import services.NavigationService;

import java.time.LocalDate;

public class UpdateProfileController {
	PatientFacade patientFacade;
	/********************************************************
	 *
	 * 						Navigation
	 *
	 ********************************************************/
	NavigationService nav = new NavigationService();
	@FXML
	private TextField fnameField;
	@FXML
	private TextField lnameField;
	@FXML
	private DatePicker birthdayField;
	@FXML
	private Label errorField;
	@FXML
	private TextField phoneField;


    /**
     * Default constructor
     */
    public UpdateProfileController() {
		patientFacade = new PatientFacade();
	}

    /**
     * Update an account triggered on a button click
     */
    public void updateProfile() {
		boolean updateSuccessful = false;
		updateSuccessful = patientFacade.update(Authentification.getUser().getEmail(), fnameField.getText(), lnameField.getText(), birthdayField.getValue(), phoneField.getText());
		if (updateSuccessful) {
			goToProfile();
		} else {
			displayError("An error occurred please try again");
		}
	}

    /**
     * Back action trigerred on a button click
     */
	public void back() {
		goToProfile();
	}

	/**
	 * Display an error on the view
     */
    public void displayError(String message) {
		errorField.setText(message);
	}

    /**
	 *
	 */
    public void displayInfo() {
        Patient doc = patientFacade.loadInfo(Authentification.getUser().getEmail());
        fnameField.setText(doc.getFirstName());
        lnameField.setText(doc.getLastName());
        phoneField.setText(doc.getPhoneNumber());

		LocalDate date = new java.sql.Date(doc.getBirthday().getTime()).toLocalDate();
		birthdayField.setValue(date);

	}

	public void goToProfile() {
		nav.goToProfile();
	}

	public void goUpdatePassword() {
		nav.goUpdatePassword();
	}

}
