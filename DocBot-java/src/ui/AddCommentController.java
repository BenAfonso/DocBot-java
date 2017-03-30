package ui;

import javafx.scene.control.TextArea;
import java.time.ZoneId;
import java.util.*;

import facade.CommentFacade;
import facade.DoctorFacade;
import facade.ScheduleFacade;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Doctor;
import services.Authentification;
import services.NavigationService;

/**
 * @author BenAfonso
 */
public class AddCommentController {

	@FXML private TextField titleField;
	@FXML private TextArea contentField;
	@FXML private Label errorField;

	@FXML private DatePicker dateField;
    /**
     * Default constructor
     */
    public AddCommentController() {
    	commentFacade=new CommentFacade();
    }

    /**
     * 
     */
    public DoctorFacade doctorFa;

    /**
     * 
     */
    public CommentFacade commentFacade;

    private Doctor doc;

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
		commentFacade.addComment(contentField.getText(), titleField.getText(), 5, date, doc.getId(),Authentification.getUser().getId());
    }
    
    /**
     * Display an success message into the view
     */
    public void displayValid() {
        // TODO implement here
    }

    public void setDoctor(Doctor doc){
    	this.doc=doc;
    }
    /**
     * Display an error message into the view
     */
    public void displayError() {
        // TODO implement here
    }
    

}