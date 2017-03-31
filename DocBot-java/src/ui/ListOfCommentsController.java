package ui;

import facade.CommentFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Comment;
import models.Doctor;
import services.Authentification;
import services.NavigationService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author BenAfonso
 */
public class ListOfCommentsController implements javafx.fxml.Initializable {

	/********************************************************
    *
    * 						DAO & Facade
    *
    ********************************************************/
	private CommentFacade commentsFacade;
	
	/********************************************************
    *
    * 						Variables
    *
    ********************************************************/
    @FXML
    TableView<Comment> commentsTable;
    @FXML
    TableColumn<Comment, String> dateCol;
    @FXML
    TableColumn<Comment, String> titleCol;
    @FXML
    TableColumn<Comment, String> contentCol;
    @FXML
    Label doctorNameLabel;
    @FXML
    Button addCommentButton;
   
    private List<Comment> comments;
    private Doctor doc;


    /**
     * Default constructor
     */
    public ListOfCommentsController() {

        this.commentsFacade = new CommentFacade();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateCol.setCellValueFactory(new PropertyValueFactory<Comment, String>("date"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Comment, String>("title"));
        contentCol.setCellValueFactory(new PropertyValueFactory<Comment, String>("content"));

    }



    /**
	 * Get the comments of a doctor
     * @return a list of comment object, the list of the doctor comments
     */
    public List<Comment> getCommentsOf(Doctor doctor) {
        this.doc = doctor;
        this.comments = this.commentsFacade.getCommentsOf(doctor);
        return this.comments;

    }


    /**
     * Display the comment of a doctor in the tableView
     */
    public void displayComments(Doctor doctor) { 	
        doctorNameLabel.setText(doctor.getFirstName() + " " + doctor.getLastName());
        commentsTable.getItems().setAll(this.getCommentsOf(doctor));
        addCommentButton.setVisible(this.commentsFacade.canAddComment(doctor.getId(), Authentification.getUser().getId()));

    }
    
    
    /********************************************************
    *
    * 						Navigation
    *
    ********************************************************/
    NavigationService nav = new NavigationService();
    
    public void goToAddComment() {
        nav.goToAddComments(doc);
    }
}
