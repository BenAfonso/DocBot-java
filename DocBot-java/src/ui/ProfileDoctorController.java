package ui;

import java.net.URL;
import java.util.*;

import facade.DoctorFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Doctor;
import services.Authentification;

public class ProfileDoctorController {
	
	@FXML private Label label_fn;
	@FXML private Label label_ln;
	@FXML private Label label_mail;
	@FXML private Label label_bd;
	@FXML private Label label_phone;
	@FXML private Label label_siret;
	@FXML private Label label_adress;
	@FXML private Label label_error;
	
	private Stage prevStage;
	
	private DoctorFacade docf;
	/**
	 * Inializer for the current view
	 */
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	/**
     * Default constructor
     */
    public ProfileDoctorController() {
    	docf = new DoctorFacade();
    }
    

    /**
     * Load the information from an mail
     * @param mail The mail of the person we want to see 
     * @return Doctor the person found
     */
    public Doctor loadInfo(String mail) {
        Doctor doctor = docf.loadInfo(mail);
        return doctor;
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
        	Doctor doc = loadInfo(mail);
        	label_fn.setText(doc.getFisrtName());
        	label_ln.setText(doc.getLastName());
        	label_mail.setText(doc.getEmail());
        	label_bd.setText(doc.getBirthday().toString());
        	label_phone.setText(doc.getPhoneNumber());
        	label_siret.setText(doc.getSiret());
        	String adress = ""+doc.getStreetNumber()+" "+doc.getStreet()+" "+doc.getZipCode()+" "+doc.getCity()+"";
        	label_adress.setText(adress);
        	
        }catch(Exception e){
        	displayError(e.getMessage());
        }
    }

	public void setPrevStage(Stage prevStage) {
		this.prevStage=prevStage;
		
	}
}
