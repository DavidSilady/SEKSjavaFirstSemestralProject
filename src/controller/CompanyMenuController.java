package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.DataStorage;
import model.user.userTypes.CompanyUser;

import java.io.IOException;
import java.util.ArrayList;

public class CompanyMenuController {
	@FXML
	private TableColumn mail;
	
	@FXML
	private TableColumn ICO;
	
	@FXML
	private TableColumn phone;
	
	@FXML
	private TableColumn name;
	
	@FXML
	private TableView<CompanyUser> tableView;
	
	@FXML
	private TableColumn inspectionName;
	
	@FXML
	private AnchorPane dynamicPane;
	private ObservableList<CompanyUser> companyUsers = null;
	
	private void showCompanyList() throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/companyList.fxml"));
		Pane companyListPane = (Pane) fxmlLoader.load();
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(companyListPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showDeviceList(CompanyUser company) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/deviceList.fxml"));
		Pane companyListPane = (Pane) fxmlLoader.load();
		DeviceMenuController deviceMenuController = fxmlLoader.getController();
		deviceMenuController.setCompany(company);
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(companyListPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@FXML void initialize() {
		
		try {
			companyUsers = FXCollections.observableArrayList((ArrayList<CompanyUser>) DataStorage.getInstance().getCompanyUserList());
		} catch (NullPointerException npe) {
			companyUsers = FXCollections.observableArrayList();
			System.out.println("No companies found!");
		}
		
		name.setCellValueFactory(new PropertyValueFactory<CompanyUser, String>("name"));
		mail.setCellValueFactory(new PropertyValueFactory<CompanyUser, String>("mail"));
		ICO.setCellValueFactory(new PropertyValueFactory<CompanyUser, String>("ICO"));
		phone.setCellValueFactory(new PropertyValueFactory<CompanyUser, String>("phone"));
		inspectionName.setCellValueFactory(new PropertyValueFactory<CompanyUser, String>("inspectionName"));
	  	tableView.setItems(companyUsers);
	}
	
	public void companyListButton (ActionEvent actionEvent) throws Exception{
		showCompanyList();
	}
	
	public void viewDeviceButton (ActionEvent actionEvent) throws Exception{
		if (tableView.getSelectionModel().getSelectedItem() != null)
			showDeviceList(tableView.getSelectionModel().getSelectedItem());
	}
}
