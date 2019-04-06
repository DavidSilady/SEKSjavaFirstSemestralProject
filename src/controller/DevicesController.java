package controller;

import java.net.URL;
import java.util.ResourceBundle;

import controller.UserController.UserController;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.user.User;


public class DevicesController {
	
	private UserController activeUser = UserController.getInstance();
	
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private TableView<?> tableView;
	
	@FXML
	void initialize() {
	
	}
}
