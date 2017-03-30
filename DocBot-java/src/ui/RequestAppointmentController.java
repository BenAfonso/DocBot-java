package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.RequestAppointment;

public class RequestAppointmentController implements javafx.fxml.Initializable {

	@FXML TableView<RequestAppointment> requestTableView;
    @FXML TableColumn<RequestAppointment, String> dateColumn;
    @FXML TableColumn<RequestAppointment, String> hourStartColumn;
    @FXML TableColumn<RequestAppointment, String> hourEndColumn;
    @FXML TableColumn<RequestAppointment, String> fnameColumn;
    @FXML TableColumn<RequestAppointment, String> lnameColumn;
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
