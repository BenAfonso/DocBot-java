package ui;

import java.net.URL;
import java.util.*;

import facade.PatientFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Patient;
import services.NavigationService;

public class ProfileController {
	
	@FXML private Label label_fn;
	@FXML private Label label_ln;
	@FXML private Label label_mail;
	@FXML private Label label_bd;
	@FXML private Label label_phone;
	@FXML private Label label_error;
	
	/**
	 * Navigation tools
	 */
	NavigationService nav = new NavigationService();
	private Stage prevStage;
	
	
	private PatientFacade patf;
	/**
	 * Inializer for the current view
	 */
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	/**
	 * Set the main application
	 * @param main
	 */
	public void setMainApp(Main main){
	}
	/**
     * Default constructor
     */
    public ProfileController() {
    	patf = new PatientFacade();
    }
    

    /**
     * Load the information from an mail
     * @param mail The mail of the person we want to see 
     * @return Doctor the person found
     */
    public Patient loadInfo(String mail) {
        Patient patient = patf.loadInfo(mail);
        return patient;
    }

    /**
     * Display an error on the view
     */
    public void displayError(String message) {
        System.out.println("An error is occured : "+message+"");
        label_error.setText("An error is occured");
    }
    
    /** Display the information about a specific person
     * @param person The person we want to display
     */
    public void displayInfo(String mail) {
        try{
        	Patient pat = loadInfo(mail);
        	label_fn.setText(pat.getFirstName());
        	label_ln.setText(pat.getLastName());
        	label_mail.setText(pat.getEmail());
        	label_bd.setText(pat.getBirthday().toString());
        	label_phone.setText(pat.getPhoneNumber());
        	
        }catch(Exception e){
        	displayError(e.getMessage());
        }
    }

	public void setPrevStage(Stage prevStage) {
		this.prevStage=prevStage;
		
	}
	
	
	/********************************************************
	 * 
	 * 						Navigation
	 * 
	 ********************************************************/
	
	public void logout(){
		nav.goLogout(prevStage);
	}
	
	public void goToProfile(){
		nav.goToProfile(prevStage);
	}
	
	public void goToListOfDoctors() {
		nav.goToListOfDoctors(prevStage);
	}
}
