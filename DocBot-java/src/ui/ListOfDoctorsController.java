package ui;

import application.Main;
import facade.DoctorFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import models.Doctor;
import services.NavigationService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author BenAfonso
 */
public class ListOfDoctorsController implements javafx.fxml.Initializable {

	/********************************************************
    *
    * 						DAO & Facade
    *
    ********************************************************/
	 private DoctorFacade doctorFacade;
	
	/********************************************************
	*
	* 						Variables
	*
	********************************************************/ 
    public List<Doctor> doctors;
    @FXML
    TableView<Doctor> doctorsTable;
    @FXML
    TableColumn<Doctor, String> cityCol;
    @FXML
    TableColumn<Doctor, String> firstNameCol;
    @FXML
    TableColumn<Doctor, String> lastNameCol;
    @FXML
    TableColumn<Doctor, Doctor> actionCol;
    @FXML
    Button pendingDoctorsButton;
    @FXML
    Button allDoctorsButton;
    @FXML
    TextField cityFilterTextField;
   
    private List<Doctor> list;


    /**
     * Default constructor
     */
    public ListOfDoctorsController() {
        this.doctorFacade = new DoctorFacade();
        this.getDoctors();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        firstNameCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("lastName"));
        cityCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("city"));


        Callback<TableColumn<Doctor, Doctor>, TableCell<Doctor, Doctor>> cellFactory = //
                new Callback<TableColumn<Doctor, Doctor>, TableCell<Doctor, Doctor>>() {
                    @Override
                    public TableCell<Doctor, Doctor> call(final TableColumn<Doctor, Doctor> param) {
                        final TableCell<Doctor, Doctor> cell = new TableCell<Doctor, Doctor>() {

                            final Button btn = new Button("Go to profile");

                            public void updateItem(Doctor item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction((ActionEvent event) ->
                                    {
                                        Doctor doctor = getTableView().getItems().get(getIndex());
                                        nav.goToProfileOf(doctor);

                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        actionCol.setCellFactory(cellFactory);


        doctorsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        doctorsTable.getColumns().get(0).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.3));
        doctorsTable.getColumns().get(1).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.25));
        doctorsTable.getColumns().get(2).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.25));
        doctorsTable.getColumns().get(3).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.25));

        this.displayDoctors();

    }


   

    /**
	 * Get the doctors of the application
     * @return a list of doctor object, the list of the doctor 
     */
    public List<Doctor> getDoctors() {
        this.list = this.doctorFacade.getDoctors();
        return this.list;

    }

    /**
     * Display the comment of a doctor in the tableView
     */
    public void displayDoctors() {	
        doctorsTable.getItems().setAll(this.getDoctors());
    }


    /********************************************************
    *
    * 						Navigation
    *
    ********************************************************/
    NavigationService nav = new NavigationService();

}
