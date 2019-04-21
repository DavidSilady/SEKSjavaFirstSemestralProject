package controller;


import com.jfoenix.controls.JFXButton;
import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.notification.Notification;

import java.util.ArrayList;


public class UserInterfaceController {
	public FlowPane notificationPane;
	@FXML
	private AnchorPane dynamicPane;
	@FXML
	private JFXButton exitButton;
	@FXML
	private JFXButton notificationsInterfaceButton;
	@FXML
	private ScrollPane scrollPane;
	@FXML
	private ArrayList<JFXButton> notificationButtons = new ArrayList<>();
	
	
	private UserController activeUserController = UserController.getInstance();
	
	private void generateNotifications() {
		activeUserController.getActiveUser().updateNotifications();
		notificationPane.getChildren().clear();
		notificationButtons.clear();
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		ArrayList<Notification> notifications = activeUserController.getActiveUser().getNotifications();
		for (Notification notification: notifications) {
			JFXButton button = new JFXButton();
			button.setPrefWidth(300);
			button.setPrefHeight(50);
			button.setText(notification.getClass().getSimpleName());
			button.setOnAction(event -> {
				SceneController sceneController = new SceneController();
				try {
					sceneController.popUp(notification,"notificationPopUp");
					notification.dismiss(activeUserController.getActiveUser());
					generateNotifications();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			notificationButtons.add(button);
		}
		VBox notificationBox = new VBox();
		notificationBox.getChildren().addAll(notificationButtons);
		notificationPane.getChildren().add(notificationBox);
	}
	
	@FXML
	void initialize() {
		try {
			generateNotifications();
		} catch (NullPointerException npe) {
			System.out.println("Notification pane not found!");
		}
		
		notificationsInterfaceButton.setOnAction(event -> {
			try {
				generateNotifications();
			} catch (NullPointerException npe) {
				System.out.println("Notification pane not found!");
			}
		});
		
		try {
			activeUserController.showDefaultPane(dynamicPane);
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
