package controller;

import com.jfoenix.controls.JFXButton;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import controller.userController.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import model.user.userTypes.CompanyUser;

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
	
	@FXML
	private JFXButton revokeAssignmentButton;
	
	@FXML
	private Label inspectorMail;
	
	@FXML
	private Label inspectorOrganization;
	
	@FXML
	private Label inspectorPhone;
	
	@FXML
	private Label inspectorID;
	
	@FXML
	private Label inspectorName;
	
	
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
		
		yourInspectorButton.setOnAction(event -> {
			try {
				sceneController.changeDynamicPane(dynamicInspectionPane, "yourInspector");
				try {
					inspectorName.setText(company.getInspectorUser().getName());
					inspectorOrganization.setText(company.getInspectorUser().getOrganizationName());
					inspectorMail.setText(company.getInspectorUser().getMail());
					inspectorID.setText(company.getInspectorUser().getIdentificationNumber());
					inspectorPhone.setText(company.getInspectorUser().getPhone());
				} catch (NullPointerException npe) {
					System.out.println("Inspector not found!");
				}
				
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
