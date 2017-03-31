package ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import facade.AppointmentFacade;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Appointment;
import services.Authentification;

public class AppointmentDoctorController implements javafx.fxml.Initializable {

	/********************************************************
    *
    * 						DAO & Facade
    *
    ********************************************************/
	private AppointmentFacade appointmentFacade;
	
	/********************************************************
    *
    * 						Variables
    *
    ********************************************************/
	@FXML
    TableView<Appointment> appointmentTableView;
    @FXML
    TableColumn<Appointment, String> dateColumn;
    @FXML
    TableColumn<Appointment, String> hourStartColumn;
    @FXML
    TableColumn<Appointment, String> hourEndColumn;
    @FXML
    TableColumn<Appointment, String> fnameColumn;
    @FXML
    TableColumn<Appointment, String> lnameColumn;
 
    
    private List<Appointment> appointments;
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dateColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("date"));
        hourStartColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("hourStartFull"));
        hourEndColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("hourEndFull"));
        fnameColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("firstName"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("lastName"));
		
	}

	/**
     * Default constructor
     */
	public AppointmentDoctorController(){
		appointmentFacade = new AppointmentFacade();
	}
	
	/**
	 * Get the appointments of a doctor
     * @return a list of appointment object, the list of the doctor appointments
     */
    public List<Appointment> getAppointmentOf() {
        this.appointments = appointmentFacade.getAppointment(Authentification.getUser());
        return this.appointments;
    }

    /**
     * Display the appointment of a doctor in the tableView
     */
    public void displayAppointments() {
    	appointmentTableView.getItems().setAll(this.getAppointmentOf());
    }
}
