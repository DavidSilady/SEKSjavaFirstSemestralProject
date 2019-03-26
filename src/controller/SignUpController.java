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
import model.userTypes.Company;
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
	SceneController sceneController = new SceneController();
	
	@FXML
	@SuppressWarnings("unchecked")
	void initialize() {
		signUpCompanyButton.setOnAction(event -> {
			if (signUpPassword.getText().equals(signUpConfirmPassword.getText()) ) {
				ArrayList<Company> companyUserList = new ArrayList<>();
				if (DataStorage.getCompanyUserList() != null) {
					companyUserList = (ArrayList<Company>) DataStorage.getCompanyUserList();
				}
				Company company = new Company(
						signUpCompanyName.getText(),
						signUpICO.getText(),
						signUpEmail.getText(),
						signUpPhone.getText(),
						signUpPassword.getText()
				);
				try {
					companyUserList.add(company);
					DataStorage.setCompanyUserList(companyUserList);
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
		sceneController.setScene(actionEvent, "login");
	}
}