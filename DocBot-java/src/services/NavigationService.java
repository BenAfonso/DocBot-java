package services;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Doctor;
import ui.*;

import java.io.IOException;


public class NavigationService {

    private static BorderPane root = new BorderPane();
    private static Stage primaryStage;
    private static MenuBar menuView;

    public NavigationService() {

    }

    /**
     * Just a root getter for the controller to use
     */
    public static BorderPane getRoot() {
        return root;
    }

    public static void changeView(AnchorPane pane) {
        BorderPane rootTest = new BorderPane();
        rootTest.setTop(menuView);
        rootTest.setCenter(pane);

        Scene scene = new Scene(rootTest, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void setPrimaryStage(Stage primaryStageToSet) {
        primaryStage = primaryStageToSet;
    }

    public static MenuBar getMenuView() {
        return menuView;
    }

    public static void setMenuView(MenuBar menuView) {
        NavigationService.menuView = menuView;
    }

    public void goToLogin() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../ui/LoginView.fxml"));
        AnchorPane loginView;
        try {
            loginView = loader.load();
            changeView(loginView);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goToRegisterPatientPage() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../ui/RegisterView.fxml"));
        AnchorPane registerView;
        try {
            registerView = loader.load();
            BorderPane rootTest = new BorderPane();
            rootTest.setCenter(registerView);

            Scene scene = new Scene(rootTest, 1000, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goToRegisterDoctorPage() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../ui/RegisterDoctorView.fxml"));
        AnchorPane registerDoctorView;
        try {
            registerDoctorView = loader.load();
            BorderPane rootTest = new BorderPane();
            rootTest.setCenter(registerDoctorView);

            Scene scene = new Scene(rootTest, 1000, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goToListOfDoctors() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../ui/ListOfDoctorsView.fxml"));
        AnchorPane listOfDoctorsView;

        try {
            listOfDoctorsView = loader.load();

            changeView(listOfDoctorsView);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    
    public void goToSeeHisAppointments() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../ui/SeeHisAppointments.fxml"));
        AnchorPane hisAppointments;

        try {
        	hisAppointments = loader.load();

            changeView(hisAppointments);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    public void goToSeePatients() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../ui/SeePatientsView.fxml"));
            AnchorPane seePatientsView;

            seePatientsView = loader.load();
            SeePatientsController listController = loader.getController();
            listController.displayPatients();

            changeView(seePatientsView);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goToListOfWaitingDoctors() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../ui/ValidateOrRejectDoctorRegistration.fxml"));
        AnchorPane listOfWaitingDoctorsView;

        try {
            listOfWaitingDoctorsView = loader.load();
            changeView(listOfWaitingDoctorsView);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goToAddDisponibility() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../ui/AddDisponibilityView.fxml"));
        AnchorPane AddDisponibilityView;

        try {
            AddDisponibilityView = loader.load();
            changeView(AddDisponibilityView);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goLogout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../ui/LoginView.fxml"));
            AnchorPane loginView;

            loginView = loader.load();

            BorderPane rootTest = new BorderPane();
            rootTest.setCenter(loginView);

            Scene scene = new Scene(rootTest, 1000, 600);
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Authentification.disconnect();
    }

    public void goUpdateProfile() {
        try {
            if (Authentification.isDoctor()) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("../ui/UpdateProfileDoctorView.fxml"));
                AnchorPane updateDoctorView;
                updateDoctorView = loader.load();
                UpdateDoctorProfileController docController = loader.getController();
                docController.displayInfo();
                changeView(updateDoctorView);


            } else {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("../ui/UpdateProfileView.fxml"));
                AnchorPane updateProfilView;

                updateProfilView = loader.load();
                UpdateProfileController patientController = loader.getController();
                patientController.displayInfo();
                changeView(updateProfilView);


            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goUpdatePassword() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../ui/UpdatePasswordView.fxml"));
            AnchorPane passwordView;

            passwordView = loader.load();

            changeView(passwordView);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goToMyDisponibilities() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../ui/ListOfDisponibilities.fxml"));
            AnchorPane listOfDisponibilitiesView;

            listOfDisponibilitiesView = loader.load();
            DisponibilitiesController listController = loader.getController();
            listController.displayDisponibilities((Doctor) Authentification.getUser());

            changeView(listOfDisponibilitiesView);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goToDisponibilitiesOf(Doctor doctor) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../ui/ListOfDisponibilities.fxml"));
            AnchorPane listOfDisponibilitiesView;

            listOfDisponibilitiesView = loader.load();
            DisponibilitiesController listController = loader.getController();
            listController.displayDisponibilities(doctor);

            changeView(listOfDisponibilitiesView);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goToProfile() {
        try {
            if (Authentification.isDoctor()) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("../ui/ProfileDoctorView.fxml"));
                AnchorPane profileDocView;

                profileDocView = loader.load();
                ProfileDoctorController docController = loader.getController();
                docController.displayInfo(Authentification.getUser().getEmail());
                changeView(profileDocView);


            } else {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("../ui/ProfileView.fxml"));
                AnchorPane profileView;

                profileView = loader.load();
                ProfileController patientController = loader.getController();
                patientController.displayInfo(Authentification.getUser().getEmail());
                changeView(profileView);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void goToProfileOf(Doctor doctor) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../ui/ProfileDoctorView.fxml"));
            AnchorPane profileDocView;
            profileDocView = loader.load();
            ProfileDoctorController docController = loader.getController();
            docController.displayInfo(doctor.getEmail());
            changeView(profileDocView);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void goToCommentsOf(Doctor doctor) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../ui/ListOfComments.fxml"));
            AnchorPane listOfCommentsView;

            listOfCommentsView = loader.load();
            ListOfCommentsController listController = loader.getController();
            listController.displayComments(doctor);
		changeView(listOfCommentsView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void goToDoctorRequestAppointment(){
		try {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("../ui/RequestAppointmentView.fxml"));
		AnchorPane listOfRequestView;

		listOfRequestView = loader.load();
		RequestAppointmentController requestController = loader.getController();
		requestController.displayRequests();

		changeView(listOfRequestView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public void goToAddComments(Doctor doctor) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../ui/AddCommentsView.fxml"));
            AnchorPane addCommentsView;

            addCommentsView = loader.load();
            AddCommentController addCommentsController = loader.getController();
            addCommentsController.setDoctor(doctor);

            changeView(addCommentsView);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}