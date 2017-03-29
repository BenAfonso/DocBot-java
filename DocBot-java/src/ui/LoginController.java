package ui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import facade.PersonFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Person;
import services.Authentification;
import services.NavigationService;


public class LoginController implements javafx.fxml.Initializable {
	@FXML private TextField usernameField;
	@FXML private TextField passwordField;
	@FXML private Label invalidCredential;


	@FXML private Button btnLogin;
	private PersonFacade userFacade;
	private Person user;
	private Stage prevStage;
	private Main mainApp;
	
	
	/**
	 * Inializer for the current view
	 */
	@Override	
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	/**
	 * Sets the previous stage
	 * @param stage
	 */
	public void setPrevStage(Stage stage){
		this.prevStage = stage;
	}
	
	
	public LoginController(){
		userFacade=new PersonFacade();
	}

	/**
	 * Set the main application
	 * @param main
	 */
	public void setMainApp(Main main){
	}

	
	/**
	 * Checks if the fields are correctly set, displays an error message 
	 * if invalid credentials.
	 * 
	 * @throws IOException
	 */
	public void login() throws IOException{

		user=null;
		String username = usernameField.getText();
		String password = passwordField.getText();


		// Check if the user can login (credentials)
		boolean canLogin=userFacade.login(username, password);

		if ( canLogin) {
			if(Authentification.isDoctor()){
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(Main.class.getResource("../ui/ProfileDoctorView.fxml"));
				AnchorPane ProfileDoctorView;
				FXMLLoader loaderMenu=new FXMLLoader();
				loaderMenu.setLocation(Main.class.getResource("../services/DoctorMenu.fxml"));
				MenuBar menuBar=loaderMenu.load();
				NavigationService.setMenuView(menuBar);
				try {
					ProfileDoctorView = (AnchorPane) loader.load();
					NavigationService.changeView(ProfileDoctorView);
					ProfileDoctorController controller=loader.getController();
					controller.displayInfo(Authentification.getUser().getEmail());
					controller.setPrevStage(prevStage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}else{
				FXMLLoader loaderMenu=new FXMLLoader();
				loaderMenu.setLocation(Main.class.getResource("../services/PatientMenu.fxml"));
				MenuBar menuBar=loaderMenu.load();
				NavigationService.setMenuView(menuBar);
				
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(Main.class.getResource("../ui/ProfileView.fxml"));
				AnchorPane ProfileView;
				try {
					ProfileView = (AnchorPane) loader.load();
					Scene scene=new Scene(ProfileView);
					prevStage.setScene(scene);
					prevStage.show();
					ProfileController controller=loader.getController();
					controller.displayInfo(Authentification.getUser().getEmail());
					controller.setPrevStage(prevStage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
		} else {
			invalidCredential.setText("Invalid credential");
		}

	} // Login
	
	public void goToRegisterPatientPage(){
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/RegisterView.fxml"));
		AnchorPane registerView;
		try {
			registerView = (AnchorPane) loader.load();
			Scene scene=new Scene(registerView);
			prevStage.setScene(scene);
			prevStage.show();
			RegisterPatientController controller=loader.getController();
			controller.setPrevStage(prevStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void goToRegisterDoctorPage(){
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/RegisterDoctorView.fxml"));
		AnchorPane registerDoctorView;
		try {
			registerDoctorView = (AnchorPane) loader.load();
			Scene scene=new Scene(registerDoctorView);
			prevStage.setScene(scene);
			prevStage.show();
			RegisterDoctorController controller=loader.getController();
			controller.setPrevStage(prevStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
