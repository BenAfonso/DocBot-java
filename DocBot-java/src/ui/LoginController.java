package ui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import facades.UserFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.User;


public class LoginController implements javafx.fxml.Initializable {
	@FXML private TextField usernameField;
	@FXML private TextField passwordField;
	@FXML private Label invalidCredential;


	@FXML private Button btnLogin;
	private UserFacade userFacade;
	private User user;
	private Stage prevStage;
	@Override	
	public void initialize(URL location, ResourceBundle resources) {


	}
	public void setPrevStage(Stage stage){
		this.prevStage = stage;
	}
	public LoginController(){
		System.out.println("Je créé ma façade");
		userFacade=new UserFacade();
	}

	public void setMainApp(Main main){
	}

	public void login() throws IOException{

		user=null;
		String username = usernameField.getText();
		String password = passwordField.getText();

		user=userFacade.getUser(username);

		// Check if the user can login (credentials)
		boolean canLogin=userFacade.login(username, password);

		if (user != null && canLogin) {

			Stage stage = new Stage();
			stage.setTitle("Connected");
			Pane myPane = null;
			myPane = FXMLLoader.load(getClass().getResource("logged.fxml"));
			Scene scene = new Scene(myPane);
			stage.setScene(scene);

			prevStage.close();

			stage.show();
		} else {
			invalidCredential.setText("Invalid credential");
		}

	} // Login

}
