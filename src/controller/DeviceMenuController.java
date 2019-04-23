package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import controller.userController.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.device.Device;
import model.user.userTypes.CompanyUser;


public class DeviceMenuController {
	@FXML
	private AnchorPane tableButtonPane;
	@FXML
	private AnchorPane dynamicDevicePane;
	
	private UserController activeUser = UserController.getInstance();
	
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private TableView<Device> tableView;
	
	private CompanyUser company;
	private ObservableList<Device> deviceObservableList = null;
	@FXML
	private TableColumn nameCol;
	@FXML
	private TableColumn lastInspectionCol;
	@FXML
	private TableColumn nextInspectionCol;
	@FXML
	private TableColumn lastAuditionCol;
	@FXML
	private TableColumn nextAuditionCol;
	@FXML
	private TableColumn serialNumCol;
	@FXML
	private TableColumn locationCol;
	
	public void setDynamicDevicePane(Node node) {
		dynamicDevicePane.getChildren().add(node);
	}
	public void showDefault() throws Exception{
		SceneController sceneController = new SceneController();
		sceneController.changeDynamicPane(dynamicDevicePane, "deviceList");
	}
	
	@FXML
	@SuppressWarnings("unchecked")
	void initialize()  {
		
		try {
			company = (CompanyUser) UserController.getInstance().getActiveUser();
		} catch (ClassCastException cce) {
			System.out.println("Not a company user!");
			tableView.setSelectionModel(null);
		}
		
		updateDeviceTable();
		
	}
	
	
	public void addDeviceScreen (ActionEvent actionEvent) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/addDevice.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		try {
			dynamicDevicePane.getChildren().clear();
			dynamicDevicePane.getChildren().add(deviceListTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deviceListScreen (ActionEvent actionEvent) throws Exception{
		showDefault();
		updateDeviceTable();
	}
	
	public void removeSelectedDevice (ActionEvent actionEvent) throws Exception{
		// Add a pop up for confirmation - later
		
		//Remove the selected device from the active company's device list
		//CompanyUser companyUser = (CompanyUser) activeUser.getActiveUser();
		if (new ConfirmationPopUp().isConfirmed()) {
			try {
				company.removeDevice(tableView.getSelectionModel().getSelectedItem());
			} catch (NullPointerException npe) {
				System.out.println("Device not selected!");
			}
		}
		
		/*
		//Update the table  //Probably a temporary solution
		SceneController sceneController = new SceneController();
		sceneController.setScene(actionEvent, "companyUserInterface");*/
		updateDeviceTable();
	}
	
	public void assignInspectorButton (ActionEvent actionEvent) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/inspectorList.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		try {
			dynamicDevicePane.getChildren().clear();
			dynamicDevicePane.getChildren().add(deviceListTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setCompany (CompanyUser company) {
		this.company = company;
		try {
			tableButtonPane.setVisible(false);
		} catch (NullPointerException npe) {
			//
		}
		updateDeviceTable();
	}
	
	@SuppressWarnings("unchecked")
	private void updateDeviceTable () {
		try {
			deviceObservableList = FXCollections.observableArrayList(company.getDeviceList());
		} catch (NullPointerException npe) {
			System.out.println("Device list not found!");
		}
		nameCol.setCellValueFactory(new PropertyValueFactory<Device, String>("name"));
		locationCol.setCellValueFactory(new PropertyValueFactory<Device, String>("location"));
		serialNumCol.setCellValueFactory(new PropertyValueFactory<Device, String>("serialNum"));
		lastInspectionCol.setCellValueFactory(new PropertyValueFactory<Date, String>("lastInspection"));
		nextInspectionCol.setCellValueFactory(new PropertyValueFactory<Date, String>("nextInspection"));
		lastAuditionCol.setCellValueFactory(new PropertyValueFactory<Date, String>("lastAudition"));
		nextAuditionCol.setCellValueFactory(new PropertyValueFactory<Date, String>("nextAudition"));
		tableView.setItems(deviceObservableList);
	}
}
