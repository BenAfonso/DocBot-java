package ui;

import java.util.*;

import facade.DoctorFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.Doctor;

public class ProfileDoctorController {
	
	@FXML private Label label_fn;
	@FXML private Label label_ln;
	@FXML private Label label_mail;
	@FXML private Label label_bd;
	@FXML private Label label_phone;
	@FXML private Label label_siret;
	@FXML private Label label_num;
	@FXML private Label label_street;
	@FXML private Label label_zip;
	@FXML private Label label_city;
	@FXML private Label label_error;
	
	
	
	private DoctorFacade docf;
	
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
        	label_num.setText(doc.getStreetNumber());
        	label_street.setText(doc.getStreet());
        	label_zip.setText(doc.getZipCode());
        	label_city.setText(doc.getCity());
        	
     
        }catch(Exception e){
        	displayError(e.getMessage());
        }
    }
}
