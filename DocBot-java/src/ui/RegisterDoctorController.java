package ui;

import java.io.IOException;
import java.util.*;

import facade.DoctorFacade;
import facade.PersonFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
	private Stage prevStage;

	DoctorFacade doctorFacade;
	@FXML private Button btnValidate;
    /**
     * Default constructor
     */
    public RegisterDoctorController() {
    		doctorFacade=new DoctorFacade();
    }
	public void setPrevStage(Stage stage){
		this.prevStage = stage;
	}

    /**
     * Register a new account triggered on a button click
     */
    public void register() {
    	boolean registerGood=false;
    	registerGood=doctorFacade.register(fnameField.getText(),lnameField.getText(),passwordField.getText(),birthdayField.getValue(),phoneField.getText(),mailField.getText(), siretField.getText(),streetNumberField.getText(),streetField.getText(),cityField.getText(),zipCodeField.getText());
    		if(registerGood){
    			FXMLLoader loader=new FXMLLoader();
    			loader.setLocation(Main.class.getResource("./LoginView.fxml"));
    			AnchorPane loginView;
    			try {
    				loginView = (AnchorPane) loader.load();
    				Scene scene=new Scene(loginView);
    				prevStage.setScene(scene);
    				prevStage.show();
    				LoginController controller=loader.getController();
    				controller.setPrevStage(prevStage);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}else{
    			errorField.setText("An error occurred please try again");
    		}
    }

	public void back(){
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("./LoginView.fxml"));
		AnchorPane loginView;
		try {
			loginView = (AnchorPane) loader.load();
			Scene scene=new Scene(loginView);
			prevStage.setScene(scene);
			prevStage.show();
			LoginController controller=loader.getController();
			controller.setPrevStage(prevStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

}
