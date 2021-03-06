package ui;

import facade.DoctorFacade;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Doctor;
import services.Authentification;
import services.NavigationService;

import java.time.LocalDate;

public class UpdateDoctorProfileController {
    DoctorFacade doctorFacade;
    /********************************************************
     *
     * 						Navigation
     *
     ********************************************************/
    NavigationService nav = new NavigationService();
    @FXML
    private TextField fnameField;
    @FXML
    private TextField lnameField;
    @FXML
    private TextField streetNumberField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField zipCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private DatePicker birthdayField;
    @FXML
    private Label errorField;
    @FXML
    private TextField phoneField;


    /**
     * Default constructor
     */
    public UpdateDoctorProfileController() {
        doctorFacade = new DoctorFacade();
    }

    /**
     * Update an account triggered on a button click
     */
    public void updateProfile() {
        boolean updateSuccessful = false;
        updateSuccessful = doctorFacade.update(Authentification.getUser().getEmail(), fnameField.getText(), lnameField.getText(), birthdayField.getValue(), phoneField.getText(), streetNumberField.getText(), streetField.getText(), cityField.getText(), zipCodeField.getText(), Authentification.getUser().getId());
        if (updateSuccessful) {
            goToProfile();
        } else {
            displayError("An error occurred please try again");
        }
    }

    /**
     * Back action trigerred on a button click
     */
    public void back() {
        goToProfile();
    }

    /**
     * Display an error on the view
     */
    public void displayError(String message) {
        errorField.setText(message);
    }

    /**
     *
     */
    public void displayInfo() {
        Doctor doc = doctorFacade.loadInfo(Authentification.getUser().getEmail());
        fnameField.setText(doc.getFirstName());
        lnameField.setText(doc.getLastName());
        streetField.setText(doc.getStreet());
        streetNumberField.setText(doc.getStreetNumber());
        cityField.setText(doc.getCity());
        zipCodeField.setText(doc.getZipCode());
        phoneField.setText(doc.getPhoneNumber());

        LocalDate date = new java.sql.Date(doc.getBirthday().getTime()).toLocalDate();
        birthdayField.setValue(date);

    }

    public void goToProfile() {
        nav.goToProfile();
    }

    public void goUpdatePassword() {
        nav.goUpdatePassword();
    }


}
