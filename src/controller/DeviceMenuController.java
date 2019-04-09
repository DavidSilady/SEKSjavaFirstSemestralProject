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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.device.Device;
import model.user.userTypes.CompanyUser;


public class DeviceMenuController {
	
	public AnchorPane dynamicDevicePane;
	public TableColumn nameCol;
	public TableColumn locationCol;
	public TableColumn serialNumCol;
	public TableColumn lastInspectionCol;
	public TableColumn nextInspectionCol;
	public TableColumn lastAuditionCol;
	public TableColumn nextAuditionCol;
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
	@SuppressWarnings("unchecked")
	void initialize() {
		try {
			company = (CompanyUser) UserController.getInstance().getActiveUser();
		} catch (ClassCastException cce) {
			System.out.println("Not a company user!");
			tableView.setSelectionModel(null);
		}
		updateTable();
		/*
		tableView.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {
			@Override
			public void changed (ObservableValue observable, Object oldValue, Object newValue) {
				if (tableView.getSelectionModel().getSelectedItem() != null) {
					selectedDevice = tableView.getSelectionModel().getSelectedItem();
					System.out.println(selectedDevice.getName() + " selected!");
				}
			}
		});*/
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
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/deviceList.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		try {
			dynamicDevicePane.getChildren().clear();
			dynamicDevicePane.getChildren().add(deviceListTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeSelectedDeviceButton (ActionEvent actionEvent) throws Exception{
		// Add a pop up for confirmation - later
		
		//Remove the selected device from the active company's device list
		CompanyUser companyUser = (CompanyUser) activeUser.getActiveUser();
		companyUser.removeDevice(tableView.getSelectionModel().getSelectedItem());
		
		//Update the table  //Probably a temporary solution
		SceneController sceneController = new SceneController();
		sceneController.setScene(actionEvent, "companyUserInterface");
		
	}
	
	public void addInspectorButton (ActionEvent actionEvent) {
	}
	
	public void setCompany (CompanyUser company) {
		this.company = company;
		updateTable();
	}
	
	@SuppressWarnings("unchecked")
	private void updateTable () {
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
