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
import javafx.stage.Stage;
import model.DataStorage;
import model.Listable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController {
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
	
	@FXML
	void initialize() {
		loginMail.setOnKeyPressed((event) -> {
			if(event.getCode() == KeyCode.ENTER) {
				loginPassword.requestFocus();
			}
		});
		
		loginPassword.setOnKeyPressed((event) -> {
			if(event.getCode() == KeyCode.ENTER) {
				login(DataStorage.getCompanyUserList());
			}
		});
		
		loginButton.setOnAction(event -> login(DataStorage.getCompanyUserList()));
	}
	
	private void login(ArrayList<? extends Listable> userList) {
		if (isFilled()) {
			System.out.println("Login button clicked!");
			for (Listable temp: userList) {
				System.out.println(temp.getMail());
				if (temp.getMail().equals(loginMail.getText())) {
					if (temp.getPassword().equals(loginPassword.getText())) {
						User activeUser = (User) temp;
						System.out.println("Logged in!\n Welcome " + activeUser.getName() + "!");
					} else {
						System.out.println("Wrong Password!");
					}
				}
			}
			
		}
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
	
	public void loadChooseUser (ActionEvent actionEvent) throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/chooseUser.fxml"));
		Parent signUpParent = loader.load();
		Scene signUpScene = new Scene(signUpParent);
		Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		window.setScene(signUpScene);
		window.show();
	}
}
