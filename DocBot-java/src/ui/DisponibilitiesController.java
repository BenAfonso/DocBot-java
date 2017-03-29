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
import models.Person;
import models.Schedule;


/**
 * @author BenAfonso
 */
public class DisponibilitiesController implements javafx.fxml.Initializable {

	@FXML Label doctorNameLabel;
	@FXML Label errorLabel;
	@FXML TableView<Disponibility> disponibilitiesTable;
	@FXML TableColumn<Disponibility, String> dayCol;
	@FXML TableColumn<Disponibility, String> hourEndCol;
	@FXML TableColumn<Disponibility, String> hourStartCol;
	@FXML TableColumn<Disponibility, String> descriptionCol;
	
	public void initialize(URL location, ResourceBundle resources) {
		dayCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("date"));
		hourEndCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("hourEndFull"));
		hourStartCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("hourStartFull"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("description"));				
	}
    /**
     * Default constructor
     */
    public DisponibilitiesController() {
    	scheduleFa = new ScheduleFacade(); // To refactor 
    }

  
    public ScheduleFacade scheduleFa;
    
    public List<Disponibility> getDisponibilities(Doctor doctor) {
    	
    	return scheduleFa.getDoctorDisponibilities(doctor);
    	
    }
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
    
    public void displayDisponibilities(Doctor doctor) {
    	doctorNameLabel.setText(doctor.getLastName());
    	disponibilitiesTable.getItems().setAll(this.getDisponibilities(doctor));
    }

}