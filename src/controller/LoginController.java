package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DataStorage;
import model.Listable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController {
	@FXML
	public JFXButton loginChooseUserButton;
	
	@FXML
	private AnchorPane content;
	
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private JFXTextField loginMail;
	
	@FXML
	private JFXButton loginSignUpButton;
	
	@FXML
	private JFXButton loginButton;
	
	@FXML
	private JFXPasswordField loginPassword;
	
	private SceneController sceneController = new SceneController();
	User activeUser = new CompanyUser();
	
	@FXML
	void initialize() {
		loginMail.setOnKeyPressed((event) -> {
			if(event.getCode() == KeyCode.ENTER) {
				loginPassword.requestFocus();
			}
		});
	}
	
	private boolean isFilled() {
		boolean filled = true;
		if (loginMail.getText() == null || loginMail.getText().trim().isEmpty()) {
			loginMail.setPromptText("You must enter an email!");
			filled = false;
		} else {
			loginMail.setPromptText("Email");
		}
		
		if (loginPassword.getText() == null || loginPassword.getText().trim().isEmpty()) {
			loginPassword.setPromptText("You must enter a password!");
			filled = false;
		} else {
			loginPassword.setPromptText("Password");
		}
		
		return filled;
	}
	
	@FXML
	public void buttonLogin (ActionEvent actionEvent) throws Exception{
		if (isFilled()) {
			activeUser.loginUser(actionEvent, loginMail.getText(), loginPassword.getText());
		}
	}
	
	@FXML
	public void onEnterLogin (KeyEvent keyEvent) throws Exception{
		if(keyEvent.getCode() == KeyCode.ENTER) {
			if (isFilled()) {
				activeUser.loginUser(keyEvent, loginMail.getText(), loginPassword.getText());
			}
		}
	}
	
	@FXML
	public void loadChooseUser (ActionEvent actionEvent) throws Exception{
		sceneController.setScene(actionEvent, "chooseUser");
	}
	@FXML
	public void loadSignUp (ActionEvent actionEvent) throws Exception{
		sceneController.setScene(actionEvent, "signUpCompany");
	}
}
