package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.DataStorage;
import model.user.userTypes.CompanyUser;

import java.io.IOException;
import java.util.ArrayList;

public class CompanyMenuController {
	@FXML
	private TableColumn<?, ?> mail;
	
	@FXML
	private TableColumn<?, ?> ICO;
	
	@FXML
	private TableColumn<?, ?> phone;
	
	@FXML
	private TableColumn<?, ?> name;
	
	@FXML
	private TableView<CompanyUser> tableView;
	
	@FXML
	private TableColumn<?, ?> inspectionName;
	
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
	
	@SuppressWarnings("unchecked")
	@FXML void initialize() {
		try {
			showCompanyList();
		} catch (IOException ioe) {
			System.out.println("IOE");
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			companyUsers = FXCollections.observableArrayList((ArrayList<CompanyUser>) DataStorage.getInstance().getCompanyUserList());
		} catch (NullPointerException npe) {
			companyUsers = FXCollections.observableArrayList();
			System.out.println("No companies found!");
		}
		tableView.setItems(companyUsers);
	}
	
	public void companyListButton (ActionEvent actionEvent) {
	}
	
	public void viewDeviceButton (ActionEvent actionEvent) {
	}
	
	
	
}
