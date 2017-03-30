package ui;

import application.Main;
import facade.DoctorFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Doctor;

import java.io.IOException;
import java.util.List;

public class ValidateOrRejectDoctorRegistrationController {

	private List<Doctor> doc;

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


	public ValidateOrRejectDoctorRegistrationController() {
		// TODO Auto-generated constructor stub
		super();

	}

	@FXML
	private void initialize() {
		loadDoctor();
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
			loadDoctor();
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
		System.out.println(selectedDoctor.getId());

		if (selectedDoctor != null) {
			docFacade.reject(selectedDoctor);
			loadDoctor();
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


	public void start(Stage primaryStage) {
		//Initilisation of the view
		StackPane page;
		try {
			page = FXMLLoader.load(Main.class.getResource("./ValidateOrRejectDoctorRegistration.fxml"));

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

	public void loadDoctor() {
		//Filling up the data
		this.getUncheckedDoctors();
		ObservableList<Doctor> data = FXCollections.observableArrayList();
		for (Doctor doc : this.doc) {
			data.add(doc);
		}


		table.setItems(data);

		firstNameColumn.setCellValueFactory(
				new PropertyValueFactory<Doctor, String>("firstName")
		);
		lastNameColumn.setCellValueFactory(
				new PropertyValueFactory<Doctor, String>("lastName")
		);
		siretColumn.setCellValueFactory(
				new PropertyValueFactory<Doctor, String>("siret")
		);
		cityColumn.setCellValueFactory(
				new PropertyValueFactory<Doctor, String>("city")
		);
		zipColumn.setCellValueFactory(
				new PropertyValueFactory<Doctor, String>("zipCode")
		);

	}

	public void getUncheckedDoctors() {

		//REAL DATA
		DoctorFacade docFacade = new DoctorFacade();
		this.doc = docFacade.getPendingDoctors();
	}

}
