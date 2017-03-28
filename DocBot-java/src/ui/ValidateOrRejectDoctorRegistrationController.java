package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import facade.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	@FXML
	private TableColumn<Doctor, String> validateColumn;

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
				new PropertyValueFactory<Doctor,String>("zip_code")
				);
		validateColumn.setCellValueFactory( 
				new PropertyValueFactory<Doctor,String>("firstName")
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
		//DoctorFacade docFacade = new DoctorFacade();
		Doctor[] doc = new Doctor[2];
		doc[0] = new Doctor("bob", "longchemp", "111", null, "0777777", null, "7777777", null, null, "Montpellier", "34000");
		doc[1] = new Doctor("jaacques", "ruiz", null, null, null, "jac.ruiz@pasBon.fr", "111444", null, null,"Paris", "78000");
		this.doc= doc;
	}

}
