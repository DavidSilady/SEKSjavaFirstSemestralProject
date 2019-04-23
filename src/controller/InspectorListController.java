package controller;

import com.jfoenix.controls.JFXButton;
import controller.userController.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DataStorage;
import model.Observable;
import model.user.userTypes.CompanyUser;
import model.user.userTypes.InspectionUser;

import java.io.IOException;
import java.util.ArrayList;

public class InspectorListController {
	@FXML
	private JFXButton inspectionTableButton;
	
	@FXML
	private TableColumn inspectionNameCol;
	
	@FXML
	private TableView<InspectionUser> inspectionListTable;
	
	@FXML
	private TableColumn inspectionOrganizationICOCol;
	private ObservableList<InspectionUser> inspectionUsers = null;
	
	private CompanyUser companyUser;
	
	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
		try {
			companyUser = (CompanyUser) UserController.getInstance().getActiveUser();
			inspectionTableButton.setOnAction(event -> {
				try {
					if( new ConfirmationPopUp().isConfirmed()) {
						companyUser.requestInspectorAssignment(inspectionListTable.getSelectionModel().getSelectedItem());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (ClassCastException cce) {
			System.out.println("Not a company user!");
			inspectionTableButton.setText("Remove Inspector");
			inspectionTableButton.setOnAction(event -> {
				try {
					if (new ConfirmationPopUp().isConfirmed()) {
						DataStorage.getInstance().getInspectionUserList().remove(inspectionListTable.getSelectionModel().getSelectedItem());
						updateTable();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
		
		updateTable();
	}
	
	@SuppressWarnings("unchecked")
	private void updateTable() {
		try {
			inspectionUsers =  FXCollections.observableArrayList((ArrayList<InspectionUser>) DataStorage.getInstance().getInspectionUserList());
		} catch (Exception e) {
			System.out.println("InspectorList not found!");
			//e.printStackTrace();
		}
		
		inspectionNameCol.setCellValueFactory(new PropertyValueFactory<InspectionUser, String>("name"));
		inspectionOrganizationICOCol.setCellValueFactory(new PropertyValueFactory<InspectionUser, String>("organizationICO"));
		inspectionListTable.setItems(inspectionUsers);
	}
}
