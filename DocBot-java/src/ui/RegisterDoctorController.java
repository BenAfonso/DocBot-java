package ui;

import java.io.IOException;
import java.util.*;


import facade.DoctorFacade;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.NavigationService;

public class RegisterDoctorController {
	@FXML private TextField mailField;
	@FXML private TextField fnameField;
	@FXML private TextField lnameField;
	@FXML private TextField siretField;
	@FXML private TextField streetNumberField;
	@FXML private TextField streetField;
	@FXML private TextField zipCodeField;
	@FXML private TextField cityField;

	@FXML private DatePicker birthdayField;
	@FXML private PasswordField passwordField;
	@FXML private Label errorField;
	@FXML private TextField phoneField;


	DoctorFacade doctorFacade;
	
    /**
     * Default constructor
     */
    public RegisterDoctorController() {
    		doctorFacade=new DoctorFacade();
    }
	

    /**
     * Register a new account triggered on a button click
     */
    public void register() {
    	boolean registerGood=false;
    	registerGood=doctorFacade.register(fnameField.getText(),lnameField.getText(),passwordField.getText(),birthdayField.getValue(),phoneField.getText(),mailField.getText(), siretField.getText(),streetNumberField.getText(),streetField.getText(),cityField.getText(),zipCodeField.getText());
    		if(registerGood){
    			goLogin();
    		}else{
    			errorField.setText("An error occurred please try again");
    		}
    }

	public void back(){
		goLogin();
	}
    /**
     * Displays an error message if the form isn't valid
     * 
     */
    public void formIsValid() {
        // TODO implement here
    }

    /**
     * 
     */
    public void displayError() {
        // TODO implement here
    }

    /**
     * 
     */
    public void displaySuccess() {
        // TODO implement here
    }

    
    /********************************************************
	 * 
	 * 						Navigation
	 * 
	 ********************************************************/
    NavigationService nav = new NavigationService();
	
	public void goLogin(){
		nav.goToLogin();
	}
}
