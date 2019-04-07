package controller;

import java.net.URL;
import java.util.ResourceBundle;

import controller.UserController.UserController;
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
import model.Device;
import model.user.userTypes.CompanyUser;


public class DevicesController {
	
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
	
	private CompanyUser user = (CompanyUser) UserController.getInstance().getActiveUser();
	
	
	@FXML
	@SuppressWarnings("unchecked")
	void initialize() {
		ObservableList<Device> deviceObservableList = null;
		try {
			deviceObservableList = FXCollections.observableArrayList(user.getDeviceList());
		} catch (NullPointerException npe) {
			System.out.println("Device list not found!");
		}
		
		nameCol.setCellFactory(new PropertyValueFactory<Device, String>("name"));
		locationCol.setCellFactory(new PropertyValueFactory<Device, String>("location"));
		serialNumCol.setCellFactory(new PropertyValueFactory<Device, String>("serialNum"));
		lastInspectionCol.setCellFactory(new PropertyValueFactory<Device, String>("lastInspection"));
		nextInspectionCol.setCellFactory(new PropertyValueFactory<Device, String>("nextInspection"));
		lastAuditionCol.setCellFactory(new PropertyValueFactory<Device, String>("lastAudition"));
		nextAuditionCol.setCellFactory(new PropertyValueFactory<Device, String>("nextAudition"));
		tableView.setItems(deviceObservableList);
	//	tableView.getColumns().addAll(nameCol, locationCol, serialNumCol, lastAuditionCol, nextAuditionCol, lastInspectionCol, nextInspectionCol);
		
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
}
