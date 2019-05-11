/**
 * Sample Skeleton for 'userSettings.fxml' Controller Class
 */

package controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;

import controller.userController.UserController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class UserDataController {
	
	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;
	
	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;
	
	@FXML // fx:id="reminderDelayButton"
	private JFXTextField reminderDelayField; // Value injected by FXMLLoader
	
	@FXML
	void setReminderDelay(ActionEvent event) {
		UserController.getInstance().getActiveUser().setDismissLimitInDays(Integer.parseInt(reminderDelayField.getText()));
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
	
	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		setFieldToIntOnly(reminderDelayField);
	}
}
