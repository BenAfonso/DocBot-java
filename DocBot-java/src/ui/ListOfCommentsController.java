package ui;

import java.net.URL;
import java.util.*;
import application.Main;
import facade.CommentFacade;
import models.Comment;
import models.Doctor;
import models.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author BenAfonso
 */
public class ListOfCommentsController implements javafx.fxml.Initializable {

    @FXML TableView<Comment> commentsTable;
    @FXML TableColumn<Date, String> dateCol;
    @FXML TableColumn<Person, String> firstNameCol;
    @FXML TableColumn<Person, String> lastNameCol;
    @FXML TableColumn<Comment, String> ratingCol;
    @FXML TableColumn<Comment, String> contentCol;
    @FXML Label doctorNameLabel;

    
    private CommentFacade commentsFacade;
    
    private List<Comment> comments;


	/**
	 * Inializer for the current view
	 */
	public void initialize(URL location, ResourceBundle resources) {
		dateCol.setCellValueFactory(new PropertyValueFactory<Date, String>("date"));

		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		ratingCol.setCellValueFactory(new PropertyValueFactory<Comment, String>("rate"));
		contentCol.setCellValueFactory(new PropertyValueFactory<Comment, String>("content"));
		
	}
	
	
	/**
	 * Set the main application
	 * @param main
	 */
	public void setMainApp(Main main){
	}

	
    /**
     * Default constructor
     */
    public ListOfCommentsController() {

    	this.commentsFacade = new CommentFacade();
    }
    




    /**
     * @return 
     * 
     */
    public List<Comment> getCommentsOf(Doctor doctor) {
        // TODO implement here
    	this.comments = this.commentsFacade.getCommentsOf(doctor);
    	return this.comments;
    	
    }
    
    

    /**
     * 
     */
    public void displayComments(Doctor doctor) {
        // TODO implement here 	
    	doctorNameLabel.setText(doctor.getFirstName()+" "+doctor.getLastName());
		commentsTable.getItems().setAll(this.getCommentsOf(doctor));
    }
    

}
