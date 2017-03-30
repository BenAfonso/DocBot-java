package ui;

import application.Main;
import facade.PatientFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import models.Person;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SeePatientsController implements javafx.fxml.Initializable {

    @FXML
    TableView<Person> patientsTable;

    @FXML
    TableColumn<Person, String> firstNameCol;
    @FXML
    TableColumn<Person, String> lastNameCol;
    @FXML
    TableColumn<Person, Person> actionCol;


    private PatientFacade patientFacade;


    private List<Person> patients;

    /**
     * Default constructor
     */
    public SeePatientsController() {

        this.patientFacade = new PatientFacade();
    }

    /**
     * Inializer for the current view
     */
    public void initialize(URL location, ResourceBundle resources) {

        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));


        Callback<TableColumn<Person, Person>, TableCell<Person, Person>> cellFactory = //
                new Callback<TableColumn<Person, Person>, TableCell<Person, Person>>() {
                    @Override
                    public TableCell<Person, Person> call(final TableColumn<Person, Person> param) {
                        final TableCell<Person, Person> cell = new TableCell<Person, Person>() {

                            final Button btn = new Button("Block");

                            public void updateItem(Person item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction((ActionEvent event) ->
                                    {
                                        Person person = getTableView().getItems().get(getIndex());

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


    }

    /**
     * Set the main application
     *
     * @param main
     */
    public void setMainApp(Main main) {
    }

    /**
     * @return
     */
    public List<Person> getPatients() {
        // TODO implement here

        this.patients = this.patientFacade.getAllPatients();
        return this.patients;


    }

    /**
     *
     */
    public void displayPatients() {
        // TODO implement here
        patientsTable.getItems().setAll(this.getPatients());
    }




}
