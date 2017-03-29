package ui;

import java.time.ZoneId;
import java.util.*;

import facade.DoctorFacade;
import facade.ScheduleFacade;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.Authentification;
import services.NavigationService;

/**
 * @author BenAfonso
 */
public class AddDisponibilityController {

	@FXML private TextField hourStartField;
	@FXML private TextField minStartField;
	@FXML private TextField hourEndField;
	@FXML private TextField minEndField;
	@FXML private TextField descriptionField;
	@FXML private Label errorField;

	@FXML private DatePicker dateField;
    /**
     * Default constructor
     */
    public AddDisponibilityController() {
    	scheduleFa=new ScheduleFacade();
    }

    /**
     * 
     */
    public DoctorFacade doctorFa;

    /**
     * 
     */
    public ScheduleFacade scheduleFa;


    /**
     * Creates a new schedule
     */
    public void createSchedule() {
        // TODO implement here
    }
    
    /**
     * Creates a new Disponibility
     */
    public void createDisponibility() {
		Date date = Date.from(dateField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        scheduleFa.createDisponibility(Authentification.getUser().getId(), date, Integer.parseInt(hourStartField.getText()), Integer.parseInt(minStartField.getText()), Integer.parseInt(hourEndField.getText()), Integer.parseInt(minEndField.getText()), descriptionField.getText());
    }
    
    /**
     * Display an success message into the view
     */
    public void displayValid() {
        // TODO implement here
    }

    /**
     * Display an error message into the view
     */
    public void displayError() {
        // TODO implement here
    }
    
    public void back(){
    	goDisponibilities();
    }
    
    /********************************************************
	 * 
	 * 						Navigation
	 * 
	 ********************************************************/
    NavigationService nav = new NavigationService();
    public void goDisponibilities(){
    	nav.goToMyDisponibilities();
    }

}