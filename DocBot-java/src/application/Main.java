package application;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import services.NavigationService;
import ui.LoginController;

public class Main extends Application {
	  // Creating a static root to pass to the controller



	@Override
	public void start(Stage primaryStage) throws IOException {
		NavigationService.setPrimaryStage(primaryStage);

		
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/LoginView.fxml"));
		AnchorPane loginView= loader.load();
		
		NavigationService.getRoot().setCenter(loginView);
		
		Scene scene = new Scene(NavigationService.getRoot(), 1000, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
