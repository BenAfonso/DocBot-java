package ui.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.NavigationService;
import ui.Main;

import java.net.URL;
import java.util.*;

public class MenuViewController {

	public MenuViewController() {
		// TODO Auto-generated constructor stub
	}




		
	@FXML private Button listOfDoctorsButton;
	@FXML private Button profileButton;
	@FXML private Pane menuPane;
	@FXML private VBox menuVBox;

	
	/**
	 * Navigation tools
	 */
	NavigationService nav = new NavigationService();
	private Stage prevStage;
	
	
	/**
	 * Inializer for the current view
	 */
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	/**
	 * Set the main application
	 * @param main
	 */
	public void setMainApp(Main main){
	}






	public void setPrevStage(Stage prevStage) {
		this.prevStage=prevStage;
		
	}
	
	
	/********************************************************
	 * 
	 * 						Navigation
	 * 
	 ********************************************************/
	
	public void logout(){
		nav.goLogout(prevStage);
	}
	
	public void goToProfile(){
		nav.goToProfile(prevStage);
	}
	
	public void goToListOfDoctors() {
		nav.goToListOfDoctors(prevStage);
	}
	

}
