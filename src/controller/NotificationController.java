package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.notification.Notification;

public class NotificationController {
	@FXML
	private JFXButton hidePopUpButton;
	@FXML
	private Label typeLabel;
	@FXML
	private Label textLabel;
	
	private Notification notification;
	
	public void setNotification(Notification notification) {
		this.notification = notification;
		textLabel.setText(notification.getText());
		typeLabel.setText(notification.getClass().getSimpleName());
	}
	
	@FXML
	void initialize() {
		hidePopUpButton.setOnAction((ActionEvent event) -> {
			((Node) event.getSource()).getScene().getWindow().hide();
		});
	}
}
