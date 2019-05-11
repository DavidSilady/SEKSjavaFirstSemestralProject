package controller;

import com.jfoenix.controls.JFXButton;
import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseUserController {
	
	@FXML
	private JFXButton exitButton;
	@FXML
	private ImageView inspectionImage;
	@FXML
	private ImageView auditorImage;
	@FXML
	private ImageView companyImage;
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private JFXButton chooseUserInspectionButton;
	
	@FXML
	private JFXButton chooseUserAuditorButton;
	
	@FXML
	private JFXButton chooseUserCompanyButton;
	
	private void assignImages() {
		try {
			Image img = new Image("/assets/inspection.png", 160, 0, true, true);
			inspectionImage.setImage(img);
			img = new Image("/assets/auditor.png", 160, 0, true, true);
			auditorImage.setImage(img);
			img = new Image("/assets/company.png", 160, 0, true, true);
			companyImage.setImage(img);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void initialize() {
		assignImages();
		
		Transition transition = new Transition();
		
		chooseUserAuditorButton.setOnMouseEntered(event -> transition.smoothScaleUp(auditorImage));
		chooseUserAuditorButton.setOnMouseExited(event -> transition.smoothScaleDown(auditorImage));
		chooseUserCompanyButton.setOnMouseEntered(event -> transition.smoothScaleUp(companyImage));
		chooseUserCompanyButton.setOnMouseExited(event -> transition.smoothScaleDown(companyImage));
		chooseUserInspectionButton.setOnMouseEntered(event -> transition.smoothScaleUp(inspectionImage));
		chooseUserInspectionButton.setOnMouseExited(event -> transition.smoothScaleDown(inspectionImage));
		
		exitButton.setOnMouseEntered(event -> transition.smoothScaleUp(exitButton, 1.0f, 1.3f));
		exitButton.setOnMouseExited(event -> transition.smoothScaleDown(exitButton, 1.3f, 1.0f));
		
		exitButton.setOnAction((ActionEvent event) -> {
			((Node) event.getSource()).getScene().getWindow().hide();
			System.exit(0);
		});
	}
	private SceneController sceneController = new SceneController();
	
	public void loadLoginCompany (javafx.event.ActionEvent actionEvent) throws Exception{
		UserController.castToCompanyController();
		sceneController.setScene(actionEvent, "login");
	}
	
	
	public void loadLoginAuditor (ActionEvent actionEvent) throws Exception{
		UserController.castToAuditorController();
		sceneController.setScene(actionEvent, "login");
	}
	
	public void loadLoginInspection (ActionEvent actionEvent) throws Exception{
		UserController.castToInspectionController();
		sceneController.setScene(actionEvent, "login");
	}
}
