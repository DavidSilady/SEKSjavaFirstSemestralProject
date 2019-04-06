package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.UserController.CompanyUserController;
import controller.UserController.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.DataStorage;
import model.Device;
import model.user.User;
import model.user.userTypes.CompanyUser;


public class DevicesController {
	
	private UserController activeUser = UserController.getInstance();
	
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private TableView<Device> tableView;
	
	private CompanyUser user = (CompanyUser) UserController.getInstance().getUser();
	
	
	@FXML
	void initialize() {
		try {
			ObservableList<Device> deviceObservableList = FXCollections.observableArrayList(user.getDeviceList());
		} catch (NullPointerException npe) {
			System.out.println("Device list not found!");
		}
	
	}
}
