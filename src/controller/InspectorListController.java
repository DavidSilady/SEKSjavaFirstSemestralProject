package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DataStorage;
import model.Observable;
import model.user.userTypes.InspectionUser;

import java.util.ArrayList;

public class InspectorListController {
	@FXML
	private TableColumn inspectionNameCol;
	
	@FXML
	private TableView<InspectionUser> inspectionListTable;
	
	@FXML
	private TableColumn inspectionOrganizationICOCol;
	private ObservableList<InspectionUser> inspectionUsers = null;
	
	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
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
