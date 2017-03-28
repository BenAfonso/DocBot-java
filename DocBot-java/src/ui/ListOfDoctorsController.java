package ui;

import java.net.URL;
import java.util.*;

import facade.DoctorFacade;
import models.Doctor;
import models.Person;
import services.NavigationService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * @author BenAfonso
 */
public class ListOfDoctorsController implements javafx.fxml.Initializable {

    @FXML TableView<Doctor> doctorsTable;
    @FXML TableColumn<Doctor, String> cityCol;
    @FXML TableColumn<Doctor, String> firstNameCol;
    @FXML TableColumn<Doctor, String> lastNameCol;
    private DoctorFacade doctorFacade;
    
	NavigationService nav = new NavigationService();

	private Stage prevStage;
	private List<Doctor> list;
	/**
	 * Inializer for the current view
	 */
	public void initialize(URL location, ResourceBundle resources) {
		
    	this.displayDoctors();

	}
	
	
	/**
	 * Set the main application
	 * @param main
	 */
	public void setMainApp(Main main){
	}
	


	public void setPrevStage(Stage prevStage) {
		this.prevStage=prevStage;
		
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
    	
    	
    	firstNameCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("lastName"));
        cityCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("city"));
		doctorsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		doctorsTable.getColumns().get(0).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.33));
		doctorsTable.getColumns().get(1).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.33));
		doctorsTable.getColumns().get(2).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.33));
		doctorsTable.getItems().setAll(this.getDoctors());
    	
            
    }
	public void logout(){
		nav.goLogout(prevStage);
	}
	
	public void goToProfile(){
		nav.goToProfile(prevStage);
	}
	
	public void goToListOfDoctors() {
		nav.goToListOfDoctors(prevStage);
	}

}