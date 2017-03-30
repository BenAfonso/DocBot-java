package ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import facade.DoctorFacade;
import facade.RequestAppointmentFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.*;
import services.Authentification;

public class SeeHisAppointmentsController {
	
	private List<RequestAppointment> appointments;
	
	@FXML
	private TableView<RequestAppointment> table;
	@FXML
	private TableColumn<RequestAppointment, String> firstNameColumn;
	@FXML
	private TableColumn<RequestAppointment, String> lastNameColumn;
	@FXML
	private TableColumn<RequestAppointment, String> startingHourColumn;
	@FXML
	private TableColumn<RequestAppointment, String> endingHourColumn;
	@FXML
	private TableColumn<RequestAppointment, String> dateColumn;
	@FXML
	private TableColumn<RequestAppointment, String> statusColumn;
	
	public SeeHisAppointmentsController() {
		super();

	}
	
	/**
	 * Inializer for the current view
	 */
	
	public void initialize() {
		this.getAppointment();
		ObservableList<RequestAppointment> data = FXCollections.observableArrayList();
		for (RequestAppointment app: this.appointments){
			data.add(app);
		}
		System.out.println(data.size());
		table.setItems(data);
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("lastName"));
		startingHourColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("hourMinuteStart"));
		endingHourColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("hourMinuteEnd"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("date"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("status"));
		
		
	}

	private void getAppointment() {
		
		RequestAppointmentFacade appointmentFacade = new RequestAppointmentFacade();
		this.appointments = appointmentFacade.getAppointmentsFrom((Patient) Authentification.getUser());
		
	}
}
