package ui;

import java.net.URL;
import java.util.*;
import application.Main;
import facade.DoctorFacade;
import models.Doctor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import services.NavigationService;

/**
 * @author BenAfonso
 */
public class ListOfDoctorsController implements javafx.fxml.Initializable {

    @FXML TableView<Doctor> doctorsTable;
    @FXML TableColumn<Doctor, String> cityCol;
    @FXML TableColumn<Doctor, String> firstNameCol;
    @FXML TableColumn<Doctor, String> lastNameCol;
    @FXML TableColumn<Doctor, String> activeCol;
    @FXML TableColumn<Doctor, Doctor> seeDisponibilitiesCol;
    
    @FXML Button pendingDoctorsButton;
    @FXML Button allDoctorsButton;
    @FXML TextField cityFilterTextField;
    
    private DoctorFacade doctorFacade;
    

	private List<Doctor> list;
	private NavigationService nav;
	/**
	 * Inializer for the current view
	 */
	public void initialize(URL location, ResourceBundle resources) {
		
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("lastName"));
		cityCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("city"));
		activeCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("isValidated"));
		
		

		Callback<TableColumn<Doctor, Doctor>, TableCell<Doctor, Doctor>> cellFactory = //
                new Callback<TableColumn<Doctor, Doctor>, TableCell<Doctor, Doctor>>()
                {
                    @Override
                    public TableCell<Doctor, Doctor> call( final TableColumn<Doctor, Doctor> param )
                    {
                        final TableCell<Doctor, Doctor> cell = new TableCell<Doctor, Doctor>()
                        {

                            final Button btn = new Button( "See disponibilities" );

                            public void updateItem( Doctor item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                            {
                                            	Doctor doctor = getTableView().getItems().get( getIndex() );
                                            	System.out.println(doctor.getId());
                                            	nav.goToDisponibilitiesOf(doctor); // TEMPORARY
                                            	
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
                
        seeDisponibilitiesCol.setCellFactory(cellFactory);
		
		/*
		seeDisponibilitiesCol.setCellFactory(param -> new TableCell<Doctor, Doctor>() {
            private final Button seeDisponibilitiesButton = new Button("See disponibilities");

            protected void seeDisponibilities(Doctor doctor) {

                if (doctor == null) {
                    return;
                }

                setGraphic(seeDisponibilitiesButton);
                seeDisponibilitiesButton.setOnAction(event -> nav.goToMyDisponibilities());
                
            }            
        });
		*/
		
		
		doctorsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		doctorsTable.getColumns().get(0).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.2));
		doctorsTable.getColumns().get(1).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.3));
		doctorsTable.getColumns().get(2).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.2));
		doctorsTable.getColumns().get(3).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.1));
		doctorsTable.getColumns().get(4).prefWidthProperty().bind(doctorsTable.widthProperty().multiply(0.2));

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
    	this.nav = new NavigationService();
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
