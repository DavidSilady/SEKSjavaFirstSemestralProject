package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserController {
	
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
		sceneController.setScene(actionEvent, "login");
	}
	
	
	public void loadLoginAuditor (ActionEvent actionEvent) {
	}
	
	public void loadLoginInspection (ActionEvent actionEvent) {
	}
}
