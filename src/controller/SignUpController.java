package controller;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SignUpController {
	
	@FXML
	private JFXTextField signUpEmail;
	
	@FXML
	private JFXPasswordField signUpConfirmPassword;
	
	@FXML
	private JFXButton signUpCompanyButton;
	
	@FXML
	private JFXButton signUpLoginButton;
	
	@FXML
	private JFXPasswordField signUpPassword;
	
	@FXML
	private JFXTextField signUpPhone;
	
	@FXML
	private JFXTextField signUpCompanyName;
	
	@FXML
	private JFXButton exitButton;
	
	@FXML
	private JFXTextField signUpICO;
	private UserController userController = UserController.getInstance();
	private SceneController sceneController = new SceneController();
	
	private void signUpSequence(Event event) {
		if (signUpPassword.getText().equals(signUpConfirmPassword.getText()) ) {
			try {
				userController.signUpUser(event,
						signUpCompanyName.getText(),
						signUpICO.getText(),
						signUpEmail.getText(),
						signUpPhone.getText(),
						signUpPassword.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			signUpPassword.clear();
			signUpConfirmPassword.clear();
			signUpConfirmPassword.setPromptText("Passwords must match!");
		}
	}
	
	@FXML
	void initialize() {
		signUpCompanyButton.setOnAction(this::signUpSequence);
		
		signUpCompanyName.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ENTER) {
				signUpEmail.requestFocus();
			}
		});
		signUpEmail.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ENTER) {
				signUpICO.requestFocus();
			}
		});
		signUpICO.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ENTER) {
				signUpPhone.requestFocus();
			}
		});
		signUpPhone.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ENTER) {
				signUpPassword.requestFocus();
			}
		});
		signUpPassword.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ENTER) {
				signUpConfirmPassword.requestFocus();
			}
		});
		
		signUpConfirmPassword.setOnKeyPressed((KeyEvent event) -> {
			if(event.getCode() == KeyCode.ENTER) {
				signUpSequence(event);
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
	
	@FXML
	public void loadChooseUser (ActionEvent actionEvent) throws Exception{
		sceneController.setScene(actionEvent, "chooseUser");
	}
	
	public void loadLoginScene (ActionEvent actionEvent) throws Exception {
		sceneController.setScene(actionEvent, "login");
	}
	
	public JFXTextField getSignUpEmail () {
		return signUpEmail;
	}
	
	public JFXButton getSignUpCompanyButton () {
		return signUpCompanyButton;
	}
	
	public JFXButton getSignUpLoginButton () {
		return signUpLoginButton;
	}
	
	public JFXPasswordField getSignUpPassword () {
		return signUpPassword;
	}
	
	public JFXTextField getSignUpPhone () {
		return signUpPhone;
	}
	
	public JFXTextField getSignUpCompanyName () {
		return signUpCompanyName;
	}
	
	public JFXTextField getSignUpICO () {
		return signUpICO;
	}
}
