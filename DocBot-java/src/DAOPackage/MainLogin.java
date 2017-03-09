package DAOPackage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainLogin extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {

		
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(MainLogin.class.getResource("./loginView.fxml"));
		AnchorPane loginView=(AnchorPane) loader.load();
		Scene scene=new Scene(loginView);
		primaryStage.setScene(scene);
		primaryStage.show();
		LoginController controller=loader.getController();
		controller.setPrevStage(primaryStage);
		controller.setMainApp(this);
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
