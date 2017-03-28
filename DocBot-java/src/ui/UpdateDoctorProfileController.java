package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import facade.DoctorFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Doctor;
import services.Authentification;
import services.NavigationService;

public class UpdateDoctorProfileController {
	@FXML private TextField fnameField;
	@FXML private TextField lnameField;
	@FXML private TextField streetNumberField;
	@FXML private TextField streetField;
	@FXML private TextField zipCodeField;
	@FXML private TextField cityField;
	@FXML private DatePicker birthdayField;
	@FXML private Label errorField;
	@FXML private TextField phoneField;
	
	/**
	 * Navigation tools
	 */
	NavigationService nav = new NavigationService();
	private Stage prevStage;

	DoctorFacade doctorFacade;
    /**
     * Default constructor
     */
    public UpdateDoctorProfileController() {
    		doctorFacade=new DoctorFacade();
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
    	updateSuccessful=doctorFacade.update(Authentification.getUser().getEmail(),fnameField.getText(),lnameField.getText(),birthdayField.getValue(),phoneField.getText(),streetNumberField.getText(),streetField.getText(),cityField.getText(),zipCodeField.getText(),Authentification.getUser().getId());
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
        Doctor doc = doctorFacade.loadInfo(Authentification.getUser().getEmail());
        fnameField.setText(doc.getFirstName());
        lnameField.setText(doc.getLastName());
        
    }
    
    /********************************************************
	 * 
	 * 						Navigation
	 * 
	 ********************************************************/
	
	public void goToProfile(){
		nav.goToProfile(prevStage);
	}
	
	
}
