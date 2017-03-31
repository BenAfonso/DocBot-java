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


public class AddCommentController {


	/********************************************************
    *
    * 						DAO & Facade
    *
    ********************************************************/
    public DoctorFacade doctorFa;
    public CommentFacade commentFacade;
    
    
    /********************************************************
    *
    * 						Variables
    *
    ********************************************************/
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
     * Create a new comment
     */
    public void addComment() {
        Date date = new Date();
        if (commentFacade.addComment(contentField.getText(), titleField.getText(), 5, date, getDoctor().getId(), Authentification.getUser().getId())) {
            goComments(getDoctor());
        }
    }

  
    /**
     * Get the doctor of the controller
     * @return object Doctor, the doctor of the controller
     */
    public Doctor getDoctor() {
        return this.doc;
    }

    /**
     * Set the doctor of the controller
     * @param doc doctor Object
     */
    public void setDoctor(Doctor doc) {
        this.doc = doc;
    }

    

    /********************************************************
    *
    * 						Navigation
    *
    ********************************************************/
   NavigationService nav = new NavigationService();
    public void goComments(Doctor doctor) {
        nav.goToCommentsOf(doctor);
    }

}