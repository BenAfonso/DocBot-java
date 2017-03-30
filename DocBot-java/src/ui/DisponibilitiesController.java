package ui;

import facade.RequestAppointmentFacade;
import facade.ScheduleFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import models.Disponibility;
import models.Doctor;
import models.Schedule;
import services.Authentification;
import services.NavigationService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


/**
 * @author BenAfonso
 */
public class DisponibilitiesController implements javafx.fxml.Initializable {

    public ScheduleFacade scheduleFa;
    public RequestAppointmentFacade requestAppointmentFacade;
    @FXML
    Label doctorNameLabel;
    @FXML
    Label errorLabel;
    @FXML
    TableView<Disponibility> disponibilitiesTable;
    @FXML
    TableColumn<Disponibility, String> dayCol;
    @FXML
    TableColumn<Disponibility, String> hourEndCol;
    @FXML
    TableColumn<Disponibility, String> hourStartCol;
    @FXML
    TableColumn<Disponibility, String> descriptionCol;
    @FXML
    TableColumn<Disponibility, Disponibility> makeAnAppointmentCol;
    @FXML
    Button addDisponibility;
    /********************************************************
     *
     * 						Navigation
     *
     ********************************************************/
    NavigationService nav = new NavigationService();

    /**
     * Default constructor
     */
    public DisponibilitiesController() {
        scheduleFa = new ScheduleFacade(); // To refactor
        requestAppointmentFacade = new RequestAppointmentFacade();
    }

    public void initialize(URL location, ResourceBundle resources) {
        if (!Authentification.isDoctor()) {
            addDisponibility.setVisible(false);
        }
        dayCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("date"));
        hourEndCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("hourEndFull"));
        hourStartCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("hourStartFull"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<Disponibility, String>("description"));

        Callback<TableColumn<Disponibility, Disponibility>, TableCell<Disponibility, Disponibility>> cellFactory = //
                new Callback<TableColumn<Disponibility, Disponibility>, TableCell<Disponibility, Disponibility>>() {
                    @Override
                    public TableCell<Disponibility, Disponibility> call(final TableColumn<Disponibility, Disponibility> param) {
                        final TableCell<Disponibility, Disponibility> cell = new TableCell<Disponibility, Disponibility>() {

                            final Button btn = new Button("Make appointment !");

                            public void updateItem(Disponibility disponibility, boolean empty) {
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction((ActionEvent event) ->
                                    {
                                        Disponibility disp = getTableView().getItems().get(getIndex());
                                        System.out.println(disp.getId());
                                        makeRequestAppointment(disp);

                                    });
                                    setGraphic(btn);
                                    if (Authentification.isDoctor() || scheduleFa.canMakeRequest(getTableView().getItems().get(getIndex()).getId(), Authentification.getUser().getId())) {
                                        btn.setVisible(false);
                                    }
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        makeAnAppointmentCol.setCellFactory(cellFactory);

    }

    public List<Disponibility> getDisponibilities(Doctor doctor) {

        return scheduleFa.getDoctorDisponibilities(doctor);

    }

    /**
     * Get a schedule for the current doctor
     *
     * @return Schedule
     */
    public Schedule getHisSchedule() {
        // TODO implement here

        return null;
    }

    public void makeRequestAppointment(Disponibility disp) {
        boolean result = this.requestAppointmentFacade.createNewRequest(disp, Authentification.getUser());
        if (!result) {
            throw new Error("Request appointment failed");
        }
    }

    /**
     * Delete a schedule (Event with button) documentation later
     */
    public void deleteSchedule() {
        // TODO implement here
    }

    public void displayDisponibilities(Doctor doctor) {
        doctorNameLabel.setText(doctor.getLastName());
        disponibilitiesTable.getItems().setAll(this.getDisponibilities(doctor));
    }

    public void goAddDisponibility() {
        nav.goToAddDisponibility();
    }

}