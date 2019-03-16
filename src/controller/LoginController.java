package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
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
	
	@FXML
	void initialize() {
		loginButton.setOnAction(event -> {
			System.out.println("Login button clicked!");
		});
	}
}
