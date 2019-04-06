package controller;


import com.jfoenix.controls.JFXButton;
import controller.UserController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.user.User;


public class InterfaceController {
	public AnchorPane dynamicPane;
	public JFXButton exitButton;
	
	private UserController activeUser = UserController.getInstance();
	
	@FXML
	void initialize() {
		exitButton.setOnAction((ActionEvent event) -> {
			((Node) event.getSource()).getScene().getWindow().hide();
			System.exit(0);
		});
	}
	
	public void showDeviceList (ActionEvent actionEvent) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/devices.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(deviceListTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
