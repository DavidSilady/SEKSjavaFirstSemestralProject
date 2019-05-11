package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.userController.UserController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import model.user.userTypes.CompanyUser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddDeviceController {
	@FXML
	private ResourceBundle resources;
	
	
	@FXML
	private JFXComboBox<String> deviceTypeComboBox;
	
	@FXML
	private JFXTextField modField;
	
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
	private JFXButton addDeviceButton;
	
	private UserController activeUserController = UserController.getInstance();
	private CompanyUser company;
	public void setCompany(CompanyUser company) {
		this.company = company;
	}
	
	private void setToElectronicDevice() {
		modField.setPromptText("Voltage");
		
		addDeviceButton.setOnAction(event1 -> {
			try {
				if (isFilled() && new ConfirmationPopUp().isConfirmed()) {
					company.addElectronicDevice(nameField.getText(),
							locationField.getText(),
							serialNumField.getText(),
							Integer.parseInt(modField.getText()));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	private void setToGasDevice() {
		modField.setPromptText("Volume");
		
		addDeviceButton.setOnAction(event1 -> {
			try {
				if (isFilled() && new ConfirmationPopUp().isConfirmed()) {
					company.addGasDevice(nameField.getText(),
							locationField.getText(),
							serialNumField.getText(),
							Integer.parseInt(modField.getText()));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	private boolean isFilled() {
		boolean filled = true;
		if (modField.getText() == null || modField.getText().trim().isEmpty()) {
			decideDeviceType();
			modField.setPromptText("You must enter a " + modField.getPromptText() + "!");
			filled = false;
		}
		if (nameField.getText() == null || nameField.getText().trim().isEmpty()) {
			nameField.setPromptText("You must enter a name!");
			filled = false;
		} else {
			nameField.setPromptText("Name");
		}
		return filled;
	}
	
	private void decideDeviceType() {
		if (deviceTypeComboBox.getValue().equals("Electronic Device")) {
			setToElectronicDevice();
		} else if (deviceTypeComboBox.getValue().equals("Gas Device")) {
			setToGasDevice();
		}
	}
	
	private void setFieldToIntOnly(JFXTextField textField) {
		textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
			                    String newValue) {
				if (!newValue.matches("\\d*")) {
					textField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
	}
	
	@FXML
	void initialize() {
		try {
			company = (CompanyUser) activeUserController.getActiveUser();
		} catch (ClassCastException cce) {
			//
		}
		ObservableList<String> deviceOptions =
				FXCollections.observableArrayList(
						"Electronic Device",
						"Gas Device"
				);
		deviceTypeComboBox.setItems(deviceOptions);
		
		deviceTypeComboBox.setOnAction(event -> decideDeviceType());
		
		setFieldToIntOnly(modField);
	}
}