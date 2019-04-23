package controller;

import com.jfoenix.controls.JFXButton;
import controller.userController.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.DataStorage;
import model.user.userTypes.CompanyUser;
import model.user.userTypes.InspectionUser;

import java.io.IOException;
import java.util.ArrayList;

public class CompanyMenuController {
	@FXML
	private AnchorPane root;
	
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
	private JFXButton expandButton;
	
	@FXML
	void expand(ActionEvent event) throws Exception{
	}
	
	private void showDeviceMenu (CompanyUser selectedItem) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/deviceMenu.fxml"));
		Pane companyListPane = (Pane) fxmlLoader.load();
		DeviceMenuController deviceMenuController = fxmlLoader.getController();
		deviceMenuController.setCompany(selectedItem);
		deviceMenuController.showDefault();
		try {
			root.getChildren().clear();
			root.getChildren().add(companyListPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	private TableColumn inspectionName;
	
	@FXML
	private AnchorPane dynamicPane;
	private ObservableList<CompanyUser> companyUsers = null;
	
	public void setRoot(AnchorPane root) {
		this.root = root;
	}
	public void setDynamicPane(AnchorPane dynamicPane) {
		this.dynamicPane = dynamicPane;
	}
	
	private void showDeviceList(CompanyUser company) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/deviceList.fxml"));
		Pane companyListPane = (Pane) fxmlLoader.load();
		DeviceMenuController deviceMenuController = fxmlLoader.getController();
		deviceMenuController.setCompany(company);
		try {//issue here
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(companyListPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showDefault() throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/companyList.fxml"));
		Pane companyListPane = (Pane) fxmlLoader.load();
		CompanyMenuController companyMenuController = fxmlLoader.getController();
		companyMenuController.setRoot(this.root);
		companyMenuController.setDynamicPane(this.dynamicPane);
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(companyListPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
		updateTableView();
	}
	
	private InspectionUser inspectionUser = null;
	//@SuppressWarnings("unchecked")
	@FXML void initialize() {
		try {
			inspectionUser = (InspectionUser) UserController.getInstance().getActiveUser();
			expandButton.setOnAction(event -> {
				try {
					if(tableView.getSelectionModel().getSelectedItem() != null)
						showDeviceMenu(tableView.getSelectionModel().getSelectedItem());
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		} catch (ClassCastException cce) {
			expandButton.setOnAction(event -> {
				try {
					if(tableView.getSelectionModel().getSelectedItem() != null)
						showDeviceList(tableView.getSelectionModel().getSelectedItem());
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		
		updateTableView();
	}
	
	public void showCompanyList (ActionEvent actionEvent) throws Exception{
		//temporary fix to reloading the selection model
		showDefault();
		updateTableView();
	}
	
	@SuppressWarnings("unchecked")
	private void updateTableView() {
		if (inspectionUser != null) {
			try {
				companyUsers = FXCollections.observableArrayList(inspectionUser.getCompanyUsers());
			} catch (NullPointerException e) {
				companyUsers = FXCollections.observableArrayList();
			}
		} else {
			try {
				companyUsers = FXCollections.observableArrayList((ArrayList<CompanyUser>) DataStorage.getInstance().getCompanyUserList());
			} catch (NullPointerException npe) {
				companyUsers = FXCollections.observableArrayList();
				System.out.println("No companies found!");
			}
		}
		
		name.setCellValueFactory(new PropertyValueFactory<CompanyUser, String>("name"));
		mail.setCellValueFactory(new PropertyValueFactory<CompanyUser, String>("mail"));
		ICO.setCellValueFactory(new PropertyValueFactory<CompanyUser, String>("ICO"));
		phone.setCellValueFactory(new PropertyValueFactory<CompanyUser, String>("phone"));
		inspectionName.setCellValueFactory(new PropertyValueFactory<CompanyUser, String>("inspectionName"));
		tableView.setItems(companyUsers);
	}
}
