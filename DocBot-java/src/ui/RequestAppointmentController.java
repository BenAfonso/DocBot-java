package ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import facade.RequestAppointmentFacade;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Comment;
import models.Doctor;
import models.RequestAppointment;
import services.Authentification;

public class RequestAppointmentController implements javafx.fxml.Initializable {

	@FXML TableView<RequestAppointment> requestTableView;
    @FXML TableColumn<RequestAppointment, String> dateColumn;
    @FXML TableColumn<RequestAppointment, String> hourStartColumn;
    @FXML TableColumn<RequestAppointment, String> hourEndColumn;
    @FXML TableColumn<RequestAppointment, String> fnameColumn;
    @FXML TableColumn<RequestAppointment, String> lnameColumn;
    
    private RequestAppointmentFacade requestFacade;
    private List<RequestAppointment> requests;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dateColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("date"));
		hourStartColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("hourStartFull"));
		hourEndColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("hourEndFull"));
		fnameColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("firstName"));
		lnameColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("lastName"));
	}
	
	public RequestAppointmentController(){
		requestFacade = new RequestAppointmentFacade();		
	}
	

	/**
     * @return 
     * 
     */
    public List<RequestAppointment> getRequestOf() {
    	this.requests = this.requestFacade.getRequestAppointment(Authentification.getUser());
    	return this.requests;
    	
    }
    
    /**
     * 
     */
    public void displayRequests() {
 
    	requestTableView.getItems().setAll(this.getRequestOf());
		
    }
}
