package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class InspectionMenuController {
	
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private JFXButton yourInspectorButton;
	
	@FXML
	private AnchorPane dynamicInspectionPane;
	
	@FXML
	private JFXButton assignNewInspectorButton;
	
	private SceneController sceneController = new SceneController();
	
	@FXML
	void initialize() {
		yourInspectorButton.setOnAction(event -> {
			try {
				sceneController.changeDynamicPane(dynamicInspectionPane, "yourInspector");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	
		assignNewInspectorButton.setOnAction(event -> {
			try {
				sceneController.changeDynamicPane(dynamicInspectionPane, "assignInspector");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
