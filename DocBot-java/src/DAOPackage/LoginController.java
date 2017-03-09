package DAOPackage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ModelPackage.User;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class LoginController implements javafx.fxml.Initializable {
	@FXML private TextField usernameField;
	@FXML private TextField passwordField;
	@FXML private Label invalidCredential;

	
	@FXML private Button btnLogin;
	private UserFacade userFacade;
	private User user;
	private MainLogin mainApp;
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
	public void setMainApp(MainLogin mainApp){

		this.mainApp=mainApp;
	}
	public void login() throws IOException{

		user=null;
		System.out.println(usernameField.getText());
		user=userFacade.login(usernameField.getText(), passwordField.getText());
		if(user != null){
			if(user.getMail().equals(usernameField.getText())){
				if(user.getMdp().equals(passwordField.getText())){
				       Stage stage = new Stage();
				       stage.setTitle("Connected");
				       Pane myPane = null;
				       myPane = FXMLLoader.load(getClass().getResource("logged.fxml"));
				       Scene scene = new Scene(myPane);
				       stage.setScene(scene);

				       prevStage.close();

				       stage.show();
				}else{
					invalidCredential.setText("Invalid credential");
				}
			}else{
				invalidCredential.setText("Invalid credential");
			}
		}else{
			invalidCredential.setText("Invalid credential");
	}
	
}
}
