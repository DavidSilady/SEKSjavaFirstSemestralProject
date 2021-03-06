package controller;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.notification.Notification;

/**
 * Used for changing scenes/stages/panes
 */
public class SceneController {
	public void setScene (javafx.event.ActionEvent actionEvent, String sceneName) throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/" + sceneName + ".fxml"));
		Parent signUpParent = loader.load();
		Scene signUpScene = new Scene(signUpParent);
		Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		window.setScene(signUpScene);
		window.show();
	}
	
	public void changeDynamicPane(Pane dynamicPane, String name) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + name + ".fxml"));
		Pane pane = (Pane) fxmlLoader.load();
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(pane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchStage (Event actionEvent, String sceneName) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + sceneName +".fxml"));
		((Node) actionEvent.getSource()).getScene().getWindow().hide();
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		//stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("SEKS | " + sceneName);
		stage.setScene(new Scene(root1, 1280, 720));
		stage.show();
	}
	
	public void popUp (Notification notification, String sceneName) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + sceneName + ".fxml"));
		Parent root = (Parent) fxmlLoader.load();
		NotificationController notificationController = fxmlLoader.getController();
		notificationController.setNotification(notification);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(new Scene(root, 520, 220));
		stage.getScene().setFill(Color.TRANSPARENT);
		stage.showAndWait();
	}
}
