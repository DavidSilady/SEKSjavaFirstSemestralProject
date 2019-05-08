package controller;


import com.jfoenix.controls.JFXButton;
import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DataStorage;
import model.notification.Notification;
import model.notification.notificationTypes.Warning;

import java.io.IOException;
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
	
	@FXML
	private void showInspectionMenu(ActionEvent actionEvent) throws Exception {
		SceneController sceneController = new SceneController();
		sceneController.changeDynamicPane(dynamicPane, "inspectionMenu");
	}
	
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
			button.setText(notification.getClass().getSimpleName() + " from " + notification.getAggregatorName());
			if (notification instanceof Warning) {
				button.setBackground(new Background(new BackgroundFill(Color.web("#ffb300"), CornerRadii.EMPTY, Insets.EMPTY)));
			}
			button.setOnAction(event -> {
				SceneController sceneController = new SceneController();
				try {
					sceneController.popUp(notification,"notificationPopUp");
					//notification.dismiss(activeUserController.getActiveUser());
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
		
		try {
			activeUserController.showDefaultPane(dynamicPane);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		
		notificationsInterfaceButton.setOnAction(event -> {
			try {
				generateNotifications();
			} catch (NullPointerException npe) {
				System.out.println("Notification pane not found!");
			}
		});
		
		exitButton.setOnAction((ActionEvent event) -> {
			DataStorage.getInstance().serializeAll();
			((Node) event.getSource()).getScene().getWindow().hide();
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/chooseUser.fxml"));
			Parent root1 = null;
			try {
				root1 = (Parent) fxmlLoader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(new Scene(root1, 700, 400));
			stage.show();
			//System.exit(0);
		});
	}
	
	public void showDeviceList (ActionEvent actionEvent) throws Exception{
		activeUserController.showDefaultPane(dynamicPane);
	}
	
	public void showCompanyList (ActionEvent actionEvent) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/companyMenu.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		CompanyMenuController companyMenuController = fxmlLoader.getController();
		companyMenuController.showDefault();
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(deviceListTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
