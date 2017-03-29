package ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import facade.PersonFacade;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import services.Authentification;
import services.NavigationService;

public class UpdatePasswordController {
	@FXML private TextField oldPasswordField;
	@FXML private TextField newPasswordField;
	@FXML private TextField confirmPasswordField;
	@FXML private Label errorField;


	PersonFacade personFacade;
    /**
     * Default constructor
     */
    public UpdatePasswordController() {
    	personFacade=new PersonFacade();
    }
    
	


    /**
     * Update an account triggered on a button click
     */
    public void updatePassword() {
    	boolean updateSuccessful=false;
    	try {
			if(personFacade.checkCredentials(Authentification.getUser().getEmail(), oldPasswordField.getText())){
				if(newPasswordField.getText().equals(confirmPasswordField.getText())){
					updateSuccessful=personFacade.updatePassword(Authentification.getUser().getEmail(),newPasswordField.getText());
			    	if(updateSuccessful){
			    		goUpdateProfile();
			    	}else{
			    		displayError("An error occurred please try again");
			    	}
				}else{
					displayError("Not the same password");
				}
			}else{
				displayError("Wrong old password");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    /**
     * Back action trigerred on a button click
     */
	public void back(){
		goUpdateProfile();
	}
	
 

	/**
     * Display an error on the view
     */
    public void displayError(String message) {
    	errorField.setText(message);
    }

    
    /********************************************************
	 * 
	 * 						Navigation
	 * 
	 ********************************************************/
    NavigationService nav = new NavigationService();
    public void goUpdateProfile(){
		nav.goUpdateProfile();
	}
}
