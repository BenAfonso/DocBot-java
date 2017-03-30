package ui;


import application.Main;
import facade.PersonFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import models.Person;
import services.Authentification;
import services.NavigationService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements javafx.fxml.Initializable {
    NavigationService nav = new NavigationService();
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label invalidCredential;
    @FXML
    private Button btnLogin;
    private PersonFacade userFacade;
    private Person user;


    public LoginController() {
        userFacade = new PersonFacade();
    }

    /**
     * Inializer for the current view
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Set the main application
     *
     * @param main
     */
    public void setMainApp(Main main) {
    }

    /**
     * Checks if the fields are correctly set, displays an error message
     * if invalid credentials.
     *
     * @throws IOException
     */
    public void login() throws IOException {

        user = null;
        String username = usernameField.getText();
        String password = passwordField.getText();


        // Check if the user can login (credentials)
        boolean canLogin = userFacade.login(username, password);

        if (canLogin) {
            if (Authentification.isDoctor()) {
                if (userFacade.isValidated(Authentification.getUser())) {
                    FXMLLoader loaderMenu = new FXMLLoader();
                    loaderMenu.setLocation(Main.class.getResource("../services/DoctorMenu.fxml"));
                    MenuBar menuBar = loaderMenu.load();
                    NavigationService.setMenuView(menuBar);
                    goProfile();
                } else {
                    displayError("Account is not validated");
                }

            } else if (Authentification.isAdministrator()) {

                FXMLLoader loaderMenu = new FXMLLoader();
                loaderMenu.setLocation(Main.class.getResource("../services/AdministratorMenu.fxml"));
                MenuBar menuBar = loaderMenu.load();
                NavigationService.setMenuView(menuBar);
                goListDoctorWaiting();

            } else {
                if (userFacade.isBlocked(Authentification.getUser())) {
                    FXMLLoader loaderMenu = new FXMLLoader();
                    loaderMenu.setLocation(Main.class.getResource("../services/PatientMenu.fxml"));
                    MenuBar menuBar = loaderMenu.load();
                    NavigationService.setMenuView(menuBar);
                    goProfile();
                } else {
                    displayError("Account is blocked");
                }

            }
        } else {
            displayError("Invalid credential");
        }

    } // Login

    public void displayError(String message) {
        invalidCredential.setText(message);
    }

    public void goRegisterDoctor() {
        nav.goToRegisterDoctorPage();
    }

    public void goRegisterPatient() {
        nav.goToRegisterPatientPage();
    }

    public void goProfile() {
        nav.goToProfile();
    }

    public void goListDoctorWaiting() {
        nav.goToListOfWaitingDoctors();
    }
}
