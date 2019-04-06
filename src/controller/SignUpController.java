package controller;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.UserController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.user.User;
import model.user.userTypes.CompanyUser;

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
	private JFXTextField signUpICO;
	private UserController userController = UserController.getInstance();
	private SceneController sceneController = new SceneController();
	
	@FXML
	void initialize() {
		signUpCompanyButton.setOnAction((ActionEvent event) -> {
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
		});
		
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
				if (signUpPassword.getText().equals(signUpConfirmPassword.getText())) {
					User activeUser = new CompanyUser();
					try {
						activeUser.signUpUser(event,
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
		});
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
