package ui;

import java.net.URL;
import java.util.*;
import application.Main;
import facade.CommentFacade;
import models.Comment;
import models.Doctor;
import models.Person;
import services.Authentification;
import services.NavigationService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author BenAfonso
 */
public class ListOfCommentsController implements javafx.fxml.Initializable {

    @FXML TableView<Comment> commentsTable;
    @FXML TableColumn<Comment, String> dateCol;
    @FXML TableColumn<Comment, String> titleCol;
    @FXML TableColumn<Comment, String> contentCol;
    @FXML Label doctorNameLabel;
    @FXML Button addCommentButton;


    
    private CommentFacade commentsFacade;
    
    private List<Comment> comments;
    private Doctor doc;

	/**
	 * Inializer for the current view
	 */
	public void initialize(URL location, ResourceBundle resources) {
		dateCol.setCellValueFactory(new PropertyValueFactory<Comment, String>("date"));
		titleCol.setCellValueFactory(new PropertyValueFactory<Comment, String>("title"));
		contentCol.setCellValueFactory(new PropertyValueFactory<Comment, String>("content"));
		
	}
	
	
	
    /**
     * Default constructor
     */
    public ListOfCommentsController() {

    	this.commentsFacade = new CommentFacade();
    }
    

	NavigationService nav = new NavigationService();

    public void goToAddComment(){
    	nav.goToAddComments(doc);
    }



    /**
     * @return 
     * 
     */
    public List<Comment> getCommentsOf(Doctor doctor) {
        // TODO implement here
    	this.doc=doctor;
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
		addCommentButton.setVisible(this.commentsFacade.canAddComment(doctor.getId(), Authentification.getUser().getId()));

    }
    

}
