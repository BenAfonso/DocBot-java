package ui;

import facade.RequestAppointmentFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import models.Disponibility;
import models.RequestAppointment;
import services.Authentification;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RequestAppointmentController implements javafx.fxml.Initializable {

    @FXML
    TableView<RequestAppointment> requestTableView;
    @FXML
    TableColumn<RequestAppointment, String> dateColumn;
    @FXML
    TableColumn<RequestAppointment, String> hourStartColumn;
    @FXML
    TableColumn<RequestAppointment, String> hourEndColumn;
    @FXML
    TableColumn<RequestAppointment, String> fnameColumn;
    @FXML
    TableColumn<RequestAppointment, String> lnameColumn;
    @FXML
    TableColumn<RequestAppointment, RequestAppointment> acceptColumn;
    @FXML
    TableColumn<RequestAppointment, RequestAppointment> rejectColumn;



    private RequestAppointmentFacade requestFacade;
    private List<RequestAppointment> requests;

    public RequestAppointmentController() {
        requestFacade = new RequestAppointmentFacade();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("date"));
        hourStartColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("hourStartFull"));
        hourEndColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("hourEndFull"));
        fnameColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("firstName"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<RequestAppointment, String>("lastName"));
        Callback<TableColumn<RequestAppointment, RequestAppointment>, TableCell<RequestAppointment, RequestAppointment>> cellFactory = //
                new Callback<TableColumn<RequestAppointment, RequestAppointment>, TableCell<RequestAppointment, RequestAppointment>>() {
                    @Override
                    public TableCell<RequestAppointment, RequestAppointment> call(final TableColumn<RequestAppointment, RequestAppointment> param) {
                        final TableCell<RequestAppointment, RequestAppointment> cell = new TableCell<RequestAppointment, RequestAppointment>() {

                            final Button btn = new Button("Accept !");

                            public void updateItem(RequestAppointment requestAppointment, boolean empty) {
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction((ActionEvent event) ->
                                    {
                                    	RequestAppointment req = getTableView().getItems().get(getIndex());
                                        System.out.println(req.getDispoId());
                                        System.out.println(req.getPersonid());

                                        accept(req);
                                        displayRequests();
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
         acceptColumn.setCellFactory(cellFactory);
                Callback<TableColumn<RequestAppointment, RequestAppointment>, TableCell<RequestAppointment, RequestAppointment>> cellRejectFactory = //
                        new Callback<TableColumn<RequestAppointment, RequestAppointment>, TableCell<RequestAppointment, RequestAppointment>>() {
                            @Override
                            public TableCell<RequestAppointment, RequestAppointment> call(final TableColumn<RequestAppointment, RequestAppointment> param) {
                                final TableCell<RequestAppointment, RequestAppointment> cell = new TableCell<RequestAppointment, RequestAppointment>() {

                                    final Button btn = new Button("reject !");

                                    public void updateItem(RequestAppointment requestAppointment, boolean empty) {
                                        if (empty) {
                                            setGraphic(null);
                                            setText(null);
                                        } else {
                                            btn.setOnAction((ActionEvent event) ->
                                            {
                                            	RequestAppointment req = getTableView().getItems().get(getIndex());
                                                System.out.println(req.getId());

                                                reject(req);
                                                displayRequests();
                                            });
                                            setGraphic(btn);
                                            setText(null);
                                        }
                                    }
                                };
                                return cell;
                            }
                        };
                        rejectColumn.setCellFactory(cellRejectFactory);

    }
    public void accept(RequestAppointment req) {
        boolean result = this.requestFacade.accept(req);
        if (!result) {
            throw new Error("Request appointment failed");
        }
    }
    public void reject(RequestAppointment req) {
        boolean result = this.requestFacade.reject(req.getId());
        if (!result) {
            throw new Error("Request appointment failed");
        }
    }

    /**
     * @return
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
