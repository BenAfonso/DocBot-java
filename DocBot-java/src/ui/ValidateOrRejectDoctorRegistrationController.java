package ui;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import facade.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import models.*;

public class ValidateOrRejectDoctorRegistrationController {

	private Doctor[] doc;

	@FXML
	private TableView<Doctor> table;
	@FXML
	private TableColumn<Doctor, String> firstNameColumn;
	@FXML
	private TableColumn<Doctor, String> lastNameColumn;
	@FXML
	private TableColumn<Doctor, String> siretColumn;
	@FXML
	private TableColumn<Doctor, String> cityColumn;
	@FXML
	private TableColumn<Doctor, String> zipColumn;


	private Stage prevStage;


	public ValidateOrRejectDoctorRegistrationController() {
		// TODO Auto-generated constructor stub
		super();
		this.doc = new Doctor[2];

	}
	@FXML
	private void initialize() {

		//Filling up the data
		this.getUncheckedDoctors();
		ObservableList<Doctor> data = FXCollections.observableArrayList();
		for (Doctor doc: this.doc){
			data.add(doc);
			System.out.println(doc.getLastName());
			System.out.println(doc.getFirstName());
		}


		table.setItems(data);

		firstNameColumn.setCellValueFactory( 
				new PropertyValueFactory<Doctor,String>("firstName")
				);
		lastNameColumn.setCellValueFactory( 
				new PropertyValueFactory<Doctor,String>("lastName")
				);
		siretColumn.setCellValueFactory( 
				new PropertyValueFactory<Doctor,String>("siret")
				);
		cityColumn.setCellValueFactory( 
				new PropertyValueFactory<Doctor,String>("city")
				);
		zipColumn.setCellValueFactory( 
				new PropertyValueFactory<Doctor,String>("zipCode")
				);
	}

	/**
	 * Sets the previous stage
	 * @param stage
	 */
	public void setPrevStage(Stage stage){
		this.prevStage = stage;
	}

	/**
	 * Called when the user clicks the accept button. 
	 * Accept the doctor registration
	 */
	@FXML
	private void acceptDoctor() {
		DoctorFacade docFacade = new DoctorFacade();
		Doctor selectedDoctor = table.getSelectionModel().getSelectedItem();
		if (selectedDoctor != null) {
			docFacade.accept(selectedDoctor);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Doctor Selected");
			alert.setContentText("Please select a doctor in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the reject button.
	 * Reject the doctor registration
	 */
	@FXML
	private void rejectDoctor() {
		DoctorFacade docFacade = new DoctorFacade();
		Doctor selectedDoctor = table.getSelectionModel().getSelectedItem();
		if (selectedDoctor != null) {
			docFacade.reject(selectedDoctor);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Doctor Selected");
			alert.setContentText("Please select a doctor in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the see Profil button.
	 */
	@FXML
	private void goToDoctorProfil() {
		Doctor selectedDoctor = table.getSelectionModel().getSelectedItem();
		if (selectedDoctor != null) {
			//GO TO PROFIL
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Doctor Selected");
			alert.setContentText("Please select a doctor in the table.");
			alert.showAndWait();
		}
	}


	/**
	 * Set the main application
	 * @param main
	 */
	public void setMainApp(Main main){
	}


	public void start(Stage primaryStage) {
		//Initilisation of the view
		StackPane page;
		try {
			page = (StackPane) FXMLLoader.load(Main.class.getResource("./ValidateOrRejectDoctorRegistration.fxml"));

			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Validate or reject doctors's registration");
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ici");

	}

	public void getUncheckedDoctors(){
		// TEST WITH MOCK DATA
		Doctor[] doc = new Doctor[2];
		doc[0] = new Doctor("bob", "longchemp", "111", null, "0777777", null, "7777777", null, null, "Montpellier", "34000");
		doc[1] = new Doctor("jaacques", "ruiz", null, null, null, "jac.ruiz@pasBon.fr", "111444", null, null,"Paris", "78000");
		this.doc= doc;

		//REAL DATA
		//DoctorFacade docFacade = new DoctorFacade();
		//this.doc = docFacade.getUncheckedDoctors();
	}

}