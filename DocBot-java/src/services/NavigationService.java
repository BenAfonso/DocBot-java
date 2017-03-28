package services;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.LoginController;
import ui.Main;
import ui.ProfileController;
import ui.ProfileDoctorController;
import ui.UpdateDoctorProfileController;

public class NavigationService {

	private Main mainApp;
	
	public NavigationService(){
		
	}
	
	public void goLogout(Stage prevStage){
		try {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/loginView.fxml"));
		AnchorPane loginView;
		
			loginView = (AnchorPane) loader.load();
		
		Scene scene=new Scene(loginView);
		prevStage.setScene(scene);
		prevStage.show();
		LoginController controller=loader.getController();
		controller.setPrevStage(prevStage);
		controller.setMainApp(mainApp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Authentification.disconnect();
	}
	
	public void goUpdateProfileDoctor(Stage prevStage){
		try {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/UpdateProfilDoctorView.fxml"));
		AnchorPane updateDoctorView;
		
		updateDoctorView = (AnchorPane) loader.load();
		
		Scene scene=new Scene(updateDoctorView);
		prevStage.setScene(scene);
		prevStage.show();
		UpdateDoctorProfileController controller=loader.getController();
		controller.setPrevStage(prevStage);
		controller.setMainApp(mainApp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void goToProfile(Stage prevStage){
		try {
			if(Authentification.isDoctor()){
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(Main.class.getResource("../ui/ProfileDoctorView.fxml"));
				AnchorPane profileDocView;
			
				profileDocView = (AnchorPane) loader.load();
			
				Scene scene=new Scene(profileDocView);
				prevStage.setScene(scene);
				prevStage.show();
				ProfileDoctorController controller=loader.getController();
				controller.displayInfo(Authentification.getUser().getEmail());
				controller.setPrevStage(prevStage);
				controller.setMainApp(mainApp);
			}
			else{
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(Main.class.getResource("../ui/ProfileView.fxml"));
				AnchorPane profileView;
			
				profileView = (AnchorPane) loader.load();
			
				Scene scene=new Scene(profileView);
				prevStage.setScene(scene);
				prevStage.show();
				ProfileController controller=loader.getController();
				controller.displayInfo(Authentification.getUser().getEmail());
				controller.setPrevStage(prevStage);
				controller.setMainApp(mainApp);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
