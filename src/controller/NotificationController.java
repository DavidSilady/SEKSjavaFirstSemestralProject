package controller;

import com.jfoenix.controls.JFXButton;
import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.notification.Notification;
import model.notification.notificationTypes.Request;
import model.user.User;
import model.user.userTypes.InspectionUser;

public class NotificationController {
	@FXML
	private JFXButton hidePopUpButton;
	@FXML
	private Label typeLabel;
	@FXML
	private Label textLabel;
	
	private Notification notification;
	@FXML
	private JFXButton dismissButton;
	
	@FXML
	private JFXButton acceptButton;
	
	public void setNotification(Notification notification) {
		this.notification = notification;
		textLabel.setText(notification.getText());
		typeLabel.setText(notification.getClass().getSimpleName());
		try {
			Request request = (Request) notification;
			acceptButton.setOnAction(event -> {
				request.acceptAssignment((InspectionUser) UserController.getInstance().getActiveUser());
				request.dismiss(UserController.getInstance().getActiveUser());
			});
		}
		catch (ClassCastException cce) {
			acceptButton.setVisible(false);
			dismissButton.setLayoutX(208);
		}
	}
	
	@FXML
	void initialize() {
		hidePopUpButton.setOnAction((ActionEvent event) -> {
			((Node) event.getSource()).getScene().getWindow().hide();
		});
		
		dismissButton.setOnAction((ActionEvent event) -> {
			notification.dismiss(UserController.getInstance().getActiveUser());
			((Node) event.getSource()).getScene().getWindow().hide();
		});
	}
}
