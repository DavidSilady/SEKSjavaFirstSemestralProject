package controller;

import com.jfoenix.controls.JFXButton;
import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import model.notification.Notification;
import model.notification.notificationTypes.Request;
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
	
	/**
	 * Sets all the labels and button functionality according to the notification
	 */
	public void setNotification(Notification notification) {
		this.notification = notification;
		textLabel.setText(notification.getText());
		typeLabel.setText(notification.getClass().getSimpleName());
		
		//RTTI
		if (notification instanceof Request) {
			Request request = (Request) notification;
			acceptButton.setOnAction(event -> {
				request.acceptAssignment((InspectionUser) UserController.getInstance().getActiveUser());
				request.dismiss(UserController.getInstance().getActiveUser());
				((Node) event.getSource()).getScene().getWindow().hide();
			});
		}
		else {
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
