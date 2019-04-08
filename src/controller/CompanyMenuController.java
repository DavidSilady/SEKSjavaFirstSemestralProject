package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class CompanyMenuController {
	@FXML
	private AnchorPane dynamicPane;
	
	@FXML void initialize() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/deviceList.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(deviceListTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void companyListButton (ActionEvent actionEvent) {
	}
	
	public void viewDeviceButton (ActionEvent actionEvent) {
	}
	
	
	
}
