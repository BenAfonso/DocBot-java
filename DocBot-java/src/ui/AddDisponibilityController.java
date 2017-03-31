package ui;

import facade.DoctorFacade;
import facade.ScheduleFacade;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.Authentification;
import services.NavigationService;

import java.time.ZoneId;
import java.util.Date;


public class AddDisponibilityController {

	/********************************************************
    *
    * 						DAO & Facade
    *
    ********************************************************/
    public DoctorFacade doctorFa;
    public ScheduleFacade scheduleFa;
    
    
    /********************************************************
    *
    * 						Variables
    *
    ********************************************************/
    @FXML
    private TextField hourStartField;
    @FXML
    private TextField minStartField;
    @FXML
    private TextField hourEndField;
    @FXML
    private TextField minEndField;
    @FXML
    private TextField descriptionField;
    @FXML
    private Label errorField;
    @FXML
    private DatePicker dateField;


    /**
     * Default constructor
     */
    public AddDisponibilityController() {
        scheduleFa = new ScheduleFacade();
    }


    /**
     * Creates a new Disponibility
     */
    public void createDisponibility() {
        Date date = Date.from(dateField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        if (scheduleFa.createDisponibility(Authentification.getUser().getId(), date, Integer.parseInt(hourStartField.getText()), Integer.parseInt(minStartField.getText()), Integer.parseInt(hourEndField.getText()), Integer.parseInt(minEndField.getText()), descriptionField.getText())) {
            goDisponibilities();
        }
    }


    /********************************************************
    *
    * 						Navigation
    *
    ********************************************************/
   NavigationService nav = new NavigationService();
    public void back() {
        goDisponibilities();
    }

    public void goDisponibilities() {
        nav.goToMyDisponibilities();
    }

}