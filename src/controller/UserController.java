package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.user.User;
import model.user.User;

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
		User.getInstance().setToCompanyUser();
		sceneController.setScene(actionEvent, "login");
	}
	
	
	public void loadLoginAuditor (ActionEvent actionEvent) throws Exception{
		User.getInstance().setToAuditorUser();
		sceneController.setScene(actionEvent, "login");
	}
	
	public void loadLoginInspection (ActionEvent actionEvent) throws Exception{
		User.getInstance().setToInspectionUser();
		sceneController.setScene(actionEvent, "login");
	}
}
