package ui;

import facade.PatientFacade;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.NavigationService;

public class RegisterPatientController {
	PatientFacade patientFacade;
	/********************************************************
	 *
	 * 						Navigation
	 *
	 ********************************************************/
	NavigationService nav = new NavigationService();
	@FXML
	private TextField mailField;
	@FXML
	private TextField fnameField;
	@FXML
	private TextField lnameField;
	@FXML
	private DatePicker birthdayField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Label errorField;
	@FXML
	private TextField phoneField;

	/**
	 * Default constructor
	 */
	public RegisterPatientController() {
		patientFacade = new PatientFacade();
	}

	/**
	 * Register a new account triggered on a button click
	 */
	public void register() {
		boolean registerGood = false;
		registerGood = patientFacade.register(fnameField.getText(), lnameField.getText(), passwordField.getText(), birthdayField.getValue(), phoneField.getText(), mailField.getText());
		if (registerGood) {
			goLogin();
		} else {
			displayError("An error occurred please try again");
		}
	}

	public void back() {
		goLogin();

	}

	/**
	 * Displays an error message if the form isn't valid
	 */
	public void formIsValid() {
		// TODO implement here
	}

	/**
	 *
	 */
	public void displayError(String message) {
		errorField.setText(message);
	}

	/**
	 *
	 */
	public void displaySuccess() {
		// TODO implement here
	}

	public void goLogin() {
		nav.goToLogin();
	}

}
