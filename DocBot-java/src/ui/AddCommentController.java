package ui;

import facade.CommentFacade;
import facade.DoctorFacade;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Doctor;
import services.Authentification;
import services.NavigationService;

import java.util.Date;

/**
 * @author BenAfonso
 */
public class AddCommentController {

    /**
     *
     */
    public DoctorFacade doctorFa;
    /**
     *
     */
    public CommentFacade commentFacade;
    /********************************************************
     *
     * 						Navigation
     *
     ********************************************************/
    NavigationService nav = new NavigationService();
    @FXML
    private TextField titleField;
    @FXML
    private TextArea contentField;
    @FXML
    private Label errorField;
    @FXML
    private DatePicker dateField;
    private Doctor doc;

    /**
     * Default constructor
     */
    public AddCommentController() {
        commentFacade = new CommentFacade();
    }

    /**
     * Creates a new schedule
     */
    public void createSchedule() {
        // TODO implement here
    }

    /**
     * Creates a new Disponibility
     */
    public void addComment() {
        Date date = new Date();
        if (commentFacade.addComment(contentField.getText(), titleField.getText(), 5, date, getDoctor().getId(), Authentification.getUser().getId())) {
            goComments(getDoctor());
        }
    }

    /**
     * Display an success message into the view
     */
    public void displayValid() {
        // TODO implement here
    }

    public Doctor getDoctor() {
        return this.doc;
    }

    public void setDoctor(Doctor doc) {
        this.doc = doc;
    }

    /**
     * Display an error message into the view
     */
    public void displayError() {
        // TODO implement here
    }

    public void goComments(Doctor doctor) {
        nav.goToCommentsOf(doctor);
    }

}