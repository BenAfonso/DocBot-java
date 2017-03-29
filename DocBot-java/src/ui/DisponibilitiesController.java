package ui;

import java.net.URL;
import java.util.*;

import facade.DoctorFacade;
import facade.ScheduleFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Disponibility;
import models.Doctor;
import models.Schedule;


/**
 * @author BenAfonso
 */
public class DisponibilitiesController {

	@FXML Label doctorNameLabel;
	@FXML Label errorLabel;
	@FXML TableView disponibilitiesTable;
	@FXML TableColumn dayCol;
	@FXML TableColumn hourEndCol;
	@FXML TableColumn hourStartCol;
	@FXML TableColumn descriptionCol;
	
	public void initialize(URL location, ResourceBundle resources) {
		dayCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("date"));
		hourEndCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("hourEnd"));
		hourStartCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("hourStart"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("description"));
	}
    /**
     * Default constructor
     */
    public DisponibilitiesController() {
    }

  
    public ScheduleFacade scheduleFa;



    /**
     * Get a schedule for the current doctor
     * @return Schedule 
     */
    public Schedule getHisSchedule() {
        // TODO implement here
    	
        return null;
    }

    /**
     * Delete a schedule (Event with button) documentation later
     */
    public void deleteSchedule() {
        // TODO implement here
    }
    
    public void displayDisponibilities() {
    	//disponibilities.getItems().setAll(this.getDoctors());
    }

}