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
	
	/**
	 * Navigation tools
	 */
	NavigationService nav = new NavigationService();
	private Stage prevStage;

	PersonFacade personFacade;
    /**
     * Default constructor
     */
    public UpdatePasswordController() {
    	personFacade=new PersonFacade();
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
    public void updatePassword() {
    	boolean updateSuccessful=false;
    	try {
			if(personFacade.checkCredentials(Authentification.getUser().getEmail(), oldPasswordField.getText())){
				if(newPasswordField.getText()!=confirmPasswordField.getText()){
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
	
    public void goUpdateProfile(){
		nav.goUpdateProfile(prevStage);
	}
}
