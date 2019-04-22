package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.DataStorage;
import model.user.userTypes.InspectionUser;

public class InspectorListController {
	@FXML
	private TableView inspectionListTable;
	
	private ObservableList<InspectionUser> inspectionUsers = null;
	
	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
		try {
			inspectionUsers = FXCollections.observableArrayList((ObservableList<InspectionUser>) DataStorage.getInstance().getInspectionUserList());
		} catch (Exception e) {
			System.out.println("InspectorList not found!");
			//e.printStackTrace();
		}
		inspectionListTable.setItems(inspectionUsers);
	}
}
