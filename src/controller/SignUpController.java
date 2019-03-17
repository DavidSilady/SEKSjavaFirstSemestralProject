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

public class SignUpController {
	
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private JFXButton signUpLoginButton;
	
	@FXML
	private JFXButton signUpButton;
	
	
	@FXML
	void initialize() {
	
	}
	
	
	public void loadLoginScene (ActionEvent actionEvent) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		// Redirect to Sign Up scene (load the targeted .fxml scene)
		loader.setLocation(getClass().getResource("/view/login.fxml"));
		Parent newParent = loader.load();
		Scene newScene = new Scene(newParent);
		Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		window.setScene(newScene);
		window.show();
	}
}
