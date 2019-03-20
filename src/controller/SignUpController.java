package controller;

import com.jfoenix.controls.JFXButton;

import java.util.ArrayList;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Company;
import model.DataStorage;

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
	
	
	@FXML
	@SuppressWarnings("unchecked")
	void initialize() {
		signUpCompanyButton.setOnAction(event -> {
			if (signUpPassword.getText().equals(signUpConfirmPassword.getText()) ) {
				
				DataStorage userData = new DataStorage();
				ArrayList<Company> companyUserList = (ArrayList<Company>) userData.getCompanyUserList();
				Company company = new Company(
						signUpCompanyName.getText(),
						signUpICO.getText(),
						signUpEmail.getText(),
						signUpPhone.getText(),
						signUpPassword.getText()
				);
				try {
					companyUserList.add(company);
					userData.setCompanyUserList(companyUserList);
				} catch (NullPointerException npe) {
					System.out.println("Empty List!");
					return;
				}
				System.out.println("Signed up!");
			} else {
				signUpPassword.clear();
				signUpConfirmPassword.clear();
				signUpConfirmPassword.setPromptText("Passwords must match!");
			}
		});
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
