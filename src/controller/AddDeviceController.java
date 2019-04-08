package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.user.userTypes.CompanyUser;

import java.net.URL;
import java.util.ResourceBundle;

public class AddDeviceController {
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private JFXTextField locationField;
	
	@FXML
	private JFXTextField serialNumField;
	
	@FXML
	private JFXTextField nameField;
	
	@FXML
	private JFXTextField noteField;
	
	@FXML
	private JFXComboBox<?> deviceTypeComboBox;
	
	private UserController activeUser = UserController.getInstance();
	
	@FXML
	void addDevice(ActionEvent event) {
		CompanyUser company = (CompanyUser) activeUser.getActiveUser();
		company.addDevice(nameField.getText(), locationField.getText(), serialNumField.getText());
	}
	
	@FXML
	void initialize() {
	}
}