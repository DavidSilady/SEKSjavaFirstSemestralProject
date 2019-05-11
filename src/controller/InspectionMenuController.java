package controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import controller.userController.InspectionUserController;
import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.user.userTypes.CompanyUser;
import model.user.userTypes.InspectionUser;

/**
 * Controls the inspection management menu
 */
public class InspectionMenuController {
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private JFXTextField inspectionNameField;
	
	@FXML
	private JFXTextField inspectionMailField;
	
	@FXML
	private JFXTextField inspectionPhoneNumberField;
	
	@FXML
	private JFXTextField inspectionOrganizationField;
	
	
	@FXML
	private AnchorPane tableButtonPane;
	
	@FXML
	private JFXButton addInspectionUserButton;
	
	@FXML
	private Label inspectorIDLabel;
	
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
	private Label inspectorNameLabel;
	
	@FXML
	private JFXButton showAddInspectorPaneButton;
	
	
	@FXML
	void revokeAssignment(ActionEvent event) throws IOException {
		if (new ConfirmationPopUp().isConfirmed()) {
			company.revokeAssignment();
		}
	}
	
	private SceneController sceneController = new SceneController();
	private CompanyUser company;
	
	@FXML
	void initialize() {
		try {
			company = (CompanyUser) UserController.getInstance().getActiveUser();
			try {
				showAddInspectorPaneButton.setVisible(false);
			} catch (NullPointerException npe) {
				//
			}
		} catch (ClassCastException cce) {
			System.out.println("Not a company user!");
			try {
				yourInspectorButton.setVisible(false);
			} catch (NullPointerException npe) {
				//
			}
		}
	}
	
	private void setLabels(CompanyUser company) {
		try {
			inspectorNameLabel.setText(company.getInspectorUser().getName());
			inspectorOrganizationLabel.setText(company.getInspectorUser().getOrganizationICO());
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
	}
	@FXML
	private void showInspectorList (ActionEvent actionEvent) throws Exception {
		sceneController.changeDynamicPane(dynamicInspectionPane, "inspectorList");
	}
	
	@FXML
	private void showAddInspectorPane(ActionEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/signUpInspection.fxml"));
		Pane pane = (Pane) fxmlLoader.load();
		InspectionMenuController inspectionMenuController = fxmlLoader.getController();
		try {
			dynamicInspectionPane.getChildren().clear();
			dynamicInspectionPane.getChildren().add(pane);
			inspectionMenuController.inspectorIDLabel.setText(new InspectionUser().generateIdentificationNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void addNewInspectionUser(ActionEvent event) throws Exception {
		if (new ConfirmationPopUp().isConfirmed()) {
			String id;
			try {
				id = inspectorIDLabel.getText();
			} catch (NullPointerException npe) {
				id = new InspectionUser().generateIdentificationNumber();
			}
			InspectionUserController inspectionUserController = new InspectionUserController();
			inspectionUserController.signUpUser(event, inspectionNameField.getText(),
					inspectionOrganizationField.getText(),
					inspectionMailField.getText(),
					inspectionPhoneNumberField.getText(),
					id
			);
			inspectorIDLabel.setText(new InspectionUser().generateIdentificationNumber());
		}
	}
	
}
