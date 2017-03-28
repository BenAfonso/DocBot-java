package ui.ListOfDoctors;

import java.net.URL;
import java.util.*;
import java.util.function.Predicate;

import facade.DoctorFacade;
import models.Doctor;
import ui.Main;
import ui.MenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author BenAfonso
 */
public class ListOfDoctorsController extends MenuController implements javafx.fxml.Initializable {

    @FXML TableView<Doctor> doctorsTable;
    @FXML TableColumn<Doctor, String> cityCol;
    @FXML TableColumn<Doctor, String> firstNameCol;
    @FXML TableColumn<Doctor, String> lastNameCol;
    @FXML TableColumn<Doctor, String> activeCol;
    
    @FXML Button pendingDoctorsButton;
    @FXML Button allDoctorsButton;
    @FXML TextField cityFilterTextField;
    
    private DoctorFacade doctorFacade;
    

	private List<Doctor> list;
	/**
	 * Inializer for the current view
	 */
	public void initialize(URL location, ResourceBundle resources) {
		
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("lastName"));
		cityCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("city"));
		activeCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("isValidated"));

		doctorsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		doctorsTable.getColumns().get(0).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.3));
		doctorsTable.getColumns().get(1).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.3));
		doctorsTable.getColumns().get(2).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.3));
		doctorsTable.getColumns().get(3).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.1));

    	this.displayDoctors();

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
    public ListOfDoctorsController() {
    	this.doctorFacade = new DoctorFacade();
    	this.getDoctors();
    }
    


    /**
     * 
     */
      public List<Doctor> doctors;



    /**
     * @return 
     * 
     */
    public List<Doctor> getPendingDoctors() {
        // TODO implement here
    	this.list = this.doctorFacade.getPendingDoctors();
    	return this.list;
    	
    }
    
    /**
     * @return 
     * 
     */
    public List<Doctor> getDoctors() {
        // TODO implement here
    	this.list = this.doctorFacade.getDoctors();
    	return this.list;
    	
    }

    /**
     * @param speciality
     */
    public void getDoctorsBySpeciality(String speciality) {
        // TODO implement here
    }

    /**
     * @param city
     */
    public void getDoctorsByCity(String city) {
        // TODO implement here
    }

    /**
     * 
     */
    public void displayDoctors() {
        // TODO implement here 	
		doctorsTable.getItems().setAll(this.getDoctors());
    }
    
    
    
    public void displayPendingDoctors() {
		doctorsTable.getItems().setAll(this.getPendingDoctors());
    }

}
