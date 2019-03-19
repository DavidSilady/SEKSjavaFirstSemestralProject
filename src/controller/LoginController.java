package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class LoginController {
	@FXML
	private AnchorPane content;
	
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private JFXTextField loginUsername;
	
	@FXML
	private JFXButton loginSignUpButton;
	
	@FXML
	private JFXButton loginButton;
	
	@FXML
	private JFXPasswordField loginPassword;
	
	private String mail = new String();
	private String password = new String();
	
	
	@FXML
	void initialize() {
		loginUsername.setOnKeyPressed((event) -> {
			if(event.getCode() == KeyCode.ENTER) {
				loginPassword.requestFocus();
			}
		});
		
		loginPassword.setOnKeyPressed((event) -> {
			if(event.getCode() == KeyCode.ENTER) {
				loginSequence();
			}
		});
		
		loginButton.setOnAction(event -> {
			loginSequence();
		});
	}
	
	private void loginSequence() {
		if (isFilled()) {
			System.out.println("Login button clicked!");
			this.password = loginPassword.getText();
			this.mail = loginUsername.getText();
		}
	}
	
	private boolean isFilled() {
		boolean filled = true;
		if (loginUsername.getText() == null || loginUsername.getText().trim().isEmpty()) {
			loginUsername.setPromptText("You must enter an email!");
			filled = false;
		} else {
			loginUsername.setPromptText("Email");
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
	public void loadChooseSignUp (javafx.event.ActionEvent actionEvent) throws Exception{
		/*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/signUpCompany.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("Sign Up Company | SEKS");
		stage.setScene(new Scene(root1));
		stage.show();*/
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/signUpCompany.fxml"));
		Parent signUpParent = loader.load();
		Scene signUpScene = new Scene(signUpParent);
		Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		window.setScene(signUpScene);
		window.show();
	}
	
	@FXML
	public void onEnter (ActionEvent actionEvent) {
	
	}
}
