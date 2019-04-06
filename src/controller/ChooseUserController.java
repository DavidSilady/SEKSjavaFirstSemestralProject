package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import controller.UserController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ChooseUserController {
	
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
	
	@FXML
	void initialize() { }
	private SceneController sceneController = new SceneController();
	
	public void loadLoginCompany (javafx.event.ActionEvent actionEvent) throws Exception{
		UserController.getInstance().castToCompanyController();
		sceneController.setScene(actionEvent, "login");
	}
	
	
	public void loadLoginAuditor (ActionEvent actionEvent) throws Exception{
		UserController.getInstance().castToAuditorController();
		sceneController.setScene(actionEvent, "login");
	}
	
	public void loadLoginInspection (ActionEvent actionEvent) throws Exception{
		UserController.getInstance().castToInspectionController();
		sceneController.setScene(actionEvent, "login");
	}
}
