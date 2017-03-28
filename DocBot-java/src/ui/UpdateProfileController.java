package ui;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

import application.Main;
import facade.PatientFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Patient;
import services.Authentification;
import services.NavigationService;

public class UpdateProfileController {
	@FXML private TextField fnameField;
	@FXML private TextField lnameField;
	@FXML private DatePicker birthdayField;
	@FXML private Label errorField;
	@FXML private TextField phoneField;
	
	/**
	 * Navigation tools
	 */
	NavigationService nav = new NavigationService();
	private Stage prevStage;

	PatientFacade patientFacade;
    /**
     * Default constructor
     */
    public UpdateProfileController() {
    	patientFacade=new PatientFacade();
    }
    /**
	 * Inializer for the current view
	 */
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void setPrevStage(Stage stage){
		this.prevStage = stage;
	}
	/**
	 * Set the main application
	 * @param main
	 */
	public void setMainApp(Main main){
	}

    /**
     * Update an account triggered on a button click
     */
    public void updateProfile() {
    	boolean updateSuccessful=false;
    	updateSuccessful=patientFacade.update(Authentification.getUser().getEmail(),fnameField.getText(),lnameField.getText(),birthdayField.getValue(),phoneField.getText());
    	if(updateSuccessful){
    		goToProfile();
    	}else{
    		displayError("An error occurred please try again");
    	}
    }

    /**
     * Back action trigerred on a button click
     */
	public void back(){
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
   
        LocalDate date = new java.sql.Date(doc.getBirthday().getTime() ).toLocalDate();
        birthdayField.setValue(date);
        
    }
    
    /********************************************************
	 * 
	 * 						Navigation
	 * 
	 ********************************************************/
	
	public void goToProfile(){
		nav.goToProfile();
	}
	
	
}
