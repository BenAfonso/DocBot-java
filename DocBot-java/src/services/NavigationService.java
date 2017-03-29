package services;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.AddDisponibilityController;
import ui.LoginController;
import ui.ProfileController;
import ui.ProfileDoctorController;
import ui.UpdateDoctorProfileController;
import ui.UpdateProfileController;
import ui.UpdatePasswordController;
import ui.ValidateOrRejectDoctorRegistrationController;
import ui.ListOfDoctors.ListOfDoctorsController;

public class NavigationService {

	private Main mainApp;
	  private static BorderPane root = new BorderPane();
	  private static Stage primaryStage;
	  private static MenuBar menuView;

	  /**
	   * Just a root getter for the controller to use
	   */
	  public static BorderPane getRoot() {
	    return root;
	  }
	public NavigationService(){
		
	}
	
	public void goToListOfDoctors() {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/ListOfDoctors/ListOfDoctorsView.fxml"));
		AnchorPane listOfDoctorsView;
	
		try {
			listOfDoctorsView = (AnchorPane) loader.load();
			
			changeView(listOfDoctorsView);

			ListOfDoctorsController controller=loader.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	public void goToListOfWaitingDoctors() {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/ValidateOrRejectDoctorRegistration.fxml"));
		AnchorPane listOfWaitingDoctorsView;
	
		try {
			listOfWaitingDoctorsView = (AnchorPane) loader.load();
			changeView(listOfWaitingDoctorsView);
			ValidateOrRejectDoctorRegistrationController controller=loader.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void goToAddDisponibility() {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/AddDisponibilityView.fxml"));
		AnchorPane AddDisponibilityView;
	
		try {
			AddDisponibilityView = (AnchorPane) loader.load();
			changeView(AddDisponibilityView);
			AddDisponibilityController controller=loader.getController();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void goLogout(){
		try {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/loginView.fxml"));
		AnchorPane loginView;
		
			loginView = (AnchorPane) loader.load();
		
			BorderPane rootTest = new BorderPane();
			rootTest.setCenter(loginView);
			
			Scene scene = new Scene(rootTest, 1000, 600);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		LoginController controller=loader.getController();
		controller.setMainApp(mainApp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Authentification.disconnect();
	}
	
	public void goUpdateProfile(){
		try {
			if(Authentification.isDoctor()){
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(Main.class.getResource("../ui/UpdateProfileDoctorView.fxml"));
				AnchorPane updateDoctorView;
		
				updateDoctorView = (AnchorPane) loader.load();
		
				changeView(updateDoctorView);

				UpdateDoctorProfileController controller=loader.getController();
				controller.setMainApp(mainApp);
				controller.displayInfo();
			}else{
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(Main.class.getResource("../ui/UpdateProfileView.fxml"));
				AnchorPane updateProfilView;
		
				updateProfilView = (AnchorPane) loader.load();
				
				changeView(updateProfilView);
				
				UpdateProfileController controller=loader.getController();
				controller.setMainApp(mainApp);
				controller.displayInfo();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void goUpdatePassword(Stage prevStage){
		try {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/UpdatePasswordView.fxml"));
		AnchorPane passwordView;
		
		passwordView = (AnchorPane) loader.load();
		
		changeView(passwordView);
		UpdatePasswordController controller=loader.getController();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void goToProfile(){
		try {
			if(Authentification.isDoctor()){
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(Main.class.getResource("../ui/ProfileDoctorView.fxml"));
				AnchorPane profileDocView;
			
				profileDocView = loader.load();
				changeView(profileDocView);
				
				ProfileDoctorController controller=loader.getController();
				controller.displayInfo(Authentification.getUser().getEmail());
				controller.setMainApp(mainApp);
			}
			else{
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(Main.class.getResource("../ui/ProfileView.fxml"));
				AnchorPane profileView;
			
				profileView = (AnchorPane) loader.load();
				changeView(profileView);
				ProfileController controller=loader.getController();
				
				controller.displayInfo(Authentification.getUser().getEmail());
				controller.setMainApp(mainApp);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void changeView(AnchorPane pane){
		BorderPane rootTest = new BorderPane();
		rootTest.setTop(menuView);
		rootTest.setCenter(pane);
		
		Scene scene = new Scene(rootTest, 1000, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void setPrimaryStage(Stage primaryStageToSet) {
		primaryStage=primaryStageToSet;
	}
	public static MenuBar getMenuView() {
		return menuView;
	}
	public static void setMenuView(MenuBar menuView) {
		NavigationService.menuView = menuView;
	}

}
