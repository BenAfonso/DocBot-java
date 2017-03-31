package ui;

import facade.DoctorFacade;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.NavigationService;

public class RegisterDoctorController {
	DoctorFacade doctorFacade;
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
	private TextField siretField;
	@FXML
	private TextField streetNumberField;
	@FXML
	private TextField streetField;
	@FXML
	private TextField zipCodeField;
	@FXML
	private TextField cityField;
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
    public RegisterDoctorController() {
		doctorFacade = new DoctorFacade();
	}

    /**
     * Register a new account triggered on a button click
     */
    public void register() {
		boolean registerGood = false;
		registerGood = doctorFacade.register(fnameField.getText(), lnameField.getText(), passwordField.getText(), birthdayField.getValue(), phoneField.getText(), mailField.getText(), siretField.getText(), streetNumberField.getText(), streetField.getText(), cityField.getText(), zipCodeField.getText());
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
	 *
	 */
    public void displayError(String message) {
		errorField.setText(message);
	}

    

	public void goLogin() {
		nav.goToLogin();
	}
}
