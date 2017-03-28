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
		nav.goLogout(getPrevStage());
	}
	
	public void goToProfile(){
		nav.goToProfile(getPrevStage());
	}
	

	public void goUpdateProfile(){
		nav.goUpdateProfile(getPrevStage());
	}
	
	public void goToListOfDoctors() {
		nav.goToListOfDoctors(getPrevStage());

	}

	public Stage getPrevStage() {
		return prevStage;
	}

	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}

}
