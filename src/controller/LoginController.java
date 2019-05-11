package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.userController.CompanyUserController;
import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
	@FXML
	private JFXButton exitButton;
	
	@FXML
	private JFXButton loginChooseUserButton;
	
	@FXML
	private Label userIdentityLabel;
	
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
	private UserController activeUserController = UserController.getInstance();
	
	public JFXTextField getLoginMail () {
		return loginMail;
	}
	
	public JFXPasswordField getLoginPassword () {
		return loginPassword;
	}
	
	@FXML
	void initialize() {
		if (activeUserController.getClass().isInstance(new CompanyUserController())) {
			loginSignUpButton.setVisible(true);
		} else {
			loginSignUpButton.setVisible(false);
		}
		
		loginMail.requestFocus();
		
		userIdentityLabel.setText(activeUserController.getClass().getSimpleName().replace("UserController", ""));
		
		loginMail.setOnKeyPressed((event) -> {
			if(event.getCode() == KeyCode.ENTER) {
				loginPassword.requestFocus();
			}
		});
		
		Transition transition = new Transition();
		exitButton.setOnMouseEntered(event -> transition.smoothScaleUp(exitButton, 1.0f, 1.3f));
		exitButton.setOnMouseExited(event -> transition.smoothScaleDown(exitButton, 1.3f, 1.0f));
		exitButton.setOnAction((ActionEvent event) -> {
			((Node) event.getSource()).getScene().getWindow().hide();
			System.exit(0);
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
			activeUserController.loginUser(actionEvent, loginMail.getText(), loginPassword.getText());
		}
	}
	
	@FXML
	public void onEnterLogin (KeyEvent keyEvent) throws Exception{
		if(keyEvent.getCode() == KeyCode.ENTER) {
			if (isFilled()) {
				activeUserController.loginUser(keyEvent, loginMail.getText(), loginPassword.getText());
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
