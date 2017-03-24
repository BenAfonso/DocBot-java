package ui;

import java.net.URL;
import java.util.*;

import facade.DoctorFacade;
import models.Doctor;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author BenAfonso
 */
public class ListOfDoctorsController implements javafx.fxml.Initializable {

	
	/**
	 * Inializer for the current view
	 */
	public void initialize(URL location, ResourceBundle resources) {
	}
	
    /**
     * Default constructor
     */
    public ListOfDoctorsController() {
    	this.doctorFacade = new DoctorFacade();
    	this.getDoctors();
    }
    
    @FXML TableView doctorsTable;
    @FXML TableColumn cityCol;
    @FXML TableColumn firstNameCol;
    @FXML TableColumn lastNameCol;
    private DoctorFacade doctorFacade;
    

    /**
     * 
     */
//    public JTextField cityFilter;

    /**
     * 
     */
 //   public JTextField specialityFilter;

    /**
     * 
     */
      public List<Doctor> doctors;



    /**
     * 
     */
    public void getDoctors() {
        // TODO implement here
    	ArrayList<Doctor> list = this.doctorFacade.getDoctors();
    }

    /**
     * @param speciality
     */
    public void getDoctorsSpeciality(String speciality) {
        // TODO implement here
    }

    /**
     * @param city
     */
    public void getDoctorsCity(String city) {
        // TODO implement here
    }

    /**
     * 
     */
    public void displayDoctors() {
        // TODO implement here
    }

}