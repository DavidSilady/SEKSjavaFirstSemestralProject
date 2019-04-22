package controller;

import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.util.ResourceBundle;

import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.user.userTypes.CompanyUser;

public class InspectionMenuController {
	
	@FXML
	private AnchorPane tableButtonPane;
	
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
	
	@FXML
	private JFXButton revokeAssignmentButton;
	
	@FXML
	private Label inspectorMailLabel;
	
	@FXML
	private Label inspectorOrganizationLabel;
	
	@FXML
	private Label inspectorPhoneLabel;
	
	@FXML
	private Label inspectorIDLabel;
	
	@FXML
	private Label inspectorNameLabel;
	
	
	@FXML
	void revokeAssignment(ActionEvent event) {
	
	}
	
	private SceneController sceneController = new SceneController();
	private CompanyUser company;
	@FXML
	void initialize() {
		try {
			company = (CompanyUser) UserController.getInstance().getActiveUser();
		} catch (ClassCastException cce) {
			System.out.println("Not a company user!");
		}
		
	}
	public void setLabels(CompanyUser company) {
		try {
			inspectorNameLabel.setText(company.getInspectorUser().getName());
			inspectorOrganizationLabel.setText(company.getInspectorUser().getOrganizationName());
			inspectorMailLabel.setText(company.getInspectorUser().getMail());
			inspectorIDLabel.setText(company.getInspectorUser().getIdentificationNumber());
			inspectorPhoneLabel.setText(company.getInspectorUser().getPhone());
		} catch (NullPointerException npe) {
			System.out.println("Something not found!");
		}
	}
	
	@FXML
	private void showYourInspector (ActionEvent actionEvent) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/yourInspector.fxml"));
		Pane pane = (Pane) fxmlLoader.load();
		InspectionMenuController inspectionMenuController = fxmlLoader.getController();
		try {
			dynamicInspectionPane.getChildren().clear();
			dynamicInspectionPane.getChildren().add(pane);
			inspectionMenuController.setLabels(company);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(company.getInspectorUser().getOrganizationName());
	}
	@FXML
	private void showInspectorList (ActionEvent actionEvent) throws Exception {
		sceneController.changeDynamicPane(dynamicInspectionPane, "assignInspector");
		
	}
	
	
}
