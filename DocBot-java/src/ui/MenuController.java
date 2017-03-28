package ui;

import javafx.stage.Stage;
import services.NavigationService;


public class MenuController {

	private Stage prevStage;
	NavigationService nav = new NavigationService();

	public MenuController() {
		// TODO Auto-generated constructor stub
	}
	
	public void logout(){
		nav.goLogout();
	}
	
	public void goToProfile(){
		nav.goToProfile();
	}
	

	public void goUpdateProfile(){
		nav.goUpdateProfile();
	}
	
	public void goToListOfDoctors() {
		nav.goToListOfDoctors();

	}

	public Stage getPrevStage() {
		return prevStage;
	}

	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}

}
