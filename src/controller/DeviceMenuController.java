package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
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
import model.user.userTypes.AuditorUser;
import model.user.userTypes.CompanyUser;

/**
 * Controls the device management menu
 */
public class DeviceMenuController {
	
	@FXML
	private AnchorPane listRoot;
	@FXML
	private JFXButton markAsInspectedButton;
	@FXML
	private AnchorPane tableButtonPane;
	@FXML
	private AnchorPane dynamicPane;
	@FXML
	private AnchorPane root;
	
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
	
	public void setRoot(AnchorPane root) {
		this.root = root;
	}
	
	public void setDynamicPane(AnchorPane dynamicPane) {
		this.dynamicPane = dynamicPane;
	}
	
	public void showDefault() throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/deviceList.fxml"));
		Pane pane = (Pane) fxmlLoader.load();
		DeviceMenuController deviceMenuController = fxmlLoader.getController();
		deviceMenuController.setCompany(this.company);
		/*deviceMenuController.setRoot(this.root);
		deviceMenuController.setDynamicPane(this.dynamicPane);*/
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(pane);
		} catch (Exception e) {
			e.printStackTrace();
		}
		updateDeviceTable();
	}
	
	@FXML
	@SuppressWarnings("unchecked")
	void initialize()  {
		//RTTI
		if (UserController.getInstance().getActiveUser() instanceof CompanyUser) {
			company = (CompanyUser) UserController.getInstance().getActiveUser();
			try {
				markAsInspectedButton.setVisible(false);
			} catch (NullPointerException npe) {
				//
			}
		} else if (UserController.getInstance().getActiveUser() instanceof AuditorUser){
			//tableView.setSelectionModel(null);
			markAsInspectedButton.setText("Audit");
		}
		
		updateDeviceTable();
	}
	
	
	public void addDeviceScreen (ActionEvent actionEvent) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/addDevice.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		AddDeviceController addDeviceController = fxmlLoader.getController();
		addDeviceController.setCompany(this.company);
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(deviceListTable);
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
	
	
	public void setCompany (CompanyUser company) throws Exception{
		this.company = company;/*
		try {
			tableButtonPane.setVisible(false);
		} catch (NullPointerException npe) {
			//
		}*/
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
	
	public void markAsInspected (ActionEvent actionEvent) throws Exception {
		if(new ConfirmationPopUp().isConfirmed()) {
			try {
				activeUser.getActiveUser().updateDevice(tableView.getSelectionModel().getSelectedItem());
			} catch (NullPointerException npe) {
				//Might not be selected
			}
		}
		updateDeviceTable();
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/deviceList.fxml"));
		Pane pane = (Pane) fxmlLoader.load();
		DeviceMenuController deviceMenuController = fxmlLoader.getController();
		deviceMenuController.setCompany(this.company);
		/*deviceMenuController.setRoot(this.root);
		deviceMenuController.setDynamicPane(this.dynamicPane);*/
		try {
			listRoot.getChildren().clear();
			listRoot.getChildren().add(pane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	showDefault();
	}
	
	public void setDynamicDevicePane (Pane deviceList) {
		this.dynamicPane.getChildren().add(deviceList);
	}
}
