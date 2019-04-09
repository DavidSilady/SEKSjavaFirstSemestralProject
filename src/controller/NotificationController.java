package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.notification.Notification;

import java.awt.event.ActionEvent;

public class NotificationController {
	private Notification notification = null;
	
	public void popUpNotification (Notification notification) throws Exception{
		setNotification(notification);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/notificationPopUp.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		//stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("Notification");
		stage.setScene(new Scene(root1, 300, 180));
		stage.show();
	}
	
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
}
