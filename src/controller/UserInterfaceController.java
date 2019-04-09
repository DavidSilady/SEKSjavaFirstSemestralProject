package controller;


import com.jfoenix.controls.JFXButton;
import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.notification.Notification;

import java.util.ArrayList;


public class UserInterfaceController {
	@FXML
	private AnchorPane dynamicPane;
	@FXML
	private JFXButton exitButton;
	@FXML
	private VBox vBox;
	@FXML
	private ArrayList<JFXButton> notificationButtons = new ArrayList<>();
	
	
	private UserController activeUser = UserController.getInstance();
	
	private void generateNotifications() {
		ArrayList<Notification> notifications = activeUser.getActiveUser().getNotifications();
		for (Notification notification:
				notifications) {
			JFXButton button = new JFXButton();
			button.setPrefWidth(300);
			button.setPrefHeight(50);
			button.setText(notification.getClass().getName());
			button.setOnAction(event -> {
				SceneController sceneController = new SceneController();
				try {
					sceneController.popUp(notification,"notificationPopUp");
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			notificationButtons.add(button);
		}
		vBox.getChildren().addAll(notificationButtons);
	}
	
	@FXML
	void initialize() {
		generateNotifications();
		
		try {
			activeUser.showDefaultPane(dynamicPane);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		
		exitButton.setOnAction((ActionEvent event) -> {
			((Node) event.getSource()).getScene().getWindow().hide();
			System.exit(0);
		});
	}
	
	public void showDeviceList (ActionEvent actionEvent) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/deviceMenu.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(deviceListTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void companyListButton (ActionEvent actionEvent) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/companyMenu.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(deviceListTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void inspectionAuditorInterfaceButton (ActionEvent actionEvent) {
	}
}
